<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<html>
<head>

<meta charset="UTF-8">
    <body>
<div class="modal fade" id="add-book-modal">
    <div class="modal-dialog">

        <div class=".col-xs-6 .col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h2 class="text-center">Новая книга</h2>
                        <p>Добавьте новую книгу</p>
                        <div class="panel-body">
                            <form class="form" id="add-book-form" action="/sendBook" method="post" >

                                <fieldset>

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="isbn" id="isbnBook" placeholder="Введите уникальный номер" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="title" id="titleBook" placeholder="Введите название книги" class="form-control" type="text" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="author" id="autorBook" placeholder="Введите автора" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div  >
                                        <button class="btn btn-rg btn-primary  " type="submit" >Добавить</button>
                                        <button  class="btn btn-rg  btn-secondary" data-dismiss="modal">Закрыть</button>
                                    </div>
                                </fieldset>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</head>
</html>