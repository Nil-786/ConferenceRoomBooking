document.addEventListener("DOMContentLoaded", function() {
    const addMoreButton = document.getElementById("addMore");
    const photoList = document.getElementById("photoList");

    // Function to create a new input file element
    function createPhotoInput() {
        // Create a container div for the input and remove button
        const div = document.createElement("div");
        div.className = "mb-2 d-flex align-items-center";

        // Create the file input element
        const input = document.createElement("input");
        input.type = "file";
        input.name = "photos[]";
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

        // Append the input and remove button to the container div
        div.appendChild(input);
        div.appendChild(removeButton);

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