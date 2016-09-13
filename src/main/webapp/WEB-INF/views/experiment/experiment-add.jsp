<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<li class="active">添加实验</li>
			</ul>

			<div class="example">
				<form:form action="/UIMS/experiment/${experiment.course.id}/addExperiment" class="form-horizontal" commandName="experiment" role="form" method="post">
					<legend>添加实验</legend>


					<div class="form-group">
						<label class="col-md-2 control-label">实验名称</label>
						<div class="col-md-4">
							<form:input path="experimentName" type="text" id="author" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">开始时间</label>
						<div class="col-md-4">
							<div class="input-group">
								<form:input path="startTime" type="text" id="date" class="form-control" />
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">田</button>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">结束时间</label>
						<div class="col-md-4">
							<div class="input-group">
								<form:input path="endTime" type="text" id="date" class="form-control" /> <span class="input-group-btn">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">田</button>
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">内容</label>
						<div class="col-md-10">
							<form:textarea path="experimentContent" id="content" rows="10"
								class="form-control"></form:textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-offset-2 col-md-10">
							<input type="submit" id="submit" class="btn btn-primary"
								value="保存" data-loading="稍候..."> <input type="hidden"
								name="type" id="type" value="article">
						</div>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</body>
</html>
