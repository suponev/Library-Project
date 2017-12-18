//Отправляем фоому "Добавление книги"
$(document).ready(function() {
    $('#add-book-form').submit(function(e) {
        e.preventDefault();
        var $form = $(this);
        if(!validateForm('add-book-form')){return;};
        $.ajax({
            traditional: true,
            type: $form.attr('method'),
            url:  $form.attr('action'),
            data: $form.serialize(),
            success: function (d) {
                if(d == "successfull") {
                    addRow();
                }
                else {
                    alert("Ошибка при добавлении")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка ошибка при удалении!")
            }

        })
        $('#add-book-modal').modal('hide');



    });

});
//Очищаем форму после закрытия
$(document).ready(function() {
    $('#add-book-modal').on('hidden.bs.modal', function () {
        $(this).find("input,textarea,select").val('').end();
    });
});
//Добавление одной строки для новой книге
function addRow()
{
    isbn = document.getElementById('isbnBook').value;
    title = document.getElementById('titleBook').value;
    author = document.getElementById('autorBook').value;

    var tbody = document.getElementById('table').getElementsByTagName('TBODY')[0];
    var row = createRow(isbn ,title , author ,null,false );
    tbody.appendChild(row);
    row.setAttribute("value",isbn);
    row.setAttribute("id",isbn);

};
//Создаем одну строку по параметрам
function createRow(isbn,title,author,username,chekUniq)
{


    var row = document.createElement("TR");


    if(chekUniq && document.getElementById(isbn))
    {
        return;
    }

    row.setAttribute("value", isbn);
    row.setAttribute("id", isbn);

    var td1 = document.createElement("TD");
    var td2 = document.createElement("TD");
    var td3 = document.createElement("TD");
    var td4 = document.createElement("TD");
    var td5 = document.createElement("TD");

    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    row.appendChild(td4);
    row.appendChild(td5);

    var a = document.createElement("a");
    var text = '<a href="#" class="update-book ">' + isbn.toString() +'</a>';

    a.innerHTML =  text;


    td1.innerHTML = a.innerHTML;
    td2.innerHTML = title;
    td3.innerHTML =author;

    if (username == null || username == "" || username == "null") {
        td4.innerHTML = '<a href="#" class="get-book">Взять</a>';
    }
    else {
        if (username == authorizeUser) {
            td4.innerHTML = '<a href="#" class="return-book">Вернуть</a>';
        }
        else
        {
            td4.innerHTML = username;
        }
    }
    td4.setAttribute("value" , username);
    td5.innerHTML = '<button  type=\"submit\" class=\'btn-del-book btn btn-info btn-xs pull-right\' > Удалить</button>';


    return row;
}
