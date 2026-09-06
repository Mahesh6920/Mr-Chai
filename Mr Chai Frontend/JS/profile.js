document.addEventListener("DOMContentLoaded", () => {

    console.log("PROFILE PAGE LOADED");

    loadProfile();

});


async function loadProfile() {

    console.log("loadProfile() called");

    try {

        const response = await fetch("http://localhost:8080/users/profile",{
                method: "GET",
                credentials: "include"
            });     
            
            console.log("Profile response:", response.status);

        if (!response.ok) {

            throw new Error("Failed to load profile. Status: " + response.status);

        }

        const user = await response.json();

        console.log("User data:", user);

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