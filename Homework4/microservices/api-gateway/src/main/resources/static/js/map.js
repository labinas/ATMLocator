var mapContainer = document.getElementById("modal-map-container");
var openMapButton = document.getElementById("open-map-button");
var closeMapButton = document.getElementById("modal-close");
var atmLocations = {};

openMapButton.addEventListener("click", () => {
    mapContainer.classList.add("show");
})

closeMapButton.addEventListener("click", () =>{
    mapContainer.classList.remove("show");
})



var map = L.map('map').setView([41.9947, 21.3835], 12);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

var LeafIcon = L.Icon.extend({
    options: {
        iconSize:     [50, 50],
        iconAnchor:   [25, 50],
        popupAnchor:  [0, -50]
    }
});

var myPin = new LeafIcon({iconUrl: '/img/map-pin.png'});


$(document).ready(function (){
    var markerLayer;
    var value = $("#map-filter").val();

    function updateMap(value){
        var url = (value === 'all') ? window.location.origin + "/bank/atms" : window.location.origin + "/bank/atms?bank=" + value;
        if(typeof(markerLayer) != "undefined")
            map.removeLayer(markerLayer);

        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=utf8',
            success: function(res) {
                atmLocations = res;
                var markers = [];
                $.each(atmLocations, function (i,location){
                    var popup = "<p class='popup-line'><span class='popup-t'>Bank:</span>  " + location["name"] + "</p><p class='popup-line'><span class='popup-t'>Address: </span>" + location["addrStreet"] + " " + location["addrHousenumber"] + "</p>";
                    var loc = L.marker([location["lat"], location["lon"]], {icon: myPin}).bindPopup(popup);
                    markers.push(loc);
                })
                setMarkerLayer(markers);
            }
        });
    }

    updateMap(value);

    function setMarkerLayer(arr){
        markerLayer = L.layerGroup(arr);
        markerLayer.addTo(map);
    }

    $("#map-filter").on("change", function (){
        value = $(this).find("option:selected").val();
        updateMap(value);
    })

})

