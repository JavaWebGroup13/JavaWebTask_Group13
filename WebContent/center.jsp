<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
        <!-- center -->
        <div class="center">
            <!-- 信息 -->
            <div class="jumbotron">
                <img src="${ user.getAvatar() }" class="mb-4 rounded-circle" alt="..." style="width: 200px;height: 200px;">
                <div class="row">
                    <h1 class="display-4 col-md-9">
                    	${ user.getNickname() }
                    </h1>
                    <a href="" class="col-md-3" data-toggle="modal" data-target="#exampleModal">修改资料</a>
                </div>
                <p class="lead col-md-10">
                	${ user.getProfile() }
                </p>
                <hr class="my-4">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text text-center">${ articleCounts }篇</p>
                                <h5 class="card-title text-center">文章</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text text-center">${ commentCounts }条</p>
                                <h5 class="card-title text-center">评论</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text text-center">${ categoryCounts }个</p>
                                <h5 class="card-title text-center">类别</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 修改信息的弹出框 -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">修改资料</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form id="changeInfo" action="${basePath}/Center" method="POST">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">昵称</label>
                                        <input name="nick" type="text" class="form-control" id="recipient-name" value="${ user.getNickname() }">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">头像</label>
                                        <textarea name="avatar" class="form-control" id="message-text">${ user.getAvatar() }</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">简介</label>
                                        <textarea name="profile" class="form-control" id="message-text">${ user.getProfile() }</textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button onclick="changeInfo.submit()" type="submit" class="btn btn-primary">保 存</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 修改信息弹出框的JS -->
                <script>
                    $('#exampleModal').on('show.bs.modal', function (event) {
                        var button = $(event.relatedTarget)
                        // modal.find('.modal-body input').val(recipient)
                    })
                </script>
            </div>
        </div>
<%@include file="foot.jsp" %>