//var loggedIn = (getCookie("accessCookie").length > 0);


var special = {
    "gj":"ѓ",
    "zh":"ж",
    "dz":"ѕ",
    "lj":"љ",
    "nj":"њ",
    "kj":"ќ",
    "ch":"ч",
    "dzh":"џ",
    "sh":"ш"
}

var normal = {
    "a":"а",
    "b":"б",
    "v":"в",
    "g":"г",
    "d":"д",
    "e":"е",
    "z":"з",
    "i":"и",
    "j":"ј",
    "k":"к",
    "l":"л",
    "m":"м",
    "n":"н",
    "o":"о",
    "p":"п",
    "r":"р",
    "s":"с",
    "t":"т",
    "u":"у",
    "f":"ф",
    "h":"х",
    "c":"ц"
}

$(document).ready(function (){
    $.when(fetchTableData()).done(filterTable());
})

$(document).on('input', '#search-bar', function (){
    searchAtms($("#search-bar").val().toString().toLowerCase().trim());
});

$(document).on("change", "#select", function (){
    filterTable();
})

function searchAtms(str){
    for(var key in special){
        var regex = new RegExp(key, 'g');
        str = str.replace(regex, special[key]);
    }

    for(var key in normal){
        var regex = new RegExp(key, 'g');
        str = str.replace(regex, normal[key]);
    }

    $(".atm").each(function (){
        $(this).hide();
        var name = $(this).find('.atmEntryName').text().toLowerCase();
        var addr = $(this).find('.atmEntryAddr').text().toLowerCase();
        if(name.includes(str) || addr.includes(str))
            $(this).show();
    })
}

function fetchTableData(){
    let url;
    if(isLoggedIn && $("#atmTitle").text() === "MY ATMs"){
        url = window.location.origin + "/bank/atms?user=" +loggedUserId;
    }else{
        url = window.location.origin + "/bank/atms"
    }

    return $.ajax({
        type: "GET",
        url: url,
        dataType: 'application/json',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (response){
            console.log("atms: " + response);
            fillTable(response);
        },
        error: function (){
            console.log("error");
        }
    })
}

function fillTable(atms){
    let zero = $("<i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>");
    let one = $("<i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let two = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let three = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i><i class='far fa-star'></i>")
    let four = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='far fa-star'></i>")
    let five = $("<i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i><i class='fas fa-star'></i>")

    $.each(atms, function (i, atm){
        let atmLink = "/atm/" + atm["id"];
        let atmName = (atm["name"].length > 0) ? atm["name"] : "ATM";
        let atmAddr = (atm["addrStreet"].length > 0)? atm["addrStreet"] + ' ' + atm["addrHouseNumber"] : "No known address";
        let tableRow = $("<tr class='atm'></tr>");
        tableRow.attr("data-id", atm["id"]);
        tableRow.attr("data-rating", atm["rating"]);
        tableRow.attr("data-name", (atm["name"].length > 0 )? atm["name"] : "ATM");
        let td1 = $("<td class='atmEntry'></td>");
        let td2 = $("<td class='atmEntry'></td>");
        let td3 = $("<td class='atmEntry'></td>");
        let atmEntryName = $("<a class='atmEntryName'></a>");
        atmEntryName.attr("href", atmLink);
        atmEntryName.text(atmName);
        td1.append(atmEntryName);
        let atmEntryAddr = $("<a class='atmEntryAddr'></a>");
        atmEntryAddr.attr("href", atmLink);
        atmEntryAddr.text(atmAddr);
        td2.append(atmEntryAddr);
        if(atm["rating"] === null || atm["rating"] === 0) td3.append(zero);
        if(atm["rating"] === 1) td3.append(one);
        if(atm["rating"] === 2) td3.append(two);
        if(atm["rating"] === 3) td3.append(three);
        if(atm["rating"] === 4) td3.append(four);
        if(atm["rating"] === 5) td3.append(five);
        tableRow.append(td1);
        tableRow.append(td2);
        tableRow.append(td3);
        $("#atm-table tbody").append(tableRow);
    })
}

function filterTable(){
    var val = $("#select option:selected").val();
    if(val === "alphabetic")
        sortTable(document.getElementById("atm-table"),true,"data-name");
    else if(val === "rating")
        sortTable(document.getElementById("atm-table"),false,"data-rating");
    else sortTable(document.getElementById("atm-table"),true,"data-id")
}

function sortTable(table, asc, data) {
    const dirModifier = asc ? 1 : -1;
    const tBody = table.tBodies[0];
    const rowElements = document.querySelectorAll(".atm");
    const rows = Array.from(rowElements);

    // Sort each row
    const sortedRows = rows.sort((a, b) => {
        const aColText = a.getAttribute(data);
        const bColText = b.getAttribute(data);

        return aColText > bColText ? (1 * dirModifier) : (-1 * dirModifier);
    });

    // Remove all existing TRs from the table
    while (tBody.firstChild) {
        tBody.removeChild(tBody.firstChild);
    }

    // Re-add the newly sorted rows
    tBody.append(...sortedRows);

}



