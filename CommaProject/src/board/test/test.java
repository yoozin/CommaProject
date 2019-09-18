package board.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import board.service.BoardService;
import board.vo.BoardVO;

public class test {

	public static void main(String[] args) {
	
		ApplicationContext context = 
				new GenericXmlApplicationContext("config/root-context.xml");
		
		BoardService bs = context.getBean("boardService", BoardService.class);
		
//		bs.createBoard(new BoardVO(1, "안녕하세요", "조희림", "하하하하", 0));
		
		System.out.println(bs.selectOneBoard(1));
		
	}

}
