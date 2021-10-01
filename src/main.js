// All in one file since we're not using localstorage ?
// Password will be saved globally in variable.

// k, v = username, password
var credentials = {}


function signUp() {
    pwdSuccess = validatePassword();
    phoneSuccess = validatePhone();
    //success = false
    
    if (pwdSuccess && phoneSuccess) {
        alert("Success: You are now registered!")
        let email = document.getElementById("userEmail").value
        let pwd = document.getElementById("userPassword").value
        credentials[email] = pwd
        document.getElementById("regform").reset();
        //redirect to login page
    }

    return false
}

function validatePassword() {
    console.log("Validating pwd")
    //Password 8 char and 1 special
    let pwd = document.getElementById("userPass").value
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
    if (pwd.length < 8 || format.test(pwd) == false) {
        alert("Please make sure you password is atleast 8 characters long and contains one special character")
        return false
    }
    return true
}

function validatePhone() {
    console.log("Validating phone")
    // Approve + - and numbers
    let phone = document.getElementById("userContactNum").value
    let format = /^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g
    if (format.test(phone)) {
        return true
    }else {
        alert("Please format your phone number correctly")
        return false
    }




}

function lockOut() {
    // Check if same userId has been attempted x amount of times login
    x = 3
}