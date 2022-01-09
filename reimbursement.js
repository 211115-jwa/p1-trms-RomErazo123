
document.getElementById(`ReimbursementAllList`).onclick = getReimbursements;


console.log("Hi from JavaScript");
async function getReimbursements() {
	console.log("Hi from Reimbursement");
	let userInput = document.getElementById('eim').value;
	console.log(userInput);
    let response = await fetch('http://localhost:8080/request/' + userInput) {
        method: 'POST'
    });
	//let data = response.json();
    console.log(response);
    if (response.status === 200) {
        let Reimbursements = await response.json();
        console.log(Reimbursements);
        //showReimbursementList(Reimbursements);
    }else if (response == ''){
		alert('response is empty');
	}
	else {
		alert('404 Error Not Found: No request by id exist');
	}
}
