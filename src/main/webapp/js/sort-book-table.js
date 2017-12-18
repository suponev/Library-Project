var curretnSortColumn = 'author'; //Колонка по которой сортируем
var curretnSortDirection = 'direct';//Порядок сортировки
var currentNumLines = 5 ; //Количесво выведеных элементов
//Событие смены колонки или порядка сортировки
$(document).ready(function() {
    $('.sort-header').on('click', function () {

        var currentNumLines =  0;
        if($(this).attr('value') == curretnSortColumn)
        {
            changeSortDirection();
        }
        else
        {
             changeSortColumn();
             curretnSortDirection = 'direct';
        }
        loadData();

    });
});


//Функция замены колонки и стилей
function changeSortColumn () {
    if(curretnSortColumn == 'author')
    {
        curretnSortColumn='title';
        document.getElementById('authorHeader').style.color = '#000000';
        document.getElementById('titleHeader').style.color = '#18bc9c';
    }
    else
    {

        curretnSortColumn='author';
        document.getElementById('authorHeader').style.color = '#18bc9c';
        document.getElementById('titleHeader').style.color = '#000000';
    }
    currentNumLines = 0;

}
//Функция замены порядка сортировки
function changeSortDirection() {
    if(curretnSortDirection == 'direct')
    {
        curretnSortDirection='revers';
    }
    else
    {
        curretnSortDirection='direct';
    }
    currentNumLines = 0;

}


//Обрабатываем нажатие  "Показать еще "
$(document).ready(function() {
    $('.btn-show-more').on('click', function () {
        loadData();
    });
});


//Создаем новое tbody для подмены или добавления
function builtTbody(d , chekUniq)
{
    ;
    var books =  JSON.parse(d);
    var temp_body = document.createElement("tbody");
    for (i = 0 ;i<books.length ; i++)
    {

        var row = createRow(books[i].isbn ,
                            books[i].title,
                            books[i].author,
                            books[i].username,
                            chekUniq);
        temp_body.appendChild(row);

    }

    return temp_body;

}
//Основная функция подгрузки данных и обновления таблицы
function loadData ()
{

    $.ajax({
        url: '/loadData',
        method: 'get',
        traditional: true,
        data:
            {
                sortColumn: curretnSortColumn ,
                sortDirection : curretnSortDirection,
                currentNumLine : currentNumLines
            },
        success: function (d) {

            var tbody = document.getElementById('table').getElementsByTagName('TBODY')[0]
            var new_tbody = builtTbody(d, false);

            if(currentNumLines == 0) {
                tbody.innerHTML = (new_tbody.innerHTML);
            }
            else
            {
                tbody.innerHTML+=(new_tbody.innerHTML)
            }
            currentNumLines = currentNumLines+5;
        },
        error: function (d) {
            alert("Непредвиденная при обновлении!")
        }
    })
}




