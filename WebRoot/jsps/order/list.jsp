<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body>
<h1>我的置换申请</h1>

<table border="1" width="100%" cellspacing="0" background="black">

	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			置换单编号：${order.oid}　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime}"/>
		</td>
	</tr>

	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="<c:url value='/${book.image}'/>" height="75"/></div>
		</td>
		<td>书名：${book.bname }</td>
		<td>作者：${book.author}</td>
		<td>状态：可置换</td>
	</tr>

	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			<a href="${pageContext.request.contextPath}/OrderServlet?method=cancel&oid=${order.oid}" style="display: block; text-align:right;">取消</a>
			<a href="${pageContext.request.contextPath}/OrderServlet?method=confirm" style="display: block; text-align:right;">确认</a>
		</td>
	</tr>

</table>
  </body>
</html>
