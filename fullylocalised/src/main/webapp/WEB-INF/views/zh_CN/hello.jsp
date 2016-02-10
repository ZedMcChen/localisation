<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/static/css/websitelocalisation.css"/>
<title>我的网站:你好</title>
</head>
<body>
<div id="pageBody">

<%@include file="../langNav.jsp"%>

<div id="greetingMsg">
<span>你好</span>  ${email}, 欢迎!
</div>
</div>
</body>
</html>
