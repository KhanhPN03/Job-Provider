const editButton = document.getElementById('editButton');
const updateButton = document.getElementById('updateButton');
const data = [];
editButton.addEventListener('click', function () {
  editField('fullname');
  editField('email');
  editField('phone');
  editField('address');
});

updateButton.addEventListener('click', function () {
  updateContent('fullname');
  updateContent('email');
  updateContent('phone');
  updateContent('city');
  updateContent('address');
});

function editField(fieldName) {
  toggleButtons(fieldName);
  enableEditField(fieldName);
  prefillInputField(fieldName);
}

function toggleButtons(fieldName) {
  const editButton = document.getElementById(`editButton`);
  const updateButton = document.getElementById(`updateButton`);
  if (editButton.style.display !== 'none') {
    editButton.style.display = 'none';
    updateButton.style.display = 'inline';
  } else {
    editButton.style.display = 'inline';
    updateButton.style.display = 'none';
  }
}

function prefillInputField(fieldName) {
  const spanElement = document.getElementById(`${fieldName}-span`);
  const inputElement = document.getElementById(`${fieldName}-input`);
  inputElement.value = spanElement.textContent;
}

function enableEditField(fieldName) {
  const spanElement = document.getElementById(`${fieldName}-span`);
  const inputElement = document.getElementById(`${fieldName}-input`);
  spanElement.classList.add('hide');
  inputElement.classList.remove('hide');
}

function updateContent(fieldName) {
  const spanElement = document.getElementById(`${fieldName}-span`);
  const inputElement = document.getElementById(`${fieldName}-input`);
  spanElement.textContent = inputElement.value;
  disableEditField(fieldName);
  toggleButtons(fieldName);
  saveData(fieldName, inputElement.value);
}

function disableEditField(fieldName) {
  const spanElement = document.getElementById(`${fieldName}-span`);
  const inputElement = document.getElementById(`${fieldName}-input`);
  spanElement.classList.remove('hide');
  inputElement.classList.add('hide');

}
function saveData(fieldName, updatedValue) {
  // Create an object with the field name and the updated value
  const fieldData = {
    field: fieldName,
    value: updatedValue,
  };

  // Add the object to the data array
  data.push(fieldData);
}
