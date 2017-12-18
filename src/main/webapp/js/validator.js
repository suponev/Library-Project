function validateForm(formId)
{
    var inputs = document.getElementById(formId).getElementsByTagName('input');

    for (i = 0; i < inputs.length; i++) {
        if(inputs[i].value.length == 0)
        {
            alert("Пожалуйста, заполните все поля!")
            return false ;

        }
    }
    return true;

};