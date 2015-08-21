<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="en-us" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/chosen.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap-timepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/daterangepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/colorpicker.css" />
<!-- text fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${pageContext.request.contextPath}/assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/respond.js"></script>
		<![endif]-->
</head>

<body>
	
				<form name="form1" action="standardVisit.standard.standardSingle.Skip.do" method="post">
				<br />
				<table cellpadding="0" cellspacing="0" class="tablelist" align="center">
					<tr>
						<th>&nbsp;</th>
						<th>营业厅编码&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>营业厅名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>区域&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>片区&nbsp;&nbsp;&nbsp;&nbsp;</th>
					</tr>		
				
				<c:forEach items="${requestScope.organizationNj}" var="OrganizationNj">
					<tr>
							<td><input type="radio" name="selectBusinessHall" value="${OrganizationNj.orgid}" checked></td>
                        	<td>${OrganizationNj.orgid}</td>
							<td>${OrganizationNj.org_Name}</td>
							<td>${OrganizationNj.areadesc}</td>
							<td>${OrganizationNj.subareadesc}</td>
					</tr>	
				</c:forEach>
				
					
				</table>
				<table style="width: 95%" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<td  class="page" >
							&nbsp;共5页 当前第1页 
							<a href="#">首页</a> 
							<a href="#">上一页</a> 
							<a href="#">下一页</a> 
							<a href="#">末页</a>
						</td>
					</tr>
				</table>
				<br />
				<table cellpadding="0" cellspacing="0" width="95%" align="center">
					<tr>
						<td align="center" >
							<input type="submit" name="doSelectButton" value="确定" class="btn_2" />
							<input type="button" name="doCloseButton" value="关闭" class="btn_2" onclick="window.close();"/>
						</td>
					</tr>
				</table>
				<br />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
