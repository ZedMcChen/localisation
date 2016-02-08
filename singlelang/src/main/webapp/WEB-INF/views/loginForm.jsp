<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/static/css/websitelocalisation.css"/>
<title>My website: Sign in</title>
</head>
<body>
<div id="pageBody">

<div id="signInBox">
<sf:form class="signInForm"  method="POST" commandName="userAuth">
<div class="legend">Sign in</div>
<div class="field"><label for="email">Email:</label> <sf:input path="email"/> <sf:errors path="email" cssClass="error"/></div>

<div class="field"><label for="password">Password:</label> <sf:password path="password"/> <sf:errors path="password" cssClass="error"/></div>

<div class="field"><input id="submitBtn" type="submit" value="Sign in"/></div>
</sf:form>
</div>
</div>
</body>
</html>