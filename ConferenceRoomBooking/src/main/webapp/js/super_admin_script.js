document.addEventListener("DOMContentLoaded", function() {
    const addMoreButton = document.getElementById("addMore");
    const photoList = document.getElementById("photoList");

    // Function to create a new input file element
    function createPhotoInput() {
        // Create a container div for the input and remove button
<<<<<<< HEAD
        const div = document.createElement("form");
        div.className = "mb-2 d-flex align-items-center";
        div.id = "photoForm";
=======
        const div = document.createElement("div");
        div.className = "mb-2 d-flex align-items-center";
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297

        // Create the file input element
        const input = document.createElement("input");
        input.type = "file";
<<<<<<< HEAD
        input.name = "data";
        input.id = "photo";
=======
        input.name = "photos[]";
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297
        input.className = "form-control";
        input.accept = "image/*";

        // Create the remove button
        const removeButton = document.createElement("button");
        removeButton.type = "button";
        removeButton.className = "btn btn-danger btn-sm ms-2";
        removeButton.textContent = "Remove";
        removeButton.onclick = function() {
            div.remove();
        };
<<<<<<< HEAD
        
        const addButton = document.createElement("button");
        addButton.type = "submit";
        addButton.className = "btn btn-success btn-sm ms-2";
        addButton.textContent = "Upload";
        //addButton.id = "addButton"
        /*addButton.onclick = function() {
            div.remove();
        };*/
=======
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297

        // Append the input and remove button to the container div
        div.appendChild(input);
        div.appendChild(removeButton);
<<<<<<< HEAD
        div.appendChild(addButton);
=======
>>>>>>> b205dd3d8a2c977455e19359ef6381b5f4065297

        // Append the container div to the photoList div
        photoList.appendChild(div);
    }

    // Event listener for the "Add More Image" button
    addMoreButton.addEventListener("click", function() {
        createPhotoInput();
    });

    // Add an initial photo input when the page loads
    createPhotoInput();
});