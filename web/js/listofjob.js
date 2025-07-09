// category list
const listCategory = document.querySelectorAll('.category li')
const filterCategory = document.querySelector('.filter-category-wrapper')
const ul = document.querySelector('.filter-category')


let itemBlog = [];
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
})
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

console.log(comBlog)

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

function innitListCategoryRight() {
    itemBlog.map(item => {
        ul.innerHTML += `<li class="filter-category_item">
    <a style="text-decoration: none;" href="viewpostcontroller?key=${item.sectors}&a_id=${accountBlog[0].account_id}">${item.sectors}</a>
</li>`
    })

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

// pagination
const pagiControl = document.querySelectorAll('.pagi-control button')
const postList = document.querySelector('.listOfJobLeftPost')
const btnLeftPagination = document.querySelector('#btnLeftPagination')
const btnRightPagination = document.querySelector('#btnRightPagination')
const currentPageTag = document.querySelector('#currentPageTag')
const totalPageTag = document.querySelector('#totalPage')


let start = 0;
let end = 0;

let curentPage = 1;
let itemPerPage = 6;
let totalPage = parseInt(itemBlog.length / itemPerPage);
if ((itemBlog.length % itemPerPage) > 0) {
    totalPage++;
}

pagination(0, 6)
totalPageTag.innerText = totalPage

if (curentPage == 1) {
    btnLeftPagination.classList.add('disabled');
}

pagiControl.forEach((btn) => {
    const btnPagination = btn.addEventListener('click', () => {
        switch (btn.id) {
            case 'btnLeftPagination':
                if (curentPage <= totalPage && curentPage > 1) {
                    curentPage--
                    start = (curentPage - 1) * itemPerPage;
                    end = curentPage * itemPerPage;
                    pagination(start, end)
                    btnRightPagination.classList.remove('disabled');
                }
                break;
            case 'btnRightPagination':
                if (curentPage > 0 && curentPage < totalPage) {
                    btnLeftPagination.classList.remove('disabled');
                    curentPage++
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
        currentPageTag.innerHTML = curentPage
    }
}