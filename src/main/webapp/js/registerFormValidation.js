document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form[action="UserRegistrationServlet"]');
    form.addEventListener('submit', function(event) {
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        // Name validation
        if (name.length < 4 || name.length > 50) {
            alert('Name must be between 4 and 50 characters.');
            event.preventDefault();
            return;
        }

        // Email validation
        const emailRegex = /^[A-Za-z0-9+_.-]+@(.+)$/;
        if (!emailRegex.test(email)) {
            alert('Please enter a valid email address.');
            event.preventDefault();
            return;
        }

        // Password validation
        if (password.length < 10 || password.length > 50) {
            alert('Password must be between 10 and 50 characters.');
            event.preventDefault();
            return;
        }
    });
});
