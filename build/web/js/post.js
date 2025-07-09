

const contactBtn = document.querySelector('.contact');


function handleScroll() {
    // console.log(window.scrollY);
    if (window.scrollY>400) {
        contactBtn.classList.add('contact_unmove');
        console.log(window.scrollY);
    } else if (window.scrollY<400) {
        contactBtn.classList.remove('contact_unmove');
        console.log(window.scrollY);
    }
};

window.addEventListener('scroll', handleScroll);


const apply = document.querySelector('.job_apply-icon');

// const applyIcon = document.querySelector('.job_apply-icon i')

const applyIcon = document.querySelector('.apply');

const checkIcon = document.querySelector('.check');

//apply.addEventListener('click', (e) => {
//    console.log(e.target);
//    applyIcon.classList.add('hide');
//    checkIcon.classList.remove('hide');
//});