<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
        <div class="write">
            <!-- 没有登录 -->
            <c:if test="${user == null}">
	            <div class="alert alert-warning" role="alert">
	                无法写作，您没有权限，<a href="${basePath}/login.jsp">点此登录</a>
	            </div>
            </c:if>
            <!-- 添加文章结果 -->
            <c:if test="${code == 0 }">
	            <div class="alert alert-${ code == 0 ? 'success' : 'danger' }" role="alert">
	                ${ msg }
	            </div>
            </c:if>
            <!-- 已登录 -->
            <form method="POST" action="${basePath}/Write" onsubmit="return checkForm()">
                <input type="hidden" name="isUpdate" value='${ article == null ?  "false" : "true" }'>
                <input type="hidden" name="id" value='${ article.getId() }'>
                <div class="form-group">
                    <label for="cover">封面URL</label>
                    <input type="text" name="cover" class="form-control" placeholder="http(s)://" id="cover" 
                        value="${ article == null ? '' : article.getCover() }">
                </div>
                <div class="form-group">
                    <label for="title">标题</label>
                    <input type="text" name="title" class="form-control" placeholder="文章标题" id="title" placeholder=""
                    value="${ article == null ? '' : article.getTitle() }">
                </div>
                <div class="form-group">
                    <label for="category">类别</label>
                    <!-- 查询类别出错，给予提示 -->
                    <c:if test="${ code == -1 }">
                    	<div class="alert alert-warning" role="alert">
			                ${ msg }
			            </div>
                    </c:if>
                    <select class="form-control" id="category" name="category">
                    	<c:forEach var="category" items="${ categorys }">
                        <option value="${ category.getId() }">${ category.getTitle() }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="summary">描述</label>
                    <input type="text" name="summary" class="form-control" placeholder="文章简介" id="summary"
                    value="${ article == null ? '' : article.getSummary() }">
                </div>
                <div class="form-group">
                    <label for="editor">文章正文</label>
                    <textarea id="editor" name="content" class="ckeditor form-control" placeholder="说点什么吧">
                       ${ article == null ? '' : article.getContent() }
                    </textarea>
                	<style>
                		 .ck-rounded-corners .ck.ck-editor__main>.ck-editor__editable, .ck.ck-editor__main>.ck-editor__editable.ck-rounded-corners {
                		 	min-height: 220px;
                		 }
                	</style>
                </div>
                <button type="submit" class="btn btn-primary" style="width: 100px;">提交</button>
            </form>
            <script>
            	function checkForm() {
            		var cover = document.getElementById("cover").value;
            		var title = document.getElementById("title").value;
            		var summary = document.getElementById("summary").value;
            		var category = document.getElementById("category").value;
            		var content = document.getElementById("editor").value;
            		console.log(cover, title, summary, category, content);
            		if(cover.trim() == '' || title.trim() == '' || summary.trim() == '' || category.trim() == '' || content.trim() == '') {
            			console.log('信息不全')
            			return false;
            		}
            		return true;
            	}
                ClassicEditor.create(document.querySelector('#editor'))
                .catch( error => {
                    console.error( error ); 
                })
            </script>
        </div>
<%@include file="foot.jsp" %>