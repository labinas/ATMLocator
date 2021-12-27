var str = window.location.pathname.split("/");
var id = str[2];
var url = window.location.origin + "/api/atms/" + id;

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
    },
    error: function (){
        map.setView([41.9947, 21.3835], 12);
    }
});



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
})









