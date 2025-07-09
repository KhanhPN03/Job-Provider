var username = document.querySelector('#username')
var password = document.querySelector('#password')
var form = document.querySelector('form')

function showError(input, message){
    let parent = input.parentElement;
    let small = parent.querySelector('small')
    parent.classList.add('error')
    small.innerText = message
}

function showSuccess(input){
    let parent = input.parentElement;
    let small = parent.querySelector('small')
    parent.classList.remove('error')
    small.innerText = ''
}

function checkEmptyError(listInput){
    listInput.forEach(input => {
        input.value = input.value.trim()
        let isEmptyError = false;
        if(!input.value) {
            isEmptyError = true;
            showError(input, 'Cannot be left blank')
        } else {
            showSuccess(input)
        }
    });
    return isEmptyError
}



form.addEventListener('submit', function(e){
    e.preventDefault()
    let isEmptyError = checkEmptyError([username, password])
})
