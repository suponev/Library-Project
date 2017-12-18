<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>

<html>
    <head>
        <title>Авторизация</title>
        <%@include file='headerGuest.jsp'%>


    </head>
<body>
    <div class="container" style="margin-top:30px">
        <div class="col-md-4 col-md-offset-4">
            <div class="col-md-12 text-center">
                <header class="page-header">
                    <h1 class="page-title">Авторизация</h1>
                </header>
            </div>
            <div class="panel panel-default well" >
                <div class="panel-body ">
                    <form method="post" action="/login"  class="login-form">
                        <div class="form-group">
                            <label for="username">Логин</label>
                            <input  name="username" type="text" class="form-control" style="border-radius:0px" id="username" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль </label>
                            <input name="password"  type="password" class="form-control" style="border-radius:0px" id="password" placeholder="Password">
                        </div>
                        <div class="col-md-12 text-center">
                            <button type="submit" class="btn btn-sm btn-default">Войти</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
