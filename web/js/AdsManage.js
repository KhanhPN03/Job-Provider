

const data = document.querySelectorAll('.data');
let listJob = [];
data.forEach(d => {
    let OjbAdd = {};
    let childE = d.children;
    for (let i = 0; i < childE.length; i++) {
        let className = childE[i].getAttribute('class');
        let content = childE[i].textContent;
        OjbAdd[className] = content;
    }
    listJob.push(OjbAdd);
})

let array = []
let array_length = 0;
let table_size = 4;
let start_index = 1;
let end_index = 0;
let max_index = 0;
let current_index = 1;
let sortCol = 'rank';
let ascOrder = true;


function preloadCal() {
    array = listJob;
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
        array = listJob;
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
    // doAction();
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
            <div class="col-5 col-md-5"> 
            <img class="company-img" 
            src = "${listJob[i].adsD_link}" 
            alt = "" >
            </div >
            <div class="content__body__comp  col-3 col-md-3">
            <h5>${listJob[i].adsD_des}</h5>
            </div>
             <div class="content__body__action col-4 col-md-4">
            <div class="nav_swift">
            <div class="edit_btn">
            <a class="d-flex d-none d-sm-block">
            <i class='bx bxs-edit-alt'></i> Action</a> 
            <i class="content__body__action_m d-sm-block d-lg-none bx bx-menu"></i>
            </div>
            <div class="subnav hide f-right">
            <div class="item ">
             <ul class="action-item d-sm-block d-lg-flex ">
            <li>
            <a><i class='bx bxs-edit-alt'></i>Close Ads</a>
            </li>
             <li>
            <a><i class='bx bxs-edit-alt'></i>View Log</a>
             </li>
            <li>
            
 
 
            <a><i class='bx bxs-book-open'></i></a>
            <div class="contact" >
                <button data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
            </div>
        

            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" 
            tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div style="border: none;" class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel"></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="container modal-body p-5 pt-0">
                            <div class="row col-sm-10 w-100">
                                <div class="modal_body-content w-100">
                                    <h5>Ads description</h5>
                                    <div class="content">
                                        <p>${listJob[i].adsD_des}</p>
                                    </div>
                                </div>
                                <div class="modal_body-content w-100">
                                    <h5>Date start</h5>
                                    <div class="content">
                                        <p>${listJob[i].ads_dateStart}</p>
                                    </div>
                                </div>
                                <div class="modal_body-content w-100">
                                    <h5>Date end</h5>
                                    <div class="content">
                                        <p>${listJob[i].ads_dateEnd}</p>
                                    </div>
                                </div>
                                <div class="modal_body-content w-100">
                                    <h5>Link</h5>
                                    <div class="content">
                                        <p>${listJob[i].adsD_link}</p>
                                    </div>
                                </div>
                                <div class="modal_body-content w-100">
                                    <h5>Click statistic</h5>
                                    <div class="content">
                                        <p>${listJob[i].ads_statistic}</p>
                                    </div>
                                </div>
                                <div class="modal_body-content w-100">
                                    <div class="content">
                                        <div class="mapouter"><div style="width: 100%;" class="gmap_canvas"><iframe class="gmap_iframe" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?width=600&amp;height=400&amp;hl=en&amp;q=Lot I-11 , D2 street, Hi-Tech Park, Tang Nhon Phu B Ward, District 9, HCMC&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe></div><style>.mapouter{position:relative;text-align:right;width:100%;}.gmap_canvas {overflow:hidden;background:none!important;width:100%;}.gmap_iframe {width:100%!important;}</style></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
     
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
    doAction();
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

let canLeave = false

function doAction() {
    $('.edit_btn').click(function () {
        this.classList.toggle('hide');
        this.nextElementSibling.classList.toggle('hide');
    }
    );
    $('.subnav').mouseleave(function () {
        this.classList.toggle('hide')
        this.previousElementSibling.classList.toggle('hide')
    })
}


//--------------------------------------------------------------------------------


const contactBtn = document.querySelector('.contact');

const apply = document.querySelector('.job_apply-icon');

const applyIcon = document.querySelector('.apply');

const checkIcon = document.querySelector('.check');

apply.addEventListener('click', (e) => {
    console.log(e.target);
    applyIcon.classList.add('hide');
    checkIcon.classList.remove('hide');
});
