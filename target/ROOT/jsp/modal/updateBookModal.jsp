<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div class="modal fade" id="update-book-modal">
        <div class="modal-dialog">
            <div class=".col-xs-6 .col-md-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h2 class="text-center">Обновить книгу</h2>
                            <p>Введите новые данные для книги</p>
                            <div class="panel-body">
                                <form class="form" id="update-book-form" action="/updateBook" method="post" >
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="isbnDisable" id="isbnUpdateBook"  class="form-control" type="text"  disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="title"   id="titleUpdateBook" placeholder="Введите название книги" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input  name="author" id="authorUpdateBook"  placeholder="Введите автора" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div>
                                        <button class="btn btn-rg btn-primary  " type="submit" >Обновить</button>
                                        <button  class="btn btn-rg  btn-secondary" data-dismiss="modal">Закрыть</button>
                                    </div>
                                    <input class="hidden" name="isbn"  id="oldIsbnUpdateBook" class="form-control" type="text" >
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>