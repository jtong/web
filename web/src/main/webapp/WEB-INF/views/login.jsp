<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add user page</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="lib/css/bootstrap.min.css" />
    <style>
        .form-signin{
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand"  href="javascript:void(0)">管理界面</a>
        </div>
    </div>
</div>
<div class="container">
    <form method="POST" action="/web/login" class="form-signin">
        <div>
            <h2>管理员登录</h2>
        </div>
        <% String message = (String) request.getParameter("message"); %>


        <%if(message != null){%>
        <div class="alert alert-danger" role="alert"><%=message%></div>
        <%}%>
        <div class="row">
            <div class="form-group">
                <label for="user_name">用户名</label>
                <input type="text" name="user_name" class="form-control" id="user_name" placeholder="用户名">
            </div>

            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="密码">
            </div>
        </div>
        <div class="row">
            <button type="submit" class="btn btn-block btn-primary">登录</button>
        </div>
        <img src="/web/img/1.png" />
    </form>
</div>

<p></p>
</body>
</html>