<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>置换单列表</title>
    
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
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>所有置换单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	
<c:forEach items="${orderItemList }" var="orderItem">

	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			置换单编号：${orderItem.oid}　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderItem.ordertime}"/>
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/${orderItem.image}'/>" height="75"/></div>
		</td>
		<td>书名：${orderItem.bname }</td>
		<td>作者：${orderItem.author}</td>
		<td>状态：${orderItem.stateDes}</td>
		<td>
			<form action="<c:url value='/admin/AdminOrderServlet'/>" method="post">
		    	<input type="hidden" name="method" value="edit"/>
		    	<input type="hidden" name="oid" value="${orderItem.oid }"/>
		    	<input type="submit" value="确认置换"/>
		    </form>
		</td>
	</tr>
  
</c:forEach>
	
</table>
  </body>
</html>
