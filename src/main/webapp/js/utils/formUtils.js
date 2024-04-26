/**
 * Toggle the visibility of a form
 */
function toggleFormVisibility(formId) {
    var formElement = document.getElementById(formId);
    if (formElement.style.display === 'none') {
        formElement.style.display = 'block';
    } else {
        formElement.style.display = 'none';
    }
}
