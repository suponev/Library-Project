

$(document).ready(function() {
    $(document).on( 'click', ".btn-del-user", function (e) {
        e.preventDefault();
        var tr = $(this).closest('tr');
        $.ajax({
            url: '/deleteUser/',
            method: 'POST',
            traditional: true,
            data:
                {
                    username: tr.attr("value")
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