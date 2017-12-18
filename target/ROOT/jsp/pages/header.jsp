<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<html>
<head>
    <style>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/bootstrap-notifications.min.css"%>
    </style>
</head>
    <body>
        <nav class="navbar navbar-default" role="navigation" style="border-radius: 0px 0px 0px 0px;">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/">Список книг</a></li>
                        <li><a href="/listUser">Список пользывателей</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><span class="glyphicon glyphicon-user"></span> ></b> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/logout">Выход</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
    </body>
</html>