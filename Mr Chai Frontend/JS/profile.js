document.addEventListener("DOMContentLoaded", () => {

    loadProfile();

});


async function loadProfile() {

    try {

        const response = await fetch("http://localhost:8080/users/profile",
            {
                method: "GET",
                credentials: "include"
            });       

        if (!response.ok) {

            throw new Error("Failed to load profile. Status: " + response.status);

        }

        const user = await response.json();

        document.getElementById("profile-id").textContent =
            user.id;

        document.getElementById("profile-name").textContent =
            user.name;

        document.getElementById("profile-email").textContent =
            user.email;


    } catch (error) {

        console.error("Error loading profile:", error);

    }

}