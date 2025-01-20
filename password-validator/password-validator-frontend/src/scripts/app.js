// This file contains the JavaScript code for the password validator frontend application.
document.getElementById('validateBtn').addEventListener('click', function() {
    const password = document.getElementById('password-input').value;

    fetch('http://localhost:8080/api/validate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(password) // Send the password as a plain string
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById('result').innerText = data;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("password-form");
    const passwordInput = document.getElementById("password-input");
    const resultDisplay = document.getElementById("result");

    form.addEventListener("submit", function(event) {
        event.preventDefault();
        const password = passwordInput.value;
        const strengthMessage = evaluatePasswordStrength(password);
        resultDisplay.textContent = strengthMessage;
    });

    function evaluatePasswordStrength(password) {
        if (password.length < 8) {
            return "Weak: Password is too short. It should be at least 8 characters long.";
        }
        if (!/\d/.test(password)) {
            return "Weak: Password should contain at least one digit.";
        }
        if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
            return "Weak: Password should contain at least one special character.";
        }
        return "Strong: Password meets the requirements.";
    }
});