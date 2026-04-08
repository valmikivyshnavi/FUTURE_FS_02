alert("JS loaded");
function addCustomer() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;

    if (name === "" || email === "") return;

    var table = document.getElementById("list");

    var row = "<tr><td>" + name + "</td><td>" + email + "</td><td><button onclick='deleteRow(this)'>Delete</button></td></tr>";

    table.innerHTML += row;

    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
}

function deleteRow(btn) {
    var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}