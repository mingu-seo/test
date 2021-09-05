package exam2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import user.UserDao;
import user.UserVo; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestUser {

	@Autowired
	UserDao dao;
	
	@Test
	public void test1() {
		assertTrue(dao.count(new UserVo()) > 0);
	}
	
	@Test
	public void test2() {
		assertNotNull(dao.selectAll(new UserVo()));
	}
	
}
