


const data = document.querySelectorAll('.data');
let listAcc = [];
data.forEach(d => {
    let OjbAdd = {};
    let childE = d.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    listAcc.push(OjbAdd);
})



let array = []
let array_length = 0;
let table_size = 8;
let start_index = 1;
let end_index = 0;
let max_index = 0;
let current_index = 1;
let sortCol = 'rank';
let ascOrder = true;


function preloadCal() {
    array = listAcc;
    array_length = array.length;
    max_index = parseInt(array_length / table_size);
    if ((array_length % table_size) > 0) {
        max_index++;
    }
}
function filterTable() {

    let tab_filter_text = $('#tab_filter_text').val();
    if (tab_filter_text != '') {
        let temp_arr = rankList.filter(function (ojb) {
            return ojb.id.toString().includes(tab_filter_text)
                || ojb.name.toUpperCase().includes(tab_filter_text.toUpperCase())
                || ojb.jobName.toString().includes(tab_filter_text)
                || ojb.jobDesc.toString().includes(tab_filter_text)
                ;
        });
        array = temp_arr;
    } else {
        array = listAcc;
    }
}
function displayIndexBtn() {
    preloadCal();
    // filterTable();
    $('.index_btn button').remove();
    $('.index_btn').append('<button onclick="prev();">Previous</button>')
    for (let i = 1; i <= max_index; i++) {
        $('.index_btn').append('<button onclick="indexPagina(' + i + ');" index=' + i + '>' + i + '</button>')
    }
    $('.index_btn').append('<button onclick="next();">Next</button>')
    highlightIndexBtn();
}
function highlightIndexBtn() {
    start_index = ((current_index - 1) * table_size) + 1;
    end_index = (start_index + table_size) - 1;
    if (end_index > array_length) {
        end_index = array_length;
    }
    $('.pagina span').text('Showing ' + start_index + ' to ' + end_index + ' of ' + array_length + ' entries');
    $('.index_btn button').removeClass('active');
    $('.index_btn button[index=' + current_index + ']').addClass('active');
    displayAllJob();
}
function displayAllJob() {
    $('.content div').remove();
    let tab_start = start_index - 1;
    let tab_end = end_index;
    for (let i = tab_start; i < tab_end; i++) {
        let job = array[i]

        let newJob = `<div class="content__body__post flex-row">
            <div class="col-4 col-md-4">
            <div class="company-name">
            <h3>${listAcc[i].acc_name}<h3>
            </div>
            </div >  
            <div class="content__body__comp  col-3 col-md-3">  
            <h5>   ${listAcc[i].tax}   </h5>  
            </div>  
             <div class="content__body__action col-4 col-md-4">  
            <div class="nav_swift">  
            <div class="edit_btn">  
            <a class="d-flex d-none d-sm-block">  
            <i class="bx bxs-edit-alt"></i> Action</a> 
            <i class="content__body__action_m d-sm-block d-lg-none bx bx-menu"></i>  
            </div>  
            <div class="subnav hide f-right">  
            <div class="item ">  
             <ul class="action-item d-sm-block d-lg-flex ">  
            <li>  
            <a><i class="bx bxs-edit-alt"></i>Approve</a>  
            </li>  
             <li>  
             <a><i class="bx bxs-edit-alt"></i>Deny/a>  
             </li>  
            <li>  
             <a href="ViewPostDetailController?postD_id=${listAcc[i].postD_id}&post_id=${listAcc[i].post_id}"><i class="bx bxs-book-open"></i>replace jsp code here to view detail</a>  
             </li>  
             </ul>  
            </div>  
            </div>  
             </div>  
            </div>  
            </div>`
            ;
        $('.content').append(newJob);

    }
}
function next() {
    if (current_index < max_index) {
        current_index++;
        highlightIndexBtn();
    }
}
function prev() {
    if (current_index > 1) {
        current_index--;
        highlightIndexBtn();
    }
}
function indexPagina(index) {
    current_index = parseInt(index);
    highlightIndexBtn();
}
$('#table_size').change(function () {
    table_size = parseInt($(this).val());
    current_index = 1;
    start_index = 1;
    displayIndexButtons();
})
$('#tab_filter_btn').click(function () {
    current_index = 1;
    start_index = 1;
    displayIndexButtons();
})
function filterTable() {
    let tab_filter_text = $('#tab_filter_text').val();

    if (tab_filter_text != '') {
        let temp_arr = rankList.filter(function (ojb) {
            return ojb.rank.toString().includes(tab_filter_text)
                || ojb.name.toUpperCase().includes(tab_filter_text.toUpperCase())
                || ojb.year.toString().includes(tab_filter_text)
                || ojb.marks.toString().includes(tab_filter_text)
                || ojb.percen.toString().includes(tab_filter_text)
                ;

        });
        array = temp_arr;
    } else {

        array = rankList;
    }
}

displayIndexBtn()

//adding hover and mouseout event

const editBtn = $('.edit_btn');
const subNav = $('.subnav');


let canLeave = false

$('.edit_btn').click(function () {
    this.classList.toggle('hide');
    this.nextElementSibling.classList.toggle('hide');
}
);
$('.subnav').mouseleave(function () {
    this.classList.toggle('hide')
    this.previousElementSibling.classList.toggle('hide')
})
