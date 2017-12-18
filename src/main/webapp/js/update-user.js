//Открытие формы с предварительно заполненными полями
$(document).ready(function() {
    $(document).on( 'click', ".update-user", function (e) {
        e.preventDefault();
       $('#update-user-modal').modal('show');
       $('#oldUsernameUpdateUser').val($(this).closest('tr').attr('value'));
    })
});
//Отправка формы "Обновление пользывателя"
$(document).ready(function() {
    $('#update-user-form').submit(function(e) {
        e.preventDefault();
        var $form = $(this);

        if(!validateForm('update-user-form')){ return; };

        $.ajax({
            traditional: true,
            type: $form.attr('method'),
            url:  $form.attr('action'),
            data: $form.serialize(),
            success: function (d) {
                if(d == "successfull") {
                    updateUserRow();
                }
                else {alert("Ошибка при лбновлении")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка ошибка при обновлении!")
            }
        })

        $('#update-user-modal').modal('hide');

    });

});
function updateUserRow()
{    var username = document.getElementById('useranmeUpdateUser').value;
    var oldUsername = document.getElementById('oldUsernameUpdateUser').value;
    var  row = createRowUser(username)
    document.getElementById(oldUsername).innerHTML= row.innerHTML;
}