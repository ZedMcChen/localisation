<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/static/css/websitelocalisation.css"/>
<title>My website : Sign in</title>
</head>
<body>
<div id="pageBody">

<%@include file="langNav.jsp"%>

<div id="signInBox">
<sf:form class="signInForm" method="POST" action="login" commandName="userAuth">
<div class="legend">Sign in</div>
<div class="field"><label for="email">Email:</label> <sf:input path="email"/> <sf:errors path="email" cssClass="error"/></div>

<div class="field"><label for="password">Password:</label> <sf:password path="password"/> <sf:errors path="password" cssClass="error"/></div>

<div class="field"><input id="submitBtn" type="submit" value="Sign in"/></div>
</sf:form>
</div>
</div>
</body>
</html>
