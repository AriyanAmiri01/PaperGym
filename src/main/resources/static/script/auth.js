

// Login stuffs
const loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    console.log("hello");
    const username = document.getElementById("login-username").value;
    const password = document.getElementById("login-password").value;

    const response = await fetch("/api/auth/login", {
        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    const result = await response.text();

    console.log(result);
});



// Register stuffs
const registerForm = document.getElementById("register-form");

registerForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const username = document.getElementById("register-username").value;
    const password = document.getElementById("register-password").value;

    const response = await fetch("/api/auth/register", {
        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    const result = await response.text();

    console.log(result);
});