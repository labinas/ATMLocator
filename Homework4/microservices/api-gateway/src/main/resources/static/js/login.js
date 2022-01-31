$(document).ready(function (){
    $("form button").on("click", function (e){
        e.preventDefault();

        let data = {};
        data.username = $('#username').val();
        data.password = $('#password').val();
        $.ajax({
            type: "POST",
            url: window.location.origin + "/auth/login",
            dataType: 'application/json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(data),
            success: function (res){
                console.log(res);
                window.location.replace(window.location.origin);
            },
            error: function (res){
                console.log(res);
                //window.location.replace(window.location.origin + "/login?error=true")
            }
        })
    })
})