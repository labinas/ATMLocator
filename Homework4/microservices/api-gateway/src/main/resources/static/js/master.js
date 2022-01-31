console.log(getCookie("usernameCookie"))
var isLoggedIn = (getCookie("usernameCookie").length > 0);
var loggedUserId = "";
var loggedUsername = "";
if(isLoggedIn){
    loggedUserId = getCookie("userIDCookie");
    loggedUsername = getCookie("usernameCookie");
    toggleNavbarButtons();
    $("#userGreeting").html("Welcome, <strong>" + loggedUsername + "</strong>!");
}

function toggleNavbarButtons(){
    $("#signInBtn").toggleClass("none");
    $("#signUpBtn").toggleClass("none");
    $("#signOutBtn").toggleClass("none");
    $("#myAtmBtn").toggleClass("none");
}

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

$(document).on("click","#signOutBtn", function (){
    $.ajax({
        type: "GET",
        url: window.location.origin + "/auth/logout",
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response){
            if(response.length > 0)
                window.location.href = window.location.origin;
        }
    })
})

