package exam2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import board.BoardDao;
import board.BoardVo; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestBoard {

	@Autowired
	BoardDao dao;
	
	@Test
	public void test1() {
		System.out.println(dao.count(new BoardVo()));
		assertTrue(dao.count(new BoardVo()) > 0);
	}
	
	@Test
	public void test2() {
		assertNotNull(dao.selectAll(new BoardVo()));
	}
	
}
