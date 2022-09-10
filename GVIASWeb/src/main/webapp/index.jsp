<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body> 
<%
/* 	if (request.getParameter("logout")!=null) */
		session.invalidate();
%>
<jsp:forward page="paginas/inicio/bienvenida.xhtml" /> 
</body> 
</html>