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
		
		//uuid �߱�
		UUID uuid = UUID.randomUUID();
	
		// ������ ���ϸ� = UUID + �����̸�		
		String savedName = uuid.toString() + "_" + originalName;
		
		//���ε��� ���丮(��¥�� ����) ����
		String savedPath = calcPath(uploadPath);
		
		//���� ���(������ ���ε� ��� + ��¥�� ���), ���ϸ��� �޾� ���� ��ü ����
		File target = new File(uploadPath + savedPath, savedName);
		
		//�ӽ� ���丮�� ���ε�� ������ ������ ���丮�� ����
		FileCopyUtils.copy(fileData, target);
		
		//������� �����ϱ� ���� ������ Ȯ���� �˻�
		//���ϸ��� aaa.bbb.ccc.jpg�� ��� ������ ��ħǥ�� ã�� ����
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		//�̹��� ������ ����� ���
		
		if(MediaUtils.getMediaType(formatName) != null) {
			//����� ����
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			
		}	else {
			//������ ����
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;	
		
	}
	
	private static String calcPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		//File.separator : ���丮 ������(\\)
		//����, ex) \\2017
		
		String yearPath = File.separatorChar +  new DecimalFormat("00").format(cal.get(Calendar.YEAR));
		System.out.println(yearPath);
		// ��, ex) \\2017\\03
		
		String monthPath = yearPath + File.separatorChar+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		System.out.println(monthPath);
		
		//��¥, ex) \\2017\\03\\01
		String datePath = monthPath + File.separatorChar + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println(datePath);
		
		//���丮 ���� �޼��� ȣ��
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	
	
	private static void makeDir(String uploadPath, String... paths) {
		
		if(new File(paths[paths.length - 1]).exists()) {
			return;
		}
		
		//���͸��� �������� ������
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			//���͸��� �������� ������
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	
	//����� ����
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		//�̹����� �б� ���� ����
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		
		// 100�ȼ� ������ ����� ����
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		//������� �̸��� ����(�������ϸ� 's_'�� ����)
		String thumbnailName = uploadPath + path + File.separatorChar + "s_" + fileName;
		File newFile = new File(thumbnailName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		//����� ����
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		//������� �̸��� ������
		return thumbnailName.substring(uploadPath.length()).replace(File.pathSeparatorChar,  '/');
		
	}
	
	
	//������ ����
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		//�������� �̸�
		String iconName = uploadPath + path + File.separator + fileName;
		
		//������ �̸��� ����
		//File.separatorChar : ���͸� ������
		//������ \, ���н�(������) /
		return iconName.substring(uploadPath.length()).replace(File.pathSeparatorChar, '/');
	
	}
	
	
	
	public String decoder(String base64) throws Exception {
	
		Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Matcher matcher = pattern.matcher(base64); //base64 ���뿡�� �̹��� �±� ����	
		
		//base64���� �������� ���� ����
		Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
		Matcher regexMatcher = regex.matcher(base64);
		
		String uploadPath;
		String path = "C:\\Comma\\upload\\";
		String originalName = "";
		String content = "";
		while(matcher.find()){ // �̹��� �±׸� ã�Ҵٸ�,,
			System.out.println("�̹����±� : " + matcher.group(1));
			
			if (regexMatcher.find()) {
				originalName = regexMatcher.group(); //���� �̸� ����
				System.out.println("originalName : " + originalName);
			}
			String data = matcher.group(1).split(",")[1]; //base64 �̹��� �ڵ� ����
			System.out.println(data);
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(data); //����Ʈ�� ��ȯ
			
			uploadPath = path;
			String uploadFileResult = uploadFile(uploadPath, originalName, imageBytes);
			
			//����Ʈ�� �̹����� ��η� ���� 
			//System.out.println("matcher.group(1)" + matcher.group(1));
			//System.out.println("uploadFileResult" + uploadFileResult);
			
			//System.out.println("base64 : " + base64);
			
			content = base64.replace(matcher.group(1), "img" + uploadFileResult);
			System.out.println("content : " + content);
			
		}		 
	
		return content;
		
	}
	
	
}
