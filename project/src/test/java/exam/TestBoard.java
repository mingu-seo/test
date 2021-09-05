package exam;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import board.BoardDao;
import board.BoardVo; 

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestBoard {

	@Autowired
	BoardDao dao;
	
	@Test
	public void test1() {
		assertTrue(dao.count(new BoardVo()) > 0);
	}
	
	@Test
	public void test2() {
		assertNotNull(dao.selectAll(new BoardVo()));
	}
	
}
