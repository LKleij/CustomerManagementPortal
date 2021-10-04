// All in one file since we're not using localstorage ?
// Password will be saved globally in variable.

// k, v = username, password
var credentials = {}


function signUp() {
    /*
        Allows the user to sign up after performing validation on the fields.
        On success: Email and password is stored in localstorage.
    */
    pwdSuccess = validatePassword();
    phoneSuccess = validatePhone();
    pwdMatchSuccess = validateConfirmPassword();
    emailMatchSuccess = validateConfirmEmail();

    // Check if email is already registered in localstorage
    var email = document.getElementById("userEmail").value
    if (localStorage.getItem(email) != undefined) {
        alert("Mail is already registered!")
        return false
    }
    
    if (pwdSuccess && phoneSuccess && pwdMatchSuccess && emailMatchSuccess) {
        alert("Success: You are now registered!")
        let pwd = document.getElementById("userPass").value
        localStorage.setItem(email, pwd)
        document.getElementById("myForm").reset()
    }

    return false
}

function validatePassword() { 
    //Password validation: 8 char and 1 special
    let pwd = document.getElementById("userPass").value
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    if (pwd.length < 8 || format.test(pwd) == false) {
        alert("Please make sure you password is atleast 8 characters long and contains one special character")
        return false
    }
    return true
}

function validateConfirmPassword() {
    //Check if password matches
    if (document.getElementById("userPass").value != document.getElementById("userPassConfirm").value) {
        alert("Passwords not matching")
        return false
    }
    return true
}

function validateConfirmEmail() {
    //Check if email matches
    if (document.getElementById("userEmail").value != document.getElementById("userEmailConfirm").value) {
        alert("Emails not matching")
        return false
    }
    return true
}

function validatePhone() {
    // Validate PhoneNumber: '+' '-' and numbers are allowed
    let phone = document.getElementById("userContactNum").value
    let format = /^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g
    if (format.test(phone)) {
        return true
    }else {
        alert("Please format your phone number correctly")
        return false
    }
}

function lockOut(email) {
    // Check if same userId has been attempted login 3 times
    var n = localStorage.getItem(email+"lockout")
    if (n == undefined) n = 0 // Default value
    localStorage.setItem(email+"lockout", parseInt(n) + 1)
    if (parseInt(n) + 1 == 3) {
        alert("Account now locked :(")
        return true
    }
    return false
}

function logIn() {
    // Check if login details are stored in localstorage and not lockedout.
    let userEmail = document.getElementById("userEmail").value
    let loginDetails = localStorage.getItem(userEmail);
    let pwd = document.getElementById("userPass").value
    if (parseInt(localStorage.getItem(userEmail+"lockout")) >= 3) alert("Account is locked.")
    else if (pwd == loginDetails) {
        alert("Wohooo you logged in!")
        document.getElementById("logInForm").reset()
        localStorage.setItem(userEmail+"lockout", 0)
    }
    else {
        alert("Email or password incorrect")
        lockOut(userEmail)
    }
    return false
}

function retrievePassword() {
    alert(localStorage.getItem(document.getElementById("userEmail").value))
    return false
}