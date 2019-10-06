function check(input) {
    	console.log("print");
        if (input.value != document.getElementById('pass').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }