<%-- 
    Document   : index
    Created on : 27 may 2024, 11:25:14 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String pages = null;
   
    if (request.getAttribute("pages") == null) {
        response.sendRedirect(request.getContextPath() +  "/dashboard");
        return;
    } else {
        pages = (String) request.getAttribute("pages");
    }
%>
<html>
    <jsp:include page="views/inic/Head.jsp" />
    <body>
        <jsp:include page="<%=pages%>" />
    </body>
</html>
