<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/static/css/websitelocalisation.css"/>
<title><spring:message code="label.title.hello"/></title>
</head>
<body>
<div id="pageBody">

<div id="langNav">
    <a href="?lang=en">English</a>|<a href="?lang=fr">Français</a>|<a href="?lang=zh_CN">中文</a>
</div>

<div id="greetingMsg">
<span><spring:message code="label.greeting"/></span>  ${email}, <spring:message code="label.welcome"/>!
</div>
</div>
</body>
</html>