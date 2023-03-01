document.addEventListener("DOMContentLoaded", (event) => {
const addField = document.getElementById("addField");
addField.addEventListener("click", addSearchField);
});

function addSearchField() {
const searchFieldsDiv = document.getElementById('searchFields');
const searchField = document.createElement("select");
searchField.required = true;
searchField.setAttribute("name", "searchFieldOrdinals");

let option;

option = document.createElement("option");
option.setAttribute("value", "");
option.text = "Select a field to search by:";
option.selected = true;
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "0");
option.text = "Common Name";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "1");
option.text = "Scientific Name";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "2");
option.text = "Publication Year";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "3");
option.text = "Bibliography";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "4");
option.text = "Author";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "5");
option.text = "Family Common Name";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "6");
option.text = "Genus";
searchField.add(option);

option = document.createElement("option");
option.setAttribute("value", "7");
option.text = "Family";
searchField.add(option);

const fields = searchField.options;

const searchFieldSpan = document.createElement("span");
searchFieldSpan.appendChild(searchField);

searchField.addEventListener("change", displayInputElement);
searchFieldsDiv.appendChild(searchFieldSpan);
    const rmvButton = document.createElement("button");
    rmvButton.setAttribute("type", "button");
    rmvButton.innerHTML = "Remove criterion";
    rmvButton.addEventListener("click", removeField);
    searchFieldsDiv.appendChild(rmvButton);
    searchFieldsDiv.appendChild(document.createElement("br"));
}

function displayInputElement(event) {
    const fieldSelect = event.target;
    while (fieldSelect.nextSibling) {
    fieldSelect.nextSibling.remove();
    }
    if (fieldSelect.selectedIndex === 0) {
    }
    else {
    const fields = fieldSelect.options;
    let input = document.createElement("input");
    input.required = true;
    if (fields[fieldSelect.selectedIndex].label === "Publication Year") {
        input.setAttribute("type", "number");
        input.setAttribute("min", 1000);
        input.setAttribute("max", 2100);
        input.setAttribute("value", 1900);
        input.setAttribute("step", 1);
        input.setAttribute("name", "q");
    }
    else {
        input.setAttribute("type", "search");
        input.setAttribute("name", "q");
    }
    fieldSelect.after(input);
    }
}

function removeField(event) {
     event.target.previousElementSibling.remove();
     event.target.nextElementSibling.remove();
     event.target.remove();
}