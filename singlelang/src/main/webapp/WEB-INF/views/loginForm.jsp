<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/websitelocalisation.css"/>
<title>website localisation: single language reference</title>
</head>
<body>
<div id="pageBody">

<div id="signInBox">
<legend class="formboxlegend">Sign in</legend>
<sf:form id="signInForm"  method="POST" commandName="userAuth">
<div><label class="inputLabel">Email:</label> <sf:input path="email"/><br/><sf:errors path="email" cssClass="error"/></div>
<div><label class="inputLabel">Password:</label> <sf:password path="password"/><br/><sf:errors path="password" cssClass="error"/></div>
<input id="submitBtn" type="submit" value="Sign in"/>
</sf:form>
</div>
</div>
</body>
</html>