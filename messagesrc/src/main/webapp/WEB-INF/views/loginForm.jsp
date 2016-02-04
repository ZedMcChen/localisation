<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/websitelocalisation.css"/>
<title>website localisation: <spring:message code="label.login"/></title>
</head>
<body>
<div id="pageBody">
<span style="float: right; font-size:10px">
    <a href="?lang=en">English</a>|<a href="?lang=fr">Français</a>|<a href="?lang=zh_CN">中文</a>
</span>

<legend class="formboxlegend"><spring:message code="label.login"/></legend>
<div id="signInBox">
<form id="signInForm">
<div><label class="inputLabel"><spring:message code="label.username"/>:</label><input class="inputText" type="text" name="username"/></div>
<div><label class="inputLabel"><spring:message code="label.password"/>:</label><input class="inputText" type="password" name="password"/></div>
<input id="submitBtn" type='submit' value='<spring:message code="label.login"/>'/>
</form>
</div>
</div>
</body>
</html>
