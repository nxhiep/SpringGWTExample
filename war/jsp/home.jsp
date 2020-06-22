<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<script type="text/javascript" src="springgwtbasic/springgwtbasic.nocache.js"></script>
		<jsp:include page="/jsp/widgets/seo.jsp"></jsp:include>
		<jsp:include page="/jsp/widgets/resources.jsp"></jsp:include>
	</head>
<body>
	<jsp:include page="/jsp/widgets/login.jsp"></jsp:include>
	<div>
		<button onclick="openLoginDialog()">Login</button>
		<button onclick="openRegisterDialog()">Register</button>
	</div>
	<div>
		<div id="content"></div>
	</div>
</body>
</html>