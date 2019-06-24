 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String r = "r1"; 
String path = "/WEB-INF/views/include/" + r + ".jsp";
if(request.getParameter("path")!=null){
	path = "/WEB-INF/views/include/" + request.getParameter("path") + ".jsp";
}
%>
<style>
#leftDiv{
	width:45%;	
	background-color:lime;
	float:left;
}
#rightDiv{
	width:45%;
	background-color:orange;
	float:right;
}
</style>
<body>
<div id="leftDiv">
<jsp:include page="/WEB-INF/views/include/left.jsp"></jsp:include>
</div>
<div id="rightDiv">
<jsp:include page="<%=path %>"></jsp:include>
</div>
</body>
</html>