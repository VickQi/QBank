<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/error.css"/>
<title>Qi银行支付网关</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1><span style="color:red">啊哦!出错了！</span></h1>
                <h2><c:out value="${errorCode}" /><c:out value="${errorMsg}" /></h2>
                <div class="error-details">
                   <c:out value="${errorDetail}" />
                </div>
                <div class="error-actions">
                    <a href="index.do" class="btn btn-primary btn-lg">
                    	<span class="glyphicon glyphicon-home"></span>
                        <span>返回首页</span>
                    </a>
                    <a href="mailto:vick_qi@163.com" class="btn btn-default btn-lg">
                    	<span class="glyphicon glyphicon-envelope"></span>
                    	<span>发邮件给开发者</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>