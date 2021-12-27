
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

$(document).on('input', '#search-bar', function (){
    searchAtms($("#search-bar").val().toString().toLowerCase().trim());
});

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
$(document).ready(function (){
    filterTable();
})


$(document).on("change", "#select", function (){
    filterTable();
})

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


