//Открытие формы с предварительно заполненными полями
$(document).ready(function() {
    $(document).on( 'click', ".update-book", function (e) {
        e.preventDefault();
        $('#update-book-modal').modal('show');
        $('#isbnUpdateBook').val($(this).closest('tr').attr('value'));
        $('#oldIsbnUpdateBook').val($(this).closest('tr').attr('value'));

    })
});
//Отправка формы "Обновление книги"
$(document).ready(function() {
    $('#update-book-form').submit(function(e) {
        e.preventDefault();
        var $form = $(this);
        if(!validateForm('update-book-form')){return;};
        $.ajax({
            traditional: true,
            type: $form.attr('method'),
            url:  $form.attr('action'),
            data: $form.serialize(),
            success: function (d) {
                if(d == "successfull") {
                    updateBookRow();
                }
                else {alert("Ошибка при лбновлении")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка ошибка при обновлении!")
            }
        })

        $('#update-book-modal').modal('hide');
    });

});


function updateBookRow() {
    var isbn = document.getElementById('isbnUpdateBook').value;
    var oldIsbn = document.getElementById('oldIsbnUpdateBook').value;
    var title = document.getElementById('titleUpdateBook').value;
    var author = document.getElementById('authorUpdateBook').value;
    var username = document.getElementById(oldIsbn).getElementsByTagName('td')[3].getAttribute('value');
    var  row = createRow(isbn,title,author,username,false);
    document.getElementById(oldIsbn).innerHTML= row.innerHTML;
}

