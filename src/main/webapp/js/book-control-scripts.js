var authorizeUser = null;
//Получаем username авторизованного пользывателя
$(document).ready(function() {

        $.ajax({
            url: '/getAuthorizeUser/',
            method: 'get',
            traditional: true,
            success: function (d) {
               authorizeUser = d ;
            },
            error: function (d) {
                alert("Непредвиденная ошибка !")
            }
        })

});
//Удаление книги
$(document).ready(function() {
    $(document).on( 'click', ".btn-del-book", function (e) {
        e.preventDefault();
        var tr = $(this).closest('tr');
        $.ajax({
            url: '/dellBook/',
            method: 'POST',
            traditional: true,
            data:
                {
                    isbn: tr.attr("value")
                },
            success: function (d) {
                if(d == "successfull")
                {
                    tr.remove();

                }
                else {alert("Ошибка при удалении!")}
            },
            error: function (d) {
             alert("Непредвиденная ошибка ошибка при удалении!")
            }
        })

    })
});
//Пользыватель возвращяет книгу
$(document).ready(function() {
    $(document).on( 'click', ".return-book", function (e) {
        e.preventDefault();
        var tr = $(this).closest('tr');
        var td = $(this).closest('td');

        //alert(td.attr('value'));
        $.ajax({
            url: '/returnBook',
            method: 'POST',
            traditional: true,
            data:
                {
                    isbn: tr.attr('value')
                },
            success: function (d) {
                if(d == "successfull")
                {
                    var temp = document.createElement('td');
                    temp.innerHTML =  '<a href="#" class="get-book">Взять</a>';
                    td.html(temp.innerHTML);


                }
                else {alert("Не удалось вернуть книгу!")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка!")
            }
        })

    })

});
//Пользыватель берет книгу
$(document).ready(function() {
    $(document).on( 'click', ".get-book", function (e) {
        e.preventDefault();
        var tr = $(this).closest('tr');
        var td = $(this).closest('td');

        $.ajax({
            url: '/gettingBook',
            method: 'POST',
            traditional: true,
            data:
                {
                    isbn: tr.attr("value"),
                    username: 'a'
                },
            success: function (d) {
                if(d == "successfull")
                {

                    var temp = document.createElement('td');
                    temp.innerHTML =  '<a href="#" class="return-book">Вернуть</a>';
                    td.html(temp.innerHTML);


                }
                else {alert("Не удалось взять книгу!")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка!")
            }
        })

    })
});
//Создание одно строки в таблице

