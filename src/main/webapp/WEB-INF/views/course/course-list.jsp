<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UIMS</title>
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
						<a href="/UIMS"><img
							src="<c:url value='/resources/images/UIMS-logo.png' />"
							class="logo" alt="" title=""></a>
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

			<ul class="breadcrumb breadcrumb-block">
				<li><i class="icon-location-arrow icon-muted"></i></li>
				<li><a href="/UIMS">首页</a></li>
				<li class="active">实验课列表</li>
			</ul>
			
			<c:if test="${courseList==null}">
				<div class="alert alert-info">这学期还没有实验课</div>
			</c:if>
			<div class="list-group">
				<c:forEach var="course" items="${courseList}">
					<a href="/UIMS/experiment/list/${course.id}" class="list-group-item">
						<h4 class="list-group-item-heading">${course.courseName}</h4>
						<p class="list-group-item-text text-muted">${course.teacher.realname}</p>
						<p class="list-group-item-text text-muted">${course.info}</p>
					</a>
					<c:if test="${user.role=='manager'}">
						<a href="/UIMS/course/delete/${course.id}" class="btn btn-primary" style="float:right;">删除这门课程</a>
						<div style="margin-bottom:10px; clear:both;">  </div>
					</c:if>
				</c:forEach>
			</div>
			
			<c:if test="${user.role=='manager'}">
				<a href="/UIMS/course/add" class="btn btn-primary">添加实验课</a>
			</c:if>

		</div>
	</div>
</body>
</html>
