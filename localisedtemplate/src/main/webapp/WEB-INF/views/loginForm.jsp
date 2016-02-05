<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/websitelocalisation.css"/>
<title>website localisation: single language reference</title>
</head>
<body>
<div id="pageBody">

<legend class="formboxlegend">Sign in</legend>
<div id="signInBox">
<form id="signInForm">
<div><label class="inputLabel">Username:</label> <input class="inputText" type="text" name="username"/></div>
<div><label class="inputLabel">Password:</label> <input class="inputText" type="password" name="password"/></div>
<input id="submitBtn" type="submit" value="Sign in"/>
</form>
</div>
</div>
</body>
</html>