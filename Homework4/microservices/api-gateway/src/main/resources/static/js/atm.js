var str = window.location.pathname.split("/");
var id = str[2];
var url = window.location.origin + "/bank/atms/" + id;

var map = L.map('map');

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

var LeafIcon = L.Icon.extend({
    options: {
        iconSize:     [40, 40],
        iconAnchor:   [20, 40],
        popupAnchor:  [0, -40]
    }
});

var myPin = new LeafIcon({iconUrl: '/img/map-pin.png'});


$.ajax({
    url: url,
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json; charset=utf8',
    success: function(location) {
        map.setView([location["lat"], location["lon"]], 14);
        var popup = "<p class='popup-line'><span class='popup-t'>Bank:</span>  " + location["name"] + "</p><p class='popup-line'><span class='popup-t'>Address: </span>" + location["addrStreet"] + " " + location["addrHousenumber"] + "</p>";
        var loc = L.marker([location["lat"], location["lon"]], {icon: myPin}).bindPopup(popup).addTo(map);
        setAtmInformation(location);
    },
    error: function (){
        map.setView([41.9947, 21.3835], 12);
    }
});

function setAtmInformation(atm){
    let saved = checkIfSaved();
    let bankInfo = getBankInfo(atm["nameEn"]);
    let atmRating = rating(atm["rating"]);
    let reviews = getReviewsByAtm();

    $("#atmName").text(atm["name"]);
    $(".atm-addr").text(atm["addrStreet"] + ' ' + atm["addrHouseNumber"]);
    $(".bank-num").attr("href", "tel:" + bankInfo["number"]).text(bankInfo["contact"]);
    $(".additional-info").text("Open: " + atm["openingHours"]);
    if(isLoggedIn){
        $("#leave-review").toggleClass("none");
        if(saved)
            $(".btn-remove").toggleClass("none").attr("href", "/bank/atms/remove/" + id + "?user=" + loggedUserId);
        else
            $(".btn-save").toggleClass("none").attr("href", "/bank/atms/add/" + id + "?user=" + loggedUserId);
    }
    let entry = $("<div class='atmEntry'></div>");
    entry.append(atmRating);
    $(".atm-rating").append(entry);
    if(Object.keys(reviews).length > 0)
        $("#no-reviews").addClass("none");
    $.each(reviews, function (i, review){
        let li = $("<li></li>");
        let reviewInfo = $("<div class='review-info'></div>");
        let reviewText = $("<p class='r-text'></p>");
        let reviewRating = $("<div class='r-rating'></div>");
        reviewText.append(review["reviewText"]);
        reviewRating.append(rating(review["rating"]));
        reviewInfo.append(reviewText);
        reviewInfo.append(reviewRating);
        li.append(reviewInfo);
        $('#r-list').append(li);
    })

}

function checkIfSaved(){
    let saved = false;
    $.ajax({
        url: window.location.origin + "/users/checkIfSaved?user=" + loggedUserId + "&atm=" + id,
        type: 'GET',
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response){
            console.log("saved: " + response);
            saved = response;
        }
    })
    return saved;
}

function getBankInfo(bankName){
    let info = {};
    $.ajax({
        url: window.location.origin + "/bank/get/" + bankName,
        type: 'GET',
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response){
            console.log("bank info: " + response);
            info = response;
        }
    })
    return info;
}

function getReviewsByAtm(){
    let info = {};
    $.ajax({
        url: window.location.origin + "/reviews/atm/" + id,
        type: 'GET',
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response){
            console.log("reviews: " + response);
            info = response;
        }
    })
    return info;
}

function rating(r){
    let zero = $("<i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>");
    let one = $("<i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let two = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let three = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let four = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i>")
    let five = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i>")

    if(r === null || r === 0) return zero;
    if(r === 1) return one;
    if(r === 2) return two;
    if(r === 3) return three;
    if(r === 4) return four;
    if(r === 5) return five;
}

$(document).ready(function (){
    var openReviewsButton = document.getElementById("open");
    var leaveReviewsButton = document.getElementById("leave-review");
    console.log(leaveReviewsButton);
    var closeReviewsButton = document.getElementById("modal-close");
    var modalContainer = document.getElementById("modal-container");

    openReviewsButton.addEventListener("click", () => {
        modalContainer.classList.add("show");
        $("#review-list").show();
    })

    if(leaveReviewsButton != null){
        leaveReviewsButton.addEventListener("click", ()=> {
            modalContainer.classList.add("show");
            $("#review-form").show();
        })
    }


    closeReviewsButton.addEventListener("click", () => {
        modalContainer.classList.remove("show");
        $("#review-list").hide();
        $("#review-form").hide();
    })

    $("#submit-button").prop('disabled', true);
    $(document).on("keyup", "#comment", function (){
        if($(this).val().length > 0 && $("input[name='rating']").val() != null)
            $("#submit-button").prop('disabled', false);
        else $("#submit-button").prop('disabled', true);
    })
    $(document).on("click", "input[name='rating']", function (){
        $("#submit-button").prop('disabled', false);
    })

    $(document).on('click', '#submit-button', function (e){
        e.preventDefault();
        let data = {};
        data.userId = Number.parseInt(loggedUserId);
        data.reviewText = $("#comment").val();
        data.rating = $("input[name='rating']").val();

        $.ajax({
            url: window.location.origin + "/reviews/submit/" + id,
            type: 'POST',
            data: JSON.stringify(data),
            dataType: 'application/json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (response){
                console.log(response);
                location.reload();
            }
        })
    })

})









