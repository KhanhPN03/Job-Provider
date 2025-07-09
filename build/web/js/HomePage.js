// category list
const listCategory = document.querySelector('#category')
const filterCategory = document.querySelector('.filter-category-wrapper')
const ul = document.querySelector('.filter-category')


const sectorList = document.querySelectorAll('.sector');
let sectorArr = [];
sectorList.forEach(sector => {
    let OjbAdd = {};
    let childE = sector.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    sectorArr.push(OjbAdd);
})


const cityList = document.querySelectorAll('.cityObj');
let cityArr = [];
cityList.forEach(city => {
    let OjbAdd = {};
    let childE = city.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    cityArr.push(OjbAdd);
})


const timeList = document.querySelectorAll('.workingHours');
let timeArr = [];
timeList.forEach(time => {
    let OjbAdd = {};
    let childE = time.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    timeArr.push(OjbAdd);
})

let salaryArr = ["Ít hơn 5tr", "5tr-10tr", "10tr-20tr", "20tr-30tr", "Lớn hơn 30tr"];

let accountBlog = [];
const account = document.querySelectorAll('.account');
account.forEach(account => {
    let ObjAdd = {}
    let childE = account.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    accountBlog.push(ObjAdd);
}
)

function innitListCategoryRight() {
//    cityArr.map(city => {
//        ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${city.cityObj_name}&a_id=${accountBlog[0].account_id}&code=city">${city.cityObj_name}</a></li>`
//    })

    /***************************************************************************/
    const tabBox = document.querySelector('.filter-category')
    const allTabs = document.querySelectorAll('.filter-category_item')
    const arrowIcon = document.querySelectorAll('.filter-category-wrapper button')
    const idBtn = 'leftBtnFilter'
    const activeClass = '.filter-category_item.active'
    // handle scroll x
    scrollX(arrowIcon, tabBox, idBtn)
    // handle choose item
    activeElement(allTabs, activeClass)
}

innitListCategoryRight()

listCategory.addEventListener('change', () => {
    ul.innerHTML = ""
    switch (listCategory.value) {
        case "sector":
            sectorArr.map(sector => {
ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${sector.sector_name}&a_id=${accountBlog[0].account_id}&code=sector">${sector.sector_name}</a></li>`
            })
            break;
        case "area":
            cityArr.map(city => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${city.cityObj_name}&a_id=${accountBlog[0].account_id}&code=city">${city.cityObj_name}</a></li>`
            })
            break;
        case "time":
            timeArr.map(time => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${time.workingHours_name}&a_id=${accountBlog[0].account_id}&code=wh">${time.workingHours_name}</a></li>`
            })
            break;
        case "salary":
            salaryArr.map(salary => {
                ul.innerHTML += `<li class="filter-category_item"><a style="text-decoration: none;" href="viewpostcontroller?key=${salary}&a_id=${accountBlog[0].account_id}&code=salary">${salary}</a></li>`
            })
            break;
    }

    /***************************************************************************/
    const tabBox = document.querySelector('.filter-category')
    const allTabs = document.querySelectorAll('.filter-category_item')
    const arrowIcon = document.querySelectorAll('.filter-category-wrapper button')
    const idBtn = 'leftBtnFilter'
    const activeClass = '.filter-category_item.active'
    // handle scroll x
    scrollX(arrowIcon, tabBox, idBtn)
    // handle choose item
    activeElement(allTabs, activeClass)
})


// top of the company scroll
const blog_list = document.querySelector('.comp-list_card')
const BtnComp = document.querySelectorAll('.comp-btn button')
const idBtn = 'leftBtnComp'

scrollX(BtnComp, blog_list, idBtn)

//const itemBlog = [];

export var itemBlog = [];
const data = document.querySelectorAll('.data');
data.forEach(dataE => {
    let OjbAdd = {};
    let childE = dataE.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    itemBlog.push(OjbAdd);
})
//console.log(itemBlog)

let empBlog = [];
const empDatas = document.querySelectorAll('.emp');
empDatas.forEach(empData => {
    let ObjAdd = {}
    let childE = empData.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    empBlog.push(ObjAdd);
}
)



let comBlog = [];
const comDatas = document.querySelectorAll('.com');
comDatas.forEach(comData => {
    let ObjAdd = {}
    let childE = comData.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
let content = childE[i].textContent;
        ObjAdd[className] = content;
    }
    comBlog.push(ObjAdd);
}
)

console.log(comBlog);

//console.log(comBlog[0].com_img)

for (let i = 0; i < itemBlog.length; i++) {
    for (let j = 0; j < empBlog.length; j++) {
        if (empBlog[j].emp_id === itemBlog[i].emp_id) {
            itemBlog[i].emp_id = empBlog[j].emp_name;
            itemBlog[i].emp_img = empBlog[j].emp_img;
        }
    }
}

for (let i = 0; i < itemBlog.length; i++) {
    for (let j = 0; j < comBlog.length; j++) {
        if (comBlog[j].com_id === itemBlog[i].emp_id) {
            itemBlog[i].emp_id = comBlog[j].com_name;
            itemBlog[i].emp_img = comBlog[j].com_img;
        }
    }
}

const pagiControl = document.querySelectorAll('.pagi-control button')
const postList = document.querySelector('.post_list')
const btnLeftPagination = document.querySelector('#btnLeftPagination')
const btnRightPagination = document.querySelector('#btnRightPagination')
const currentPageTag = document.querySelector('#currentPageTag')
const totalPageTag = document.querySelector('#totalPage')

let curentPage = 1;
let itemPerPage = 6;
let totalPage = parseInt(itemBlog.length / itemPerPage);
if ((itemBlog.length % itemPerPage) > 0) {
    totalPage++;
}
let start = 0;
let end = 0;

currentPageTag.innerText = curentPage

pagination(0, 6)
totalPageTag.innerText = totalPage

//console.log(totalPage)

if (curentPage == 1) {
    btnLeftPagination.classList.add('disabled');
}

pagiControl.forEach((btn) => {
    const btnPagination = btn.addEventListener('click', () => {
        switch (btn.id) {
            case 'btnLeftPagination':
                if (curentPage <= totalPage && curentPage > 1) {
                    curentPage--
                    console.log(curentPage)
                    start = (curentPage - 1) * itemPerPage;
                    end = curentPage * itemPerPage;
                    pagination(start, end)
                    btnRightPagination.classList.remove('disabled');
                }
                currentPageTag.innerText = curentPage
                break;
            case 'btnRightPagination':
                if (curentPage > 0 && curentPage < totalPage) {
                    btnLeftPagination.classList.remove('disabled');
                    currentPageTag.innerText = ++curentPage
                    start = (curentPage - 1) * itemPerPage;
                    end = curentPage * itemPerPage;
                    pagination(start, end)
                }
                break;
        }
        if (curentPage == 1) {
            btnLeftPagination.classList.add('disabled');
        }
        if (curentPage == totalPage) {
            btnRightPagination.classList.add('disabled');
        }
        currentPageTag.innerText = curentPage
    })




})

function pagination(start, end) {
    postList.innerHTML = ""
    for (let index = start; index < end; index++) {
        let arr1 = itemBlog[index];
postList.innerHTML += `                                
                                <div class="col-12 col-sm-6 mb-3 col-md-4 blog-wrap_item blog-wrap_item-hover">
                                    <div class="blog_item card">
                                        <a style="text-decoration: none;" 
                                            href="ViewPostDetailController?postD_id=${itemBlog[index].postD_id}&post_id=${itemBlog[index].post_id}&a_id=${accountBlog[0].account_id}">
                                            <div class="card-body d-flex">
                                                <div class="imageWrapper">
                                                    <img style="width: 100%; height: 100%; object-fit: contain; object-position: center;" class="rounded-circle me-2" src="${itemBlog[index].emp_img}" alt="">
                                                </div>
                                                <div class="bog_item-content">
                                                    <p style="color: black;" class="card-title">${itemBlog[index].job_name}</p>
                                                    <p style="color: black;" class="card-text">${itemBlog[index].emp_id}</p>          
                                                </div>
                                            </div>        
                                            <div class="cardFooter">
                                                <span class="cardCity">${itemBlog[index].city}</span>
                                                <span class="cardSalary">${itemBlog[index].salary}</span>
                                            </div>
                                        </a>                                                                                                          
                                </div>
                                `
    }
}

/** search filter____________________________________________________________________________________________________________________________ */
/**form input 1*/
const formFilterInputRight1 = document.querySelector('.formFilterInputRight1')
const formFilterInputList1 = document.querySelector('.formFilterInputList1')
const formFilterInputIcon1 = document.querySelector('.formFilterInput1 i:last-child')
const formFilterContent1 = document.querySelector('.formFilterInput1 p')
const formFilterInputItem1 = document.querySelectorAll('.formFilterInputItem1')
/**form input 2*/
const formFilterInputRight2 = document.querySelector('.formFilterInputRight2')
const formFilterInputList2 = document.querySelector('.formFilterInputList2')
const formFilterInputIcon2 = document.querySelector('.formFilterInput2 i:last-child')
const formFilterContent2 = document.querySelector('.formFilterInput2 p')
const formFilterInputItem2 = document.querySelectorAll('.formFilterInputItem2')
/**form input 3*/
const formFilterInputRight3 = document.querySelector('.formFilterInputRight3')
const formFilterInputList3 = document.querySelector('.formFilterInputList3')
const formFilterInputIcon3 = document.querySelector('.formFilterInput3 i:last-child')
const formFilterContent3 = document.querySelector('.formFilterInput3 p')
const formFilterInputItem3 = document.querySelectorAll('.formFilterInputItem3')

const overlay = document.querySelector('.overlay')
let beforeId = 0

formFilterInputRight1.addEventListener('click', () => {
    formFilterInputList1.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon2)
    addDownIcon(formFilterInputIcon3)
    // id trc do??
    switch (beforeId) {
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
    // comment
    // overlay beforeid == currentid
    beforeId === 1 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 1
})
formFilterInputRight2.addEventListener('click', () => {
    formFilterInputList2.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon2)
    addDownIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon3)
    // id trc do??
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
    // overlay beforeid == currentid
    beforeId === 2 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 2
})
formFilterInputRight3.addEventListener('click', () => {
    formFilterInputList3.classList.toggle('hide')
    toggleDownUpIcon(formFilterInputIcon3)
    addDownIcon(formFilterInputIcon1)
    addDownIcon(formFilterInputIcon2)
    // id trc do??
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
    }
    // overlay beforeid == currentid
    beforeId === 3 ? overlay.classList.toggle('hide') : overlay.classList.remove('hide');
    beforeId = 3
})

// Overlay ..............
overlay.addEventListener('click', () => {
    switch (beforeId) {
        case 1:
            formFilterInputList1.classList.add('hide')
            addDownIcon(formFilterInputIcon1)
            break;
        case 2:
            formFilterInputList2.classList.add('hide')
            addDownIcon(formFilterInputIcon2)
            break;
        case 3:
            formFilterInputList3.classList.add('hide')
            addDownIcon(formFilterInputIcon3)
            break;
    }
overlay.classList.add('hide')
})

// Overlay end ..........

formFilterInputItem1.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent1.innerHTML = item.innerHTML
    })
})
formFilterInputItem2.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent2.innerHTML = item.innerHTML
    })
})
formFilterInputItem3.forEach(item => {
    item.addEventListener('click', () => {
        formFilterContent3.innerHTML = item.innerHTML
    })
})


function addDownIcon(formFilterInputIcon) {
    formFilterInputIcon.classList.forEach(item => {
        if (item === 'bx-chevron-up') {
            formFilterInputIcon.classList.remove('bx-chevron-up')
            formFilterInputIcon.classList.add('bx-chevron-down')
        }
    })
}
function toggleDownUpIcon(formFilterInputIcon) {
    formFilterInputIcon.classList.forEach(item => {
        if (item === 'bx-chevron-down') {
            formFilterInputIcon.classList.remove('bx-chevron-down')
            formFilterInputIcon.classList.add('bx-chevron-up')
        } else if (item === 'bx-chevron-up') {
            formFilterInputIcon.classList.remove('bx-chevron-up')
            formFilterInputIcon.classList.add('bx-chevron-down')
        }
    })
}

//the common function
function scrollX(arrowIcon, tabBox, idBtn) {
    arrowIcon.forEach(btnIcon => {
        btnIcon.addEventListener('click', () => {
            tabBox.scrollLeft += btnIcon.id === idBtn ?
                    -232.8 : 232.8;
        })
    })
}

function activeElement(allTabs, activeClass) {
    allTabs.forEach(item => {
        item.addEventListener('click', (e) => {
            let itemActive = document.querySelector(activeClass)
            itemActive !== null ? itemActive.classList.remove('active') :
                    itemActive
            e.target.classList.add('active')
        });
    })
}