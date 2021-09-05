package junit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import user.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class Test2 {

	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	// 세션객체 선언
	private MockHttpSession session;
	
	@Before
	public void init() {
		// 목업객체
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		// 로그인세션객체 생성
		UserVo uv = new UserVo();
		uv.setName("홍길동");
		uv.setId("hong");
		uv.setNo(999);
		session = new MockHttpSession(); // 세션객체 생성
		session.setAttribute("authUser", uv);
		request.setSession(session);
	}
	
	@Test
	public void boardList() throws Exception {
		// board목록
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do");
		mockMvc.perform(req);
	}
	
	@Test
	public void boardList2() throws Exception {
		// board목록
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage", "2");
		mockMvc.perform(req);
	}
	
}
