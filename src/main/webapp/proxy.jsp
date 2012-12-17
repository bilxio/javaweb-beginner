<%@ page language="java" contentType="text/html;charset=gb2312"%>
<%@ page import="java.io.*,java.util.*,java.text.*,java.lang.*,java.net.*"%>

<%
Date timeStart=new Date();
     long tS=timeStart.getTime();

String msg="欢迎使用JSPx探针，希望能对您有所帮助<br>因TOMCAT和RESIN等平台支持的差异，在个别服务器使用时可能出现异常<br>"+
			   "<a href=http://jvm.cn/soft/jspx.rar target=_blank>"+
			   "点此查找下载JSPx探针最新版本</a> ";

%>
<html>
<head>
<title>JSP综合属性探测器</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">
<!--
.td102a {	COLOR: #5c72ba
}
body,td,th {
	font-family: Courier New, Courier, mono;
	font-size: 12px;
}
.font1 {	FONT-WEIGHT: bold; FONT-SIZE: 9pt; COLOR: #ffffff; FONT-FAMILY: Tahoma, Verdana, Arial
}
.tbl1 {	BORDER-RIGHT: #3f5294 1px solid; BORDER-TOP: #3f5294 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #3f5294 1px solid; BORDER-BOTTOM: #3f5294 1px solid
}
.tbl1o1 {	BACKGROUND-COLOR: #8595cb
}
.td1 {	BORDER-RIGHT: #ffffff 0px solid; BORDER-TOP: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; COLOR: #336699; BORDER-BOTTOM: #ffffff 0px solid; BACKGROUND-COLOR: #abb6dc
}
.td1o1 {	BORDER-RIGHT: #ffffff 0px solid; BORDER-TOP: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 0px solid; BACKGROUND-COLOR: #e2e7f3
}
.td1o22 {	BACKGROUND-COLOR: #f3f4fa
}
.tr1 {	BACKGROUND-COLOR: #5c72ba
}
-->
</style>
</head>
<body bgcolor="#FFFFFF">

<%

    String url = request.getParameter("url");
    int code = 0;
    String content;

    if (url != null && url.trim().length() > 0) {

        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
        connection.setRequestMethod("HEAD");
//        connection.setRequestProperty("User-Agent", "");

         code = connection.getResponseCode();
    }


%>

URL=<%= code == 200 ? %>

</body>
</html>