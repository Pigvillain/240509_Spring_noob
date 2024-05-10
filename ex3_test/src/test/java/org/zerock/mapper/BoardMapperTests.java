package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testTest() {
		log.info("test...:");
	}
	
	@Test
	public void testGetList() {
		
		mapper.getList();
		
	}
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(5);
		cri.setAmount(10);
		
		List<BoardVO>list = mapper.getListWithPaging(cri);
		
		list.forEach(a -> log.info(a));
	}
	
	
	@Test
	public void testInsert() {
		
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("Title 1");
		boardVO.setContent("Content 1");
		boardVO.setWriter("User00");
		
		mapper.insert(boardVO);
		
		log.info(boardVO);
	}

	@Test
	public void testInsertSelectKey() {
		
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("Title 1 Key");
		boardVO.setContent("Content 1 Key");
		boardVO.setWriter("User01");
		
		mapper.insertSelectKey(boardVO);
		
		log.info(boardVO);
	}

	@Test
	public void testRead() {
		
		BoardVO boardVO = mapper.read(5L);
		
		log.info(boardVO);
	}
	@Test
	public void testDelete() {
		
		int cnt = mapper.delete(5L);
		
		log.info(cnt);
	}

	@Test
	public void testUpdate() {
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setBno(3L);
		boardVO.setTitle("Update Title.....");
		boardVO.setContent("Update Content.....");
		boardVO.setWriter("User00");
		
		
		int cnt = mapper.update(boardVO);
		
		log.info("UPDATE COUNT: " + cnt);
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
}
