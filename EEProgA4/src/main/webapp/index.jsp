<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Check if there is an error message -->
    <% if (request.getAttribute("error") != null) { %>
        <div style="color: red;">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

<!--  Pass XML file to the Servlet -->
<form method="post" action="/EEProgA4/ParseXMLServlet" enctype="multipart/form-data">

	<input type="file" name="file"/>
	<input type="submit" value="Submit"/>

</form>

</body>
</html>