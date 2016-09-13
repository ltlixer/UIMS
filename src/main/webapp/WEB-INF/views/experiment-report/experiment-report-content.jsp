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
<link href="<c:url value='/resources/images/favicon.ico' />"
	rel="shortcut icon" type="image/x-icon" />
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
				<li><a href="/UIMS/experiment/list/${course.id}">${course.courseName}</a></li>
				<li><a href="/UIMS/experiment/content/${experiment.id}">${experiment.experimentName}</a></li>
				<li class="active">${experimentReport.experimentReportName}</li>
			</ul>

			<c:if test="${experimentReport==null}">
				<div class="alert alert-info">没有实验报告内容</div>
			</c:if>
			<article class="article">
				<header>
					<c:if test="${user.role=='student'}">
						<c:if test="${!experimentReport.status}">
							<a href="/UIMS/experiment-report/delete/${experimentReport.id}" class="btn btn-primary">删除本实验报告</a>
						</c:if>
					</c:if>
					<h1 class="">${experimentReport.experimentReportName}</h1>
					<dl class="dl-inline">
						<dt>提交时间：</dt>
						<dd>${experimentReport.submitTime}</dd>
						<dt>学生：</dt>
						<dd>${experimentReport.user.realname}</dd>
						<c:if test="${experimentReport.status}">
							<dt>分数：</dt>
							<dd>${experimentReport.score}</dd>
						</c:if>
						<dt></dt>
						<dd class="pull-right"></dd>
					</dl>
					<section class="abstract">
						<p>
							<strong>内容：</strong>${experimentReport.experimentReportContent}
						</p>
					</section>
				</header>
				
				<c:if test="${user.role=='teacher'}">
					<form style="float:left;margin-right:10px;" action="/UIMS/experiment-report/score/${experimentReport.id}" role="form" method="post">
						<input name="score" type="number" min="0" max="100" id="author"/>
						<input type="submit" id="submit" class="btn btn-primary"
									value="打分" data-loading="稍候...">
					</form>
					<a href="/UIMS/experiment-report/download/${experimentReport.id}" class="btn btn-primary">下载</a>
				</c:if>
				
			</article>

		</div>
	</div>
</body>
</html>
