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
</head>
<body>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand"  href="javascript:void(0)">管理界面</a>
        </div>
    </div>
</div>
<div class="container-fluid">
    <form method="POST" action="/web/login">
        <div>
            <h2>管理员登录</h2>
        </div>
        <div class="row">
            <div class="col-md-4">
                    <div class="form-group">
                        <label for="user_name">用户名</label>
                        <input type="text" name="user_name" class="form-control" id="user_name" placeholder="用户名">
                    </div>

                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                    </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>

<p></p>
</body>
</html>