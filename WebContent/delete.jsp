<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
	<div class="alert alert-success" role="alert">
  		删除成功，即将跳转到主页！
	</div>
	<% response.setHeader("Refresh", "3;URL=/JavaWebTask_Group13/Home"); %>
<%@include file="foot.jsp" %>