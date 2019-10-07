function check(input) {
    	console.log("print");
        if (input.value != document.getElementById('pass').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }

function callDelete(id){
	var flag = confirm("Student will be removed permanently!");
	if(flag == true){
		fetch("Student" + "?id=" + id, {
		    method: 'delete'
		  });
		var element = document.getElementById(id);
		element.parentNode.removeChild(element);
	}
}