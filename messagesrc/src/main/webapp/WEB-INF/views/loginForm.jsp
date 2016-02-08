<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/websitelocalisation.css"/>
<title><spring:message code="label.title.hello"/></title>
</head>
<body>
<div id="pageBody">

<div id="langNav">
    <a href="login?lang=en">English</a>|<a href="login?lang=fr">Français</a>|<a href="login?lang=zh_CN">中文</a>
</div>

<div id="signInBox">
<sf:form class="signInForm" method="POST" action="login" commandName="userAuth">
<div class="legend"><spring:message code="label.login"/></div>
<div class="field"><label for="email"><spring:message code="label.email"/>:</label> <sf:input path="email"/> <sf:errors path="email" cssClass="error"/></div>

<div class="field"><label for="password"><spring:message code="label.password"/>:</label> <sf:password path="password"/> <sf:errors path="password" cssClass="error"/></div>

<div class="field"><input id="submitBtn" type="submit" value="<spring:message code="label.login"/>"/></div>
</sf:form>
</div>
</div>
</body>
</html>
