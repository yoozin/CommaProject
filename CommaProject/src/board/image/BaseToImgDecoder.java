package board.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;


public class BaseToImgDecoder {


	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		
		//uuid 발급
		UUID uuid = UUID.randomUUID();
	
		// 저장할 파일명 = UUID + 원본이름		
		String savedName = uuid.toString() + "_" + originalName;
		
		//업로드할 디렉토리(날짜별 폴더) 생성
		String savedPath = calcPath(uploadPath);
		
		//파일 경로(기존의 업로드 경로 + 날짜별 경로), 파일명을 받아 파일 객체 생성
		File target = new File(uploadPath + savedPath, savedName);
		
		//임시 디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(fileData, target);
		
		//썸네일을 생성하기 위한 파일의 확장자 검사
		//파일명이 aaa.bbb.ccc.jpg일 경우 마지막 마침표를 찾기 위해
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		//이미지 파일은 썸네일 사용
		
		if(MediaUtils.getMediaType(formatName) != null) {
			//썸네일 생성
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			
		}	else {
			//아이콘 생성
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;	
		
	}
	
	private static String calcPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		//File.separator : 디렉토리 구분자(\\)
		//연도, ex) \\2017
		
		String yearPath = File.separatorChar +  new DecimalFormat("00").format(cal.get(Calendar.YEAR));
		System.out.println(yearPath);
		// 월, ex) \\2017\\03
		
		String monthPath = yearPath + File.separatorChar+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		System.out.println(monthPath);
		
		//날짜, ex) \\2017\\03\\01
		String datePath = monthPath + File.separatorChar + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println(datePath);
		
		//디렉토리 생성 메서드 호출
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	
	
	private static void makeDir(String uploadPath, String... paths) {
		
		if(new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		//디렉터리가 존재하지 않으면
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			//디렉터리가 존재하지 않으면
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	
	//썸네일 생성
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		//이미지를 읽기 위한 버퍼
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		// 100픽셀 단위의 썸네일 생성
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		//썸네일의 이름을 생성(원본파일명에 's_'를 붙임)
		String thumbnailName = uploadPath + path + File.separatorChar + "s_" + fileName;
		File newFile = new File(thumbnailName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		//썸네일 생성
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		//썸네일의 이름을 리턴함
		return thumbnailName.substring(uploadPath.length()).replace(File.pathSeparatorChar,  '/');
		
	}
	
	
	//아이콘 생성
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		//아이콘의 이름
		String iconName = uploadPath + path + File.separator + fileName;
		
		//아이콘 이름을 리턴
		//File.separatorChar : 디렉터리 구분자
		//윈도우 \, 유닉스(리눅스) /
		return iconName.substring(uploadPath.length()).replace(File.pathSeparatorChar, '/');
	
	}
	
	
	
	public String decoder(String base64) throws Exception {
	
		Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Matcher matcher = pattern.matcher(base64); //base64 내용에서 이미지 태그 추출	
		
		//base64에서 오리지날 네임 추출
		Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
		Matcher regexMatcher = regex.matcher(base64);
		
		String uploadPath;
		String path = "C:\\Comma\\upload\\";
		String originalName = "";
		String content = "";
		while(matcher.find()){ // 이미지 태그를 찾았다면,,
			System.out.println("이미지태그 : " + matcher.group(1));
			
			if (regexMatcher.find()) {
				originalName = regexMatcher.group(); //파일 이름 추출
				System.out.println("originalName : " + originalName);
			}
			String data = matcher.group(1).split(",")[1]; //base64 이미지 코드 추출
			System.out.println(data);
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(data); //바이트로 변환
			
			uploadPath = path;
			String uploadFileResult = uploadFile(uploadPath, originalName, imageBytes);
			
			//컨텐트에 이미지는 경로로 저장 
			//System.out.println("matcher.group(1)" + matcher.group(1));
			//System.out.println("uploadFileResult" + uploadFileResult);
			
			//System.out.println("base64 : " + base64);
			
			content = base64.replace(matcher.group(1), "img" + uploadFileResult);
			System.out.println("content : " + content);
			
		}		 
	
		return content;
		
	}
	
	
}
