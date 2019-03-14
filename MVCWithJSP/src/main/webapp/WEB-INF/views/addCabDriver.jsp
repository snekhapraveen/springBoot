<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Partner driver</title>
</head>
<body>
<form:form action="addDriver" method="post">
<h2>Add details here:</h2>
	<label for="">Driver Id</label>
	<form:input path="driverId"/>
	<br/><br/>
	<label for="">Driver Name</label>
	<form:input path="driverName"/>
	<br/><br/>
	<label for="">Mobile number</label>
	<form:input path="mobileNumber"/>
	<br/><br/>
	<label for="">Rating</label>
	<form:input path="rating"/>
	<br/><br/>
	<input type="submit" value="Add Driver"/>
	
</form:form>

</body>
</html>