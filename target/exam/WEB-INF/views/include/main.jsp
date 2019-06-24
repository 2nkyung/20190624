<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#lDiv{
width:48%;
background-color:lime;
float: left;
}

#rDiv{
width:48%;
background-color:orange;
float: right;
}
</style>
<body>
<div id="lDiv">
<jsp:include page="/WEB-INF/views/include/left.jsp"></jsp:include></div>
<!-- left.jsp를 넣는 방법 2가지 : 액션테그 or 디렉티브 인크루드 -->

<div id="rDiv">
<jsp:include page="/WEB-INF/views/include/right${param.page}.jsp"></jsp:include></div>

</body>
</html>