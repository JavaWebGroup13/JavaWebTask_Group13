<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@include file="head.jsp" %>
        <div class="write">
            <!-- 没有登录 -->
            <c:if test="${user == null}">
	            <div class="alert alert-warning" role="alert">
	                无法写作，您没有权限，<a href="${pageContext.request.contextPath}/login.jsp">点此登录</a>
	            </div>
            </c:if>
            <!-- 已登录 -->
            <form method="POST" action="${pageContext.request.contextPath}/Write">
                <div class="form-group">
                    <label for="exampleFormControlFile1">选择封面</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">标题</label>
                    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">类别</label>
                    <select class="form-control" id="exampleFormControlSelect1">
                        <option>Android</option>
                        <option>Python</option>
                        <option>JavaWeb</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">描述</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">文章正文</label>
                    <textarea id="editor" cols="20" rows="5" class="ckeditor form-control"></textarea>
                </div>
                <button class="btn btn-secondary" style="width: 100px;">保存</button>
                <button type="submit" class="btn btn-primary" style="width: 100px;">提交</button>
            </form>
            <script>
                ClassicEditor.create(document.querySelector('#editor'))
                .catch( error => {
                    console.error( error ); 
                })
            </script>
        </div>
<%@include file="foot.jsp" %>