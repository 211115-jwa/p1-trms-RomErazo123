
document.getElementById(`ReimbursementAllList`).onclick = getReimbursements;


console.log("Hi from JavaScript");
async function getReimbursements() {
	console.log("Hi from Reimbursement");
	let userInput = document.getElementById('eim').value;
	console.log(userInput);
    let response = await fetch('http://localhost:8080/request/' + userInput);
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

// function showReimbursementList(Reimbursements) {
    // let ReimbursementTable = document.getElementById('ReimbursementList');
	// let i = 0;

    // for (let Reimbursement of Reimbursements) {
		
		// let submitted = Reimbursements[i].submittedAt;
		// for(int i =0; i < 6; i++){
		// if(submitted[i] < 10){submitted[i] = ('0' + submitted[i]);}}
		
		// sub = (submitted[0] + '/' + submitted[1] + '/' + submitted[2] '/' + submitted[3] '/' + submitted[4] '/' + submitted[5]);
		// let status = Reimbursements[i].status;
		// stat = (status.statusId + ':' + status.name);
		// let eventType = (Reimbursements[i].eventType);
		// eType = (eventType.eventId + ':' + eventType.name);
		// let gradingFormat = (Reimbursements[i].gradingFormat);
		// gFormat = (gradingFormat.formatId + ':' + gradingFormat.name);
		// let eventTime = (Reimbursements[i].eventTime);
		// eTime = (eventTime[0] + ':' + eventTime[1]);
		// let eventDate = (Reimbursements[i].eventTime);
		// eDate = (eventDate[1] + '/' + eventDate[2] + '/' + eventDate[0]);
		// let employees = (Reimbursements[i].requestor);
		
        // let rowForRmb = document.createElement('tr');
        
        // for (let field in Reimbursement) {
			
	     // if(field == 'requestor'){
            			// let column = document.createElement('td');
				// column.innerText = employees.empId;
				// rowForRmb.appendChild(column);
				// let column1 = document.createElement('td');
				// column1.innerText = (employees.firstName + " " + employees.lastName);
				// rowForRmb.appendChild(column1);
            // }else if (field=='eventDate') {
                		// let column = document.createElement('td');
				// column1.innerText = (eDate);
				// rowForRmb.appendChild(column);
            // } else if (field=='eventTime') {
                		// let column = document.createElement('td');
				// column1.innerText = (eTime);
				// rowForRmb.appendChild(column);
            // } else if (field=='gradingFormat') {
                		// let column = document.createElement('td');
				// column1.innerText = (gFormat);
				// rowForRmb.appendChild(column);
            // } else if (field=='eventType') {
                		// let column = document.createElement('td');
				// column1.innerText = (eType);
				// rowForRmb.appendChild(column);
            // } else if (field=='status') {
                		// let column = document.createElement('td');
				// column1.innerText = (stat);
				// rowForRmb.appendChild(column);
            // } else if (field=='submittedAt') {
                		// let column = document.createElement('td');
				// column1.innerText = (sub);
				// rowForRmb.appendChild(column);
            // } else {
				// let column = document.createElement('td');
                		// rowForRmb.appendChild(column);
				// column.innerText = Reimbursement[field];
            // }
        // }
		// i++;
        // ReimbursementTable.appendChild(rowForRmb);
    // }
// }
