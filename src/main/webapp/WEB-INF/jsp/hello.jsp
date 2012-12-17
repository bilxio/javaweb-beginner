<%@ page import="java.util.List" %>
<%@ page import="com.github.bilxio.javaweb.pojo.Link" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Hello Java Web!</title>
    </head>

    <body>
        <h1>Hello, Java Web</h1>
        <p>I'm <%=request.getAttribute("name")%>!</p>

        <ul>
            <%
                List<Link> links = (List<Link>)request.getAttribute("links");
                for (Link link : links) {
            %>
                <li> <%= link.getName() + " " + link.getUrl() %> </li>
            <%
                }
            %>
        </ul>
    </body>
</html>