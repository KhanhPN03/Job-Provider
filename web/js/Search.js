/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const inputTag = document.querySelector('.form-control');
const ulTag = document.querySelector('.listSearch')

const formInputWrapper = document.querySelector('.formInputWrapper');
const formTag = document.querySelector('.navbar-form');
const body = document.querySelector('body');

let valueInput = ""
body.addEventListener('click', (e) => {
    console.log(e.target);
    if(e.target != inputTag && e.target != formInputWrapper){
        ulTag.classList.add('hide');
        console.log('not target');
    } else if(e.target == inputTag){
        ulTag.classList.remove('hide');
        console.log('target');

    }
})

//const listJobData = document.querySelectorAll('.data p:first-child');

const listJobList = document.querySelectorAll('.data');
let listJobData = [];
listJobList.forEach(data => {
    let OjbAdd = {};
    let childE = data.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    listJobData.push(OjbAdd);
})

//listJobData.forEach(job => {
//    listJob.push(job.job_name)   
//})
// inputTag.addEventListener('click', () =>{
//     ulTag.classList.toggle('hide')
// })
inputTag.addEventListener('input', (e) => {  
    valueInput = e.target.value; 
    display(e.target.value)
})
// formInputWrapper.addEventListener('mouseleave', () => {
//     ulTag.classList.add('hide')
// })
render()
function render() {
    listJobData.map( job => {
        ulTag.innerHTML += `<li><a href="ViewPostDetailController?postD_id=${job.postD_id}&post_id=${job.post_id}">${job.job_name}</a></li>`
    })
}
function display(value) {
    let arrTemp = []
    listJobData.map( job => {
        if(job.job_name.toUpperCase().includes(value.toUpperCase())){
            arrTemp.push(job)
        }
    })
    if(arrTemp.length == 0){
        ulTag.innerHTML = `<li><a href="">Not Found Data</a></li>`
    } else {
        renderTemp(arrTemp)
    } 
}

function renderTemp(list) {
    ulTag.innerHTML = ""
    list.map( job => {
        ulTag.innerHTML += `<li><a href="ViewPostDetailController?postD_id=${job.postD_id}&post_id=${job.post_id}">${job.job_name}</a></li>`
    })
}
formTag.addEventListener('submit', () => {
    window.location = "search?inputValue="+valueInput;
})