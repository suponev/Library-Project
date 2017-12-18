<%@ page language="java" contentType="text/html; charset=utf8"  pageEncoding="utf8" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Список пользывателей</title>

    <style>
        .table {
            width:100%;
            table-layout: fixed;
            transition: 3s;
            padding: 0;
            border: 2px;
        }

    </style>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.js"></script>
    <script type="text/javascript" src="/js/static/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="/js/static/bootstrap-datetimepicker.min.js"></script>

    <script type="text/javascript" src="/js/static/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="/js/static/bootstrap.min.js"></script>

    <script type="text/javascript" src="/js/add-user.js"></script>
    <script type="text/javascript" src="/js/del-user.js"></script>
    <script type="text/javascript" src="/js/update-user.js"></script>

    <%@include file='/jsp/pages/header.jsp'%>
    <%@include file='/jsp/modal/addUserModal.jsp'%>
    <%@include file='/jsp/modal/updateUserModal.jsp'%>

</head>

<body>
    <div class="resume">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
                <div class="col-md-12 text-center">

                    <div class="panel panel-default">
                        <div class="panel-heading resume-heading">
                            <div class="row">

                                <div class="container">
                                    <div class="row col-md-8 col-md-offset-1 custyle">
                                        <header class="page-header">
                                            <h1 class="page-title">Список всех пользывателей</h1>
                                        </header>

                                        <table id="table-users" class="table table-striped custab">
                                            <thead>
                                            <tr>
                                                <th>Имя пользывателя</th>
                                                <td><a href="#"  role="button"   class="btn  btn-primary btn-xs pull-right" data-toggle="modal" data-target="#add-user-modal" > <span class="glyphicon glyphicon-plus"></span> Добавить</a></td>
                                            </tr>
                                            </thead>
                                            <tbody >
                                            <c:forEach  var="user" items="${users}">
                                                <tr value="${user.getUsername()}" id="${user.getUsername()}" >
                                                <td>
                                                    <a href="#" class="update-user"> ${user.getUsername()}</a>
                                                </td>
                                                <td><button   class='btn-del-user  btn btn-info btn-xs pull-right' > Удалить</button></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>





