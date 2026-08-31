const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", function (event) { 
    event.preventDefault(); // Prevent default form submission

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const userData = {
        name: name,
        email: email,
        password: password
    };

    registerUser(userData);
});


async function registerUser(userData) {
    try {
        const response = await fetch("http://localhost:8080/users/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
        
        if (response.ok) {
            alert("Registration successful! You can now log in.");
        } else {
            alert("Registration failed. Please try again.");
        }
    } catch (error) {
        console.error("Error registering user:", error);
    }
}
    
