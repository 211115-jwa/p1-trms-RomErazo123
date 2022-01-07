getReimbursements();
// let response = await fetch('http://localhost:8080/pets/8',{method:'PUT', body:JSON.stringify(petObj)});

document.getElementById(`ReimbursementAllList`).onclick = getReimbursements;

async function getReimbursements() {
	let userInput = document.getElementById('eim').value;
    let response = await fetch('http://localhost:8080/request' + userInput);
    
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

// function showReimbursementList(Reimbursements) {
    // let ReimbursementTable = document.getElementById('ReimbursementList');
	// let i = 0;
    f//or each Reimbursement in the array of Reimbursements that we got from the back end
    // for (let Reimbursement of Reimbursements) {
		
		// let submitted = Reimbursements[i].submittedAt;
		// for(int i =0; i < 6; i++){
		// if(submitted[i] < 10){submitted[i] = ('0' + submitted[i]}}
		
		// sub = submitted[0] + '/' + submitted[1] + '/' + submitted[2] '/' + submitted[3] '/' + submitted[4] '/' + submitted[5];
		// let statos = Reimbursements[i].statos;
		// stat = (statos.statosId + ':' + statos.name);
		
        // let rowForRmb = document.createElement('tr');
        //for each field in the Reimbursements (yes, we can iterate through fields)
        // for (let field in Reimbursement) {
            // let column = document.createElement('td');
            // if (field!=='status') {
                reimbursement[field] gets the value of the field
                // column.innerText = Reimbursement[field];
            // } else {
                
            // }
            // rowForRmb.appendChild(column);
        // }
        // ReimbursementTable.appendChild(rowForRmb);
    // }
// }
