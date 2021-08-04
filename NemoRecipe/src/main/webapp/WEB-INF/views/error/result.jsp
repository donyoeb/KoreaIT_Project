<%@ page contentType="text/html;charset=UTF-8"%>
<%
	RuntimeException e=(RuntimeException)request.getAttribute("e"); //에러객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Please</title>
  <!-- CSS Files -->
  <link href="/resources/client/assets/css/material-kit.css" rel="stylesheet" />
</head>
<body>
<div class="error_title"></div>
<%-- <%=e.getMessage() %>	 --%>
</body>
</html>