<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>




<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Список книг</title>
    <style>
        <%@include file="/css/thead.sorted.css"%>
    </style>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.js"></script>
    <script type="text/javascript" src="pages/static/js/jquery.tablesorter.min.js"></script>
    <script type="text/javascript" src="/js/static/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/js/static/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="/js/static/bootstrap.min.js"></script>


    <script type="text/javascript" src="/js/book-control-scripts.js"></script>
    <script type="text/javascript" src="/js/update-book.js"></script>
    <script type="text/javascript" src="/js/sort-book-table.js"></script>
    <script type="text/javascript" src="/js/add-book.js"></script>
    <script type="text/javascript" src="/js/validator.js"></script>

    <%@include file='/jsp/pages/header.jsp'%>
    <%@include file='/jsp/modal/addBookModal.jsp'%>
    <%@include file='/jsp/modal/updateBookModal.jsp'%>


</head>
<body>
    <div class="resume">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-offset-0 col-md-4 col-lg-offset-2 col-lg-8">
                <div class="col-md-12 text-center">
                    <header class="page-header">
                        <h1 class="page-title">Все книги </h1>
                    </header>
                    <table id="table" class="table table-striped ">
                        <thead>
                        <tr>
                            <th >Isbn</th>
                            <th  href=# class="sort-header" id="titleHeader" value="title" >Title</th>
                            <th  class="sort-header"  id = "authorHeader" value="author" style="color: #18bc9c;">Author</th>
                            <th>Username</th>
                            <td><a href="#"  role="button"   class="btn btn-primary btn-xs pull-right" data-toggle="modal" data-target="#add-book-modal" > <span class="glyphicon glyphicon-plus"></span> Добавить</a></td>
                        </tr>
                        </thead>
                        <tbody >
                        <c:forEach  var="book" items="${books}">
                            <tr value="${book.getIsbn()}" id="${book.getIsbn()}" >
                                <td>
                                    <a href="#" class="update-book"> ${book.getIsbn()}</a>
                                </td>
                                <td>${book.getTitle()}</td>
                                <td >${book.getAuthor()}</td>
                                <c:choose>
                                    <c:when test="${book.getUsername()== pageContext.request.remoteUser}">
                                        <td value="${book.getUsername()}" > <a    href="#" class="return-book">Вернуть</a> </td>
                                    </c:when>
                                    <c:when test="${ book.getUsername() == null}">
                                        <td value="${book.getUsername()}" ><a  href="#" class="get-book">Взять</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td value="${book.getUsername()}">${book.getUsername()}</td>
                                    </c:otherwise>
                                </c:choose>
                                <td><button  type=\"submit\" class='btn-del-book btn btn-info btn-xs pull-right' > Удалить</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel panel-default center">
                    <div class="panel-heading page-center">
                            <button  class="btn-show-more center-block">Показать еще </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>


