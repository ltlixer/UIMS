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
				<li><a href="/UIMS/course/list">实验课列表</a></li>
				<li class="active">${course.courseName}</li>
			</ul>

			<c:if test="${experimentList==null}">
				<div class="alert alert-info">这门课程老师还没有布置实验作业</div>
			</c:if>
			<c:if test="${experimentList!=null}">
				<table class="table table-hover cursorhand">
					<thead>
						<tr class="cursordefault">
							<th>实验名称</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>老师</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="experiment" items="${experimentList}">
						<tr onclick="window.location='/UIMS/experiment/content/${experiment.id}';">
							<td>${experiment.experimentName}</td>
							<td>${experiment.startTime}</td>
							<td>${experiment.endTime}</td>
							<td>${experiment.course.teacher.realname}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${user.role=='teacher'}">
				<a href="/UIMS/experiment/${course.id}/add" class="btn btn-primary">添加实验</a>
			</c:if>
		</div>
	</div>
</body>
</html>
