package junit5;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import board.BoardDao;
import board.BoardVo;
import user.UserVo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class Test3 {

	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	// 세션객체 선언
	private MockHttpSession session;
	
	@BeforeEach
	void init() {
		// 목업객체
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
//		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		// 로그인세션객체 생성
		UserVo uv = new UserVo();
		uv.setName("홍길동");
		uv.setId("hong");
		uv.setNo(999);
		session = new MockHttpSession(); // 세션객체 생성
		session.setAttribute("userInfo", uv);
		request.setSession(session);
	}
	
//	@Test
//	public void boardList() throws Exception {
//		// board목록
//		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do");
//		mockMvc.perform(req);
//	}
//	@Test
//	public void boardList2() throws Exception {
//		// board목록
//		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage", "2");
//		mockMvc.perform(req);
//	}
//	@Test
//	public void boardInsert() throws Exception {
//		File f = new File("D:\\workspace_java\\project\\src\\main\\webapp\\img\\company.png");
//		FileInputStream fis=new FileInputStream(f);
//		MockMultipartFile file = new MockMultipartFile("file", f.getName(), "multipart/form-data", fis);
//		RequestBuilder req = MockMvcRequestBuilders
//				.multipart("/board/insert.do")
//				.file(file)
//				.param("title", "제목테스트")
//				.param("content", "내용 테스트")
//				.session(session);
//		mockMvc.perform(req);
//	}
	@Autowired
	BoardDao dao;
//	@Test
//	public void daoTest() {
//		List<BoardVo> list = dao.selectAll(new BoardVo());
//		for (BoardVo vo : list) {
//			System.out.println(vo.getTitle());
//		}
//	}
	
	@Test
	public void deleteTest() {
		int[] nos = {101,102,103};
		BoardVo vo = new BoardVo();
		vo.setNos(nos);
		int r = dao.deleteGroup(vo);
		System.out.println("delete:"+r);
	}
}
