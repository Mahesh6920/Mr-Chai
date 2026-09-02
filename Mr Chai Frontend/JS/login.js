const loginForm = document.getElementById('loginForm');
const loginMessage = document.getElementById('login-message');

loginForm.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent default form submission

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = {
        "email": email,
        "password": password
    }

    loginUser(loginData);
});

async function loginUser(loginData) {
    try {
        const response = await fetch("http://localhost:8080/users/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            credentials: "include",
            body: JSON.stringify(loginData)
        });
 
        if (response.ok) {
            loginMessage.innerHTML = "<br> <p style='color: green;'>Login successful! Redirecting...</p>";
            // Redirect to the dashboard or another page after successful login
            setTimeout(() => {
                window.location.href = "../index.html"; // Change this to your desired page
            }, 15000); // Redirect after 2 seconds
            
        } else {
            loginMessage.innerHTML = "<br> <p style='color: red;'>Login failed. Please check your credentials and try again.</p>";
        }

    } catch (error) {
        loginMessage.innerHTML = "<br> <p style='color: red;'>An error occurred during login. Please try again later.</p>";
        // console.error("Error logging in:", error);
    }
}