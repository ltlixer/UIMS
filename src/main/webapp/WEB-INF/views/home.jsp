<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UIMS</title>
<link href="<c:url value='/resources/images/favicon.ico' />" rel="shortcut icon" type="image/x-icon" />
<!-- zui -->
<link href="<c:url value='/resources/zui/css/zui.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/zui/css/zui-theme.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/uims.theme.css' />"
	rel="stylesheet">
<!-- jQuery -->
<script src="<c:url value='/resources/jquery/jquery-3.0.0.min.js' />"></script>
<!-- ZUI Javascript组件 -->
<script src="<c:url value='/resources/zui/js/zui.min.js' />"></script>
</head>
<body>
	<div class="page-container">
		<header id="header" class="bg-primary">
			<div class="navbar navbar-inverse" id="navbar" role="banner" style="">
				<div class="container">
					<div class="navbar-header">
						<button class="navbar-toggle collapsed" type="button"
							data-toggle="collapse" data-target=".zui-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a href="/UIMS"><img src="<c:url value='/resources/images/UIMS-logo.png' />"
							class="logo" alt="" title="" /></a>
					</div>
					<nav class="navbar-collapse zui-navbar-collapse collapse"
						style="height: 0px;">
						<ul class="nav navbar-nav">
							<li><a href="/UIMS/course/list"><span>
										实验课</span></a></li>
							<li><a href="/UIMS/user-profile"><i class="icon-user"> </i> ${user.realname}</a></li>
							<li><a href="/UIMS/logout"><i class="icon icon-off"> </i> 退出</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<div class="main-content">


			<section>
				<article>
					<div contenteditable="false" spellcheck="false" class="example">
						<br>
						<ul class="breadcrumb breadcrumb-block">
							<li><i class="icon-location-arrow icon-muted"></i></li>
							<li><a href="#">Home</a></li>
							<li><a href="#">Library</a></li>
							<li class="active">Data</li>
						</ul>
						<div class="list">
							<header>
								<h3>
									<i class="icon-list-ul icon-border-circle"></i>&nbsp;&nbsp;待完成实验&nbsp;<small>26个实验</small>
								</h3>
							</header>
							<section class="items items-hover">
								<div class="item">
									<div class="item-heading">
										<h4>
											<span class="label label-success">NEW</span>&nbsp; <a
												href="###">Lorem ipsum dolor sit amet.中文标题测试</a>
										</h4>
									</div>
									<div class="item-content">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Quasi, necessitatibus, animi
										magni illo vel ducimus quia dolorum modi temporibus iste fugit
										laudantium minima minus sit debitis. Autem voluptate dolorum
										saepe!</div>
									<div class="item-footer">
										<a href="#" class="text-muted"><i class="icon-comments"></i>
											243</a>&nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
									</div>
								</div>
								<div class="item">
									<div class="item-heading">
										<h4>
											<a href="###">Lorem ipsum dolor sit amet.中文标题测试</a>
										</h4>
									</div>
									<div class="item-content">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Quasi, necessitatibus, animi
										magni illo vel ducimus quia dolorum modi temporibus iste fugit
										laudantium minima minus sit debitis. Autem voluptate dolorum
										saepe!</div>
									<div class="item-footer">
										<a href="#"><i class="icon-comments"></i> 243</a>&nbsp; <span
											class="text-muted">2013-11-11 16:14:37</span>
									</div>
								</div>

							</section>
							<footer>
								<ul class="pager">
									<li class="previous"><a href="#">« 上一页</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">⋯</a></li>
									<li><a href="#">6</a></li>
									<li class="active"><a href="#">7</a></li>
									<li><a href="#">8</a></li>
									<li><a href="#">9</a></li>
									<li><a href="#">⋯</a></li>
									<li><a href="#">12</a></li>
									<li class="next"><a href="#">下一页 »</a></li>
								</ul>
							</footer>
						</div>
					</div>
				</article>
			</section>


		</div>

	</div>

</body>
</html>
