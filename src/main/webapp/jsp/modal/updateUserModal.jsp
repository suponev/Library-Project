<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div class="modal fade" id="update-user-modal">
        <div class="modal-dialog">
            <div class=".col-xs-6 .col-md-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h2 class="text-center">Обновление данных пользывателя</h2>
                            <p>Введите новое имя и пароль</p>
                            <div class="panel-body">
                                <form class="form" id="update-user-form" action="/updateUser" method="post" >
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="newUsername" id="useranmeUpdateUser" placeholder="Введите уникальное имя пользывателя" class="form-control" type="text" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-book color-blue"></i></span>
                                            <input name="newPassword" id="passwordUpdateUser" placeholder="Введите пароль" class="form-control" type="password" >
                                        </div>
                                    </div>
                                    <input class="hidden" name="oldUsername"  id="oldUsernameUpdateUser" value="" class="form-control" type="text" >
                                    <div  >
                                        <button class="btn btn-rg btn-primary  " type="submit" >Обновить</button>
                                        <button  class="btn btn-rg  btn-secondary" data-dismiss="modal">Закрыть</button>
                                    </div>
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