<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/websitelocalisation.css"/>
<title>website localisation: ????</title>
</head>
<body>
<div id="pageBody">

<div id="langNav">
    <a href="login?lang=en">English</a>|<a href="login?lang=fr">Français</a>|<a href="login?lang=zh_CN">中文</a>
</div>

<div id="greetingMsg">
<spring:message code="label.greeting"/> ${email}, <spring:message code="label.welcome"/>!
</div>
</div>
</body>
</html>