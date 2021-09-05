package junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class Test2 {
	/*
	 Assertions : 성공/실패 검증
	 assertEquals(a,b) : 같은지 검증
	 assertTrue(a) : true인지 검증
	 assertFalse(a) : false인지 검증
	 assertNull(a) : null인지 검증
	 assertNotNull(a) : null이 아닌지 검증
	 assertArrayEquals(a,b) : 배열이 같은지 검증
	 */
	@Test
	void test1() {
		String a = "홍길동";
		String b = "홍길동1";
		assertEquals(a, b);
	}
	
	/*
	 Assumptions : 성공한 경우에만 테스트 실행
	 assumeTrue() : true인지
	 assumeEquals() : 같은지
	 */
	@Test
	void test2() {
		assumeTrue(1==2);
		assertEquals("a", "a"); // 미실행
	}
}
