$(document).ready(function (){
    $("form button").on("click", function (e){
        let send = true;
        e.preventDefault();
        let emailPattern = new RegExp(/^(?=.{1,64}@)[A-Za-z0-9_-]+(\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\.[A-Za-z0-9-]+)*(\.[A-Za-z]{2,})$/gm);
        let passwordPattern = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,30}$/gm);
        let username = $('#username').val();
        let password = $('#password').val();
        let email = $('#email').val();
        let matchingPassword = $('#password-confirm').val();

        if(username.length < 6 || username.length > 30){
            $("#userHelp").toggleClass("none");
            send = false;
        }

        if(passwordPattern.test(password) === false){
            $("#passwordHelp").toggleClass("none");
            send = false;
        }

        if(emailPattern.test(email) === false){
            $("#emailHelp").toggleClass("none");
            send = false;
        }

        if(password !== matchingPassword){
            $("#passwordConfirmHelp").toggleClass("none");
            send = false;
        }
        if(send) sendForm();
    })
})

function sendForm(){
    let data = {};
    data.username = $('#username').val();
    data.password = $('#password').val();
    data.email = $('#email').val();
    data.matchingPassword = $('#password-confirm').val();
    $.ajax({
        type: "POST",
        url: window.location.origin + "/auth/register",
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(data),
        success: function (res){
            console.log(res);
            window.location.replace(window.location.origin + "/register?success=true");
        },
        error: function (){
            window.location.replace(window.location.origin + "/register?error=true")
        }
    })
}