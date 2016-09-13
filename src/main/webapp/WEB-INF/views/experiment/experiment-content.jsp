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
				<li class="active">${experiment.experimentName}</li>
			</ul>

			<c:if test="${experiment==null}">
				<div class="alert alert-info">这门课程老师还没有布置实验作业</div>
			</c:if>
			<article class="article">
				<header>
					<c:if test="${user.role=='teacher'}">
						<a href="/UIMS/experiment/delete/${experiment.id}" class="btn btn-primary">删除本实验</a>
					</c:if>
					<h1 class="">${experiment.experimentName}</h1>
					<dl class="dl-inline">
						<dt>发布时间：</dt>
						<dd>${experiment.startTime}</dd>
						<dt>老师：</dt>
						<dd>${experiment.course.teacher.realname}</dd>
						<dt></dt>
						<dd class="pull-right"></dd>
					</dl>
					<section class="abstract">
						<p>
							<strong>内容：</strong>${experiment.experimentContent}
						</p>
					</section>
				</header>
				<c:if test="${user.role=='student'}">
				<c:if test="${myExperimentReport==null}">
				<div class="example">
					<form action="/UIMS/experiment-report/submitExperimentReport"  enctype="multipart/form-data" class="form-horizontal" role="form" method="post">
						<legend></legend>
						<input name="courseId" type="hidden" value="${experiment.course.id}" />
						<input name="experimentId" type="hidden" value="${experiment.id}" />

						<div class="form-group">
							<label class="col-md-2 control-label">实验报告</label>
							<div class="col-md-4">
								<input name="file" class="form-control" type="file" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-2 col-md-10">
								<input type="submit" id="submit" class="btn btn-primary"
									value="提交" data-loading="稍候..."> <input type="hidden"
									name="type" id="type" value="article">
							</div>
						</div>
					</form>
				</div>
				</c:if>
				<c:if test="${myExperimentReport!=null}">
				<br/>	
				<table class="table table-hover cursorhand">
					<thead>
						<tr class="cursordefault">
							<th>实验报告名称</th>
							<th>学生姓名</th>
							<th>提交时间</th>
							<th>状态</th>
							<th>得分</th>
						</tr>
					</thead>
					<tbody>
						<tr onclick="window.location='/UIMS/experiment-report/content/${myExperimentReport.id}';">
							<td>${myExperimentReport.experimentReportName}</td>
							<td>${myExperimentReport.user.realname}</td>
							<td>${myExperimentReport.submitTime}</td>
							<td>${myExperimentReport.status}</td>
							<td>${myExperimentReport.score}</td>
						</tr>
					</tbody>
				</table>
				</c:if>
				</c:if>
				<c:if test="${user.role=='teacher'}">
				<br/>	
				<table class="table table-hover cursorhand">
					<thead>
						<tr class="cursordefault">
							<th>实验报告名称</th>
							<th>学生姓名</th>
							<th>提交时间</th>
							<th>状态</th>
							<th>得分</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="experimentReport" items="${experimentReportList}">
						<tr onclick="window.location='/UIMS/experiment-report/content/${experimentReport.id}';">
							<td>${experimentReport.experimentReportName}</td>
							<td>${experimentReport.user.realname}</td>
							<td>${experimentReport.submitTime}</td>
							<td>${experimentReport.status}</td>
							<td>${experimentReport.score}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</c:if>
				
			</article>

		</div>
	</div>
</body>
</html>
