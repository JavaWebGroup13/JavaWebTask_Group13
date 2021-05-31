<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>
        <!-- home -->
        <div class="home row">
            <!-- 没有文章时 -->
            <div class="col-md-12">
                <div class="alert alert-info" role="alert">
                    还没有文章，快去写一篇吧！<a href="?route=write">写文章</a>
                </div>
            </div>
            <!-- 左侧 -->
            <div class="col-md-9">
                <!-- 第一篇文章 -->
                <div class="card mb-3">
                    <img src="img/image.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">
                            <a href="?route=details" role="button">Card title</a>
                        </h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        
                    </div>
                </div>
                <!-- 其他文章 -->
                <div class="row row-cols-1 row-cols-md-2">
                    <div class="col mb-4">
                        <div class="card">
                            <img src="img/image.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">
                                    <a href="?route=details" role="button">Card title</a>
                                </h5>
                                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-4">
                        <div class="card">
                            <img src="img/image.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">
                                    <a href="?route=details" role="button">Card title</a>
                                </h5>
                                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-4">
                        <div class="card">
                            <img src="img/image.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">
                                    <a href="?route=details" role="button">Card title</a>
                                </h5>
                                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 分页器 -->
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <!-- 右侧 -->
            <div class="col-md-3">
                <!-- 个人信息 -->
                <div class="card">
                    <img src="img/image.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h4 class="card-title">王荆茜</h4>
                        <p class="card-text">做个俗人，见山是山，见水是水</p>
                        <a type="button" href="?route=write" class="btn btn-primary btn-block">写文章</a>
                    </div>
                </div>

                <h4 class="title mt-4 ml-2">最近更新</h4>
                <!-- 推荐文章 -->
                <div class="list-group list-group-flush mt-4">
                    <a href="#" class="list-group-item list-group-item-action">A second link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A third link item</a>
                    <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
                </div>
            </div>
        </div>
<%@include file="foot.jsp" %>