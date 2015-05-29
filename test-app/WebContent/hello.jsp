<!DOCTYPE html>
<html>
<head><title>Sample JSP Page</title></head>
<body>

<%@ page import="java.util.*" %>

<p>
Hello, <%
    if (request.getParameter("name") == null) {
        out.println("World !");
    } else {
        out.println(request. getParameter("name")+"</b>!");
    }
%>
</p>
</body></html>