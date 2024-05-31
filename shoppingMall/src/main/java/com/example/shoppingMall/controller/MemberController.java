package com.example.shoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shoppingMall.dao.IAdminDao;
import com.example.shoppingMall.dao.IMemberDao;
import com.example.shoppingMall.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private IMemberDao memDao;
	@Autowired
	private IAdminDao adminDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//메인 페이지
	//신상 리스트
	//판매순 상품 리스트
	@RequestMapping("/")
	public String mainPage(Model model) {
		//판매중인 상품 리스트
		model.addAttribute("productList", memDao.getSaleProductList());
		return "member/memberMainPage";
	}
	
	//로그인 회원가입
	@RequestMapping("/loginForm")
	public String LoginForm() {
		
		return "member/loginForm";
	}
	
	@RequestMapping("/signUpForm")
	public String signUpForm() {
		
		return "member/signUpForm";
	}
	
//	@RequestMapping("/login")
//	public String loginCheck(HttpServletRequest request, HttpSession session, Model model) {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		int result = memDao.loginCheck(username, password);
//		System.out.println(result);
//		
//		if(result == 1) {
//			Member member = (Member)memDao.userInfo(username);
//			session.setAttribute("loginMember", member);
//			return "redirect:/";
//		} else {
//			model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다. 다시 입력해주세요.");
//			return "member/loginForm";
//		}
//	}

	@RequestMapping("/signUp")
	public String signUpCheck(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");
		String role = request.getParameter("role");
		
		Member member = new Member();
		String newPw = bCryptPasswordEncoder.encode(password);
		
		memDao.signUp(username, newPw, mem_name, mem_tel, mem_addr, role);
		return "redirect:/";
	}
	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("loginMember");
//		return "redirect:/";
//	}
	
	//판매중인 상품 리스트
	@RequestMapping("/memberProductDetail")
	public String memberProductDetail(HttpServletRequest request, Model model) {
		String product_no = request.getParameter("product_no");
		model.addAttribute("dto", adminDao.getProductDetail(product_no));
		return "member/productDetail";
	}
	
}
