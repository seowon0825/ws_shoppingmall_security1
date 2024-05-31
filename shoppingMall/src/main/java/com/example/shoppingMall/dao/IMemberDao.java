package com.example.shoppingMall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.shoppingMall.dto.Member;
import com.example.shoppingMall.dto.Orders;
import com.example.shoppingMall.dto.Product;

@Mapper
public interface IMemberDao {
	//public void signUp(Member member);
	//회원가입
	public void signUp(@Param("username") String username, @Param("password") String password, @Param("mem_name") String mem_name, @Param("mem_tel") String mem_tel, @Param("mem_addr") String mem_addr, @Param("role") String role);
	//로그인
	public int loginCheck(@Param("username") String username, @Param("password") String password);
	//로그인 한 사람의 모든 정보
	public Member userInfo(@Param("username") String username);
	//판매중인 상품 리스트
	public List<Product> getSaleProductList();
	//구매 목록
	public List<Orders> getOrderList(@Param("mem_no") int mem_no);
	
	public Member getUsername(@Param("username") String username);
}
