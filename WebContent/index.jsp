<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 导入dao包下的所有类 -->
<%@page import="dao.*" %>

<!-- 导入bean包下的所有类 -->
<%@page import="bean.*" %>

<%
	UserDao userDao = DaoFactory.getUserDaoInstance();
	User user = userDao.queryByUserid(1);
%>



<%@include file="home.jsp" %>