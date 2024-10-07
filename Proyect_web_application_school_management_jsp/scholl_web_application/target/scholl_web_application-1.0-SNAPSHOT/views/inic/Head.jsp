<%-- 
    Document   : Header
    Created on : 27 may 2024, 11:25:44 p.m.
    Author     : Jesus Gutierrez
--%>
<%
    String path = null;
    if (request.getAttribute("path") == null) {
        response.sendRedirect(request.getContextPath() + "/dashboard");
    } else {
        path = (String) request.getAttribute("path");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>san_martin_de_porres</title>

    <% if (path.equalsIgnoreCase("/dashboard")) { %>
    <script src="views/dashboard/js/jsDashboard.js" type="text/javascript"></script>
    <link href="views/dashboard/css/cssDashboard.css" rel="stylesheet" type="text/css"/>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <% } else if (path.equalsIgnoreCase("/login")) { %>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet"/>
    <link href="views/auth/css/cssAuth.css" rel="stylesheet" type="text/css"/>
    <% } else if(path.equalsIgnoreCase("/admin")){%>
        <link href="views/admin/css/css.css" rel='stylesheet'/>
    <% } %>
</head>
