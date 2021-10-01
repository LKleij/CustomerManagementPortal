// All in one file since we're not using localstorage ?
// Password will be saved globally in variable.

// k, v = username, password
var credentials = {}


function signUp() {
    validatePassword();
    validatePhone();
    
    alert("Success: You are now registered!")
    alert("Failed: Please enter an email with!")

    //On success
    document.getElementById("regform").reset();

    return false
}

function validatePassword() {
    //Password 8 char and 1 special
}

function validatePhone() {
    // Approve + - and numbers
}

function lockOut() {
    // Check if same userId has been attempted x amount of times login
    x = 3
}