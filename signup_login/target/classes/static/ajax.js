document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("submitBtn").addEventListener("click", function() {
        // Get form values
        var firstName = document.getElementById("first_name").value;
        var lastName = document.getElementById("last_name").value;
        var email = document.getElementById("email").value;

        // Create data object
        var userData = {
            firstName: firstName,
            lastName: lastName,
            email: email
        };

        // Send data to backend
        postData(userData);
    });
});

function postData(userData) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/register", // Replace with your endpoint URL
        data: JSON.stringify(userData),
        contentType: "application/json",
        success: function(response) {
            console.log("Data posted successfully");
        },
        error: function(xhr, status, error) {
            console.error("Error posting data: " + error);
        }
    });
}
