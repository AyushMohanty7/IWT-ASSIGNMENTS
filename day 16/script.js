document.getElementById('regForm').addEventListener('submit', function(e) {
    e.preventDefault(); 

    const errorDiv = document.getElementById('error-msg');
    
  
    const name = document.getElementById('name').value.trim();
    const gender = document.querySelector('input[name="gender"]:checked');
    const mobile = document.getElementById('mobile').value.trim();
    const address = document.getElementById('address').value.trim();
    const country = document.getElementById('country').value;
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();

    if (!name || !gender || !mobile || !address || !country || !email || !password) {
        showError("All fields are mandatory.");
        return;
    }

    const mobileRegex = /^[0-9]{10}$/;
    if (!mobileRegex.test(mobile)) {
        showError("Mobile must be a valid 10-digit number.");
        return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        showError("Invalid email format.");
        return;
    }

    if (password.length < 6 || password.length > 15) {
        showError("Password must be 6 to 15 characters.");
        return;
    }

    errorDiv.style.display = "none";
    alert("Form submitted successfully!");
    this.reset();
});

function showError(msg) {
    const errorDiv = document.getElementById('error-msg');
    errorDiv.innerText = msg;
    errorDiv.style.display = "block";
}
