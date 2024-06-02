<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header&SideBar</title>
<link rel="stylesheet" href="../css/header_footer.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="../js/sidebar.js"></script>
</head>
<body onclick="closeSidebar(event)">
    <header>
        <div class="container">
            <button class="menu-btn" onclick="toggleSidebar(event)">☰</button>
            <a href="/" class="logo">LOGO</a>
            
<!-- 
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/admin/dashboard" class="btn btn-light">관리자 모드</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.username" var="username"/>
                <c:if test="${not hasRole('ROLE_ADMIN')}">
                    <a href="/basket/basketList">${username }님의 장바구니</a>
                </c:if>
            </sec:authorize>
            
            <c:if test="${sessionScope.loginMember.role eq 'ROLE_ADMIN'}">
            	<a href="/admin/dashboard" class="btn btn-light">관리자 모드</a>
            </c:if>
            <c:if test="${not empty sessionScope.loginMember and sessionScope.loginMember.role ne 'ROLE_ADMIN'}">
            	<a href="/basket/basketList">${sessionScope.loginMember.mem_username }님의 장바구니</a>
            </c:if>
             -->
        </div>
    </header>
</body>
</html>