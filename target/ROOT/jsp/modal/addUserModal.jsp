<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
    <meta charset="UTF-8">
<body>
<div class="modal fade" id="add-user-modal">
    <div class="modal-dialog">
        <div class=".col-xs-6 .col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h2 class="text-center">Новый пользыватель</h2>
                        <p>Добавьте нового пользывателя</p>
                        <div class="panel-body">
                            <form class="form" id="add-user-form" action="/sendUser" method="post" >

                                <fieldset>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="username" id="useranmeNewUser" placeholder="Введите уникальное имя пользывателя" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="password" id="passwordNewUser" placeholder="Введите пароль" class="form-control" type="text" >
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