let customers = JSON.parse(localStorage.getItem("customers")) || [];
let editIndex = -1;

function display(data = customers) {
    let list = document.getElementById("list");
    list.innerHTML = "";

    data.forEach((c, i) => {
        list.innerHTML += `
        <tr>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>
                <button onclick="edit(${i})">Edit</button>
                <button onclick="remove(${i})">Delete</button>
            </td>
        </tr>`;
    });
}

document.getElementById("form").addEventListener("submit", function(e) {
    e.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;

    if (editIndex === -1) {
        customers.push({ name, email });
    } else {
        customers[editIndex] = { name, email };
        editIndex = -1;
    }

    localStorage.setItem("customers", JSON.stringify(customers));
    display();
    this.reset();
});

function edit(i) {
    document.getElementById("name").value = customers[i].name;
    document.getElementById("email").value = customers[i].email;
    editIndex = i;
}

function remove(i) {
    customers.splice(i, 1);
    localStorage.setItem("customers", JSON.stringify(customers));
    display();
}

document.getElementById("search").addEventListener("input", function() {
    let value = this.value.toLowerCase();
    let filtered = customers.filter(c =>
        c.name.toLowerCase().includes(value)
    );
    display(filtered);
});

display();