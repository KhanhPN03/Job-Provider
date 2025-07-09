let user = document.querySelector('#username');
let pass = document.querySelector('#password');
let email = document.querySelector('#email');
let fullname = document.querySelector('#fullname');
let dob = document.querySelector('#dob');
let phone = document.querySelector('#phone');
let address = document.querySelector('#address');
let q1 = document.querySelector('#q1');
let as1 = document.querySelector('#as1');
let q2 = document.querySelector('#q2');
let as2 = document.querySelector('#as2');

let formAction = document.querySelector('#username');

formAction.addEventListener('submit', (e) => {
    e.preventDefault();       
    console.log('submit');      
    let arrInput = [user, email, pass, fullname, dob, phone, address, q1, as1, q2, as2]    
    if(!isEmptyInput(arrInput)){               
        if(!isInValidLength(user, 8, 32)  && !isInValidLength(fullname, 6, 50) && isChareter(fullname)
            &&  isValidNumberPhone(phone) &&  !isEmailError(email) && isYearValid(dob)   
        ){
            console.log('ngon');
        }                        
    }
});

function isYearValid(input) {
    let currentYear = getCurrentYear()
    let year = getYear(input.value);
    if(year > 1900 && year < (currentYear - 14)) {
        isSuccess(input)
    } else {
        showError(input, 'Date of birth is not valid, make sure that your age is greater than 15 years old!')
    }
}
function getYear(value) {
    return value.substring(0,4);
}
function getCurrentYear() {
    const currentDate = new Date();
    return currentDate.getFullYear();
  }
function isValidNumberPhone(input) {  
    const phoneNumberRegex = /^0\d{9}$/;
    if(phoneNumberRegex.test(input.value)){
        isSuccess(input);
        return true;
    } else {
        showError(input, 'It must be number and include fisrt number 0 and 10 digits');
        return false;
    }
}

function isChareter(input) {
    const pattern = /^[a-zA-Z\s]+$/;
    if(pattern.test(input.value)){
        isSuccess(input);
        return true;
    } else {
        showError(input, 'It must be chareters');
        return false;
    }
}
function showError(input, message){
    let parent = input.parentElement;
    let errorInput = parent.lastElementChild
    errorInput.style.display = 'block';
    errorInput.textContent = message;
}
function isSuccess(input){
    let parent = input.parentElement;
    let errorInput = parent.lastElementChild      
    errorInput.style.display = 'none';
}
function isEmptyInput(arrInput){ 
    let check = false;  
     arrInput.forEach((e) => {
        e.value = e.value.trim();
        if(e.value === '') {
            showError(e, 'It is not empty!')
            check = true;
        } else {
            isSuccess(e)
        }
     });
     return check;
}

function isInValidLength(input,min, max){
    let check = false;
    let len = input.value.length;
    if(len > max || len < min){
        showError(input, `It must be from ${min} to ${max} characters`)
        check = true;
    } else {
        isSuccess(input)
    }
    return check;
}
function isEmailError(input) {
    let regex =  /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!regex.test(input.value.trim())){
        showError(input, "It is invalid email")
        return true;
    } else {
        isSuccess(input)
    }
    return false;
}


