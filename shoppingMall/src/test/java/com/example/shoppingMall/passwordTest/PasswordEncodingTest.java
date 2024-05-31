package com.example.shoppingMall.passwordTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncodingTest {
	
	
	
	@Test
	public void test() {
		String rawPassword = "fff";
		String encodedPassword = "$2a$10$df1XkyVwBY1n/FIGvx1LTuDdP0giksUK.RwG9gQd26CcZ654IIDGy";  // 데이터베이스에서 가져온 인코딩된 비밀번호
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		if (encoder.matches(rawPassword, encodedPassword)) {
		    System.out.println("비밀번호 일치");
		} else {
		    System.out.println("비밀번호 불일치 또는 인코딩 오류");
		}

		//assertEquals(rawPassword, encodedPassword);
	}
}
