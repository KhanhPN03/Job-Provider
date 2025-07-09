const listIcon = document.querySelectorAll('.menu li');

listIcon.forEach(icon => {
    icon.addEventListener('click',() => {
        document.querySelector('.menu .active').classList.remove('active');
        icon.classList.add('active');
    })
})

//_______change color input
const inputTag = document.querySelector('.contentRightInput input')
const wrapperInput = document.querySelector('.contentRightInput')

inputTag.addEventListener('mousemove',() => {
    wrapperInput.classList.remove('wrapperInputColor')
});
inputTag.addEventListener('click',() => {
    wrapperInput.classList.toggle('wrapperInputColor')
});

