let user = document.querySelector('#username');
let pass = document.querySelector('#password');
let email = document.querySelector('#email');
let fullname = document.querySelector('#fullname');
//let dob = document.querySelector('#dob');
let phone = document.querySelector('#phone');
let address = document.querySelector('#address');
let tax = document.querySelector('#tax');
let q1 = document.querySelector('#Q1');
let as1 = document.querySelector('#ansQ1');
let q2 = document.querySelector('#Q2');
let as2 = document.querySelector('#ansQ2');
let img = document.querySelector('#img');

// Select all elements with id "username"
let formActions = document.querySelector('.form-action');
let newform = document.querySelector('form');
let submit = document.querySelector('.btn-submit');

// Loop through each element and add the event listener

formActions.addEventListener("submit", (e) => {
    e.preventDefault();
    console.log('submit');
    let arrInput = [user, email, pass, fullname, phone, address, q1, as1, q2, as2, tax];
    if (arrInput) {
        if (
                !isInValidLength(user, 8, 32) &&
                !isInValidLength(fullname, 6, 50) &&
                isCharacter(fullname) &&
                isValidNumberPhone(phone) &&
                !isEmailError(email) 
               
                )
        {
            window.location.replace(`/projob/RegisterComController?username=${user.value}
&password=${pass.value}&email=${email.value}&name=${fullname.value}&phone=${phone.value}&address=${address.value}
&Q1=${q1.value}&Q2=${q2.value}&ansQ1=${as1.value}&ansQ2=${as2.value}&tax=${tax.value}&img=${img.value}`)
        }
    }
}
);



function isYearValid(input) {
    let currentYear = getCurrentYear()
    let year = getYear(input.value);
    if (year > 1900 && year < (currentYear - 14)) {
        isSuccess(input);
        return true;
    } else {
        showError(input, 'Date of birth is not valid, make sure that your age is greater than 15 years old!');
        return false;
    }

}
function getYear(value) {
    return value.substring(0, 4);
}
function getCurrentYear() {
    const currentDate = new Date();
    return currentDate.getFullYear();
}
function isValidNumberPhone(input) {
    const phoneNumberRegex = /^0\d{9}$/;
    if (phoneNumberRegex.test(input.value)) {
        isSuccess(input);
        return true;
    } else {
        showError(input, 'It must be number and include fisrt number 0 and 10 digits');
        return false;
    }
}

function  isCharacter(input) {
    const pattern = /^[a-zA-Z\s]+$/;
    if (pattern.test(input.value)) {
        isSuccess(input);
        return true;
    } else {
        showError(input, 'It must be characters');
        return false;
    }
}
function showError(input, message) {
    let parent = input.parentElement;
    let errorInput = parent.lastElementChild
    errorInput.style.display = 'block';
    errorInput.textContent = message;
}
function isSuccess(input) {
    let parent = input.parentElement;
    let errorInput = parent.lastElementChild
    errorInput.style.display = 'none';
}
function isEmptyInput(arrInput) {
    let check = false;

    arrInput.forEach((input) => {
        let trimmedValue = input.value.trim();
        if (trimmedValue === '') {
            showError(input, 'It is not empty!');
            check = true;
        } else {
            isSuccess(input);
        }
    });
    return check;
}


function isInValidLength(input, min, max) {
    let check = false;
    let len = input.value.length;
    if (len > max || len < min) {
        showError(input, `It must be from ${min} to ${max} characters`)
        check = true;
    } else {
        isSuccess(input)
    }
    return check;
}
function isEmailError(input) {
    let regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regex.test(input.value.trim())) {
        showError(input, "It is invalid email")
        return true;
    } else {
        isSuccess(input)
    }
    return false;
}


