$(document).ready(function() {
    $('#add-user-form').submit(function(e) {
        e.preventDefault();
        var $form = $(this);
        if(!validateForm('add-user-form')){return;};
        $.ajax({
            traditional: true,
            type: $form.attr('method'),
            url:  $form.attr('action'),
            data: $form.serialize(),
            success: function (d) {
                if(d == "successfull") {
                    addRowUser();
                }
                else {
                    alert("Ошибка при добавлении")}
            },
            error: function (d) {
                alert("Непредвиденная ошибка ошибка при удалении!")
            }

        })
        $('#add-user-modal').modal('hide');


    });

});

$(document).ready(function() {
    $('#add-user-modal').on('hidden.bs.modal', function () {
        $(this).find("input,textarea,select").val('').end();
    });
});



function addRowUser()
{
    username =document.getElementById('useranmeNewUser').value;
    var tbody = document.getElementById('table-users').getElementsByTagName('TBODY')[0];
    var row = createRowUser(username );
    tbody.appendChild(row);
    row.setAttribute("value",isbn);
    row.setAttribute("id",isbn);

};

function createRowUser(username)
{
    var row = document.createElement("TR");
    row.setAttribute("value", username);
    row.setAttribute("id", username);

    var td1 = document.createElement("TD");
    var td2 = document.createElement("TD");

    row.appendChild(td1);
    row.appendChild(td2);

    var a = document.createElement("a");
    var text = '<a href="#" class="update-user ">' + username.toString() +'</a>';
    a.innerHTML =  text;

    td1.innerHTML = a.innerHTML;
    td1.innerHTML = a.innerHTML;
    td2.innerHTML = '<button  type=\"submit\" class=\'btn-del-user btn btn-info btn-xs pull-right\' > Удалить</button>';

    return row;
}