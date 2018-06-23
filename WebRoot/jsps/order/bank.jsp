<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>缴纳保证金</title>
    
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
	
	#pay {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -412px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#pay:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -448px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>请缴纳保证金100元</h1>
<br/>
<form method="post" action="javascript:alert('别点了，再点就去银行页面了！');" id="form" target="_parent">

	选择银行：<br/>
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="../../bank_img/ccb.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
	<img src="../../bank_img/icbc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="../../bank_img/bc.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="../../bank_img/abc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="../../bank_img/bcc.bmp" align="middle"/><br/>
	<input type="submit" value="确认">
</form>

  </body>
</html>

