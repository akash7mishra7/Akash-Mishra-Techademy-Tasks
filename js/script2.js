function taskreminder(taskName,deadline){
    console.log("set: "+taskName);
    console.log("Deadline: "+deadline);
}

function profile(id,name,designation="Employee"){
    console.log("\nID: "+id);
    console.log("Name: "+name);
    console.log("Designation: "+designation);
}

function createEmail(name,dept,jd){
    console.log(`\nDear ${name},\n`);
    console.log(`Welcome to the ${dept} team!`);
    console.log(`Your joining date is ${jd}.`);
}

function preference(language="English",theme="default",notifications = "enabled"){
    console.log(`\nYour settings:-`);
    console.log(`Language: ${language}`);
    console.log(`theme: ${theme}`);
    console.log(`notifications: ${notifications}`);
}

function addParticipant(name){
    participants.push(name);
    console.log("New participant: "+name);
    console.log("Total: "+participants);
}

function displayStock(){
    console.log("Current Inventory: "+stocks);
}

function addToStock(stockName){
    stocks.push(stockName);
    console.log("\nNew stock added: "+stockName);
    console.log("New Inventory: "+stocks);
}

function removeTheStock(stockName){
    stocks = stocks.filter(item => item!==stockName)
    console.log("\nNew Inventory after removing \'"+stockName+"\': "+stocks);
}

function addEmployee(id,name,designation="Employee",salary=26000){
    employees.push({
       id: id,
       name: name,
       designation: designation,
       salary: salary
    });
}

function showEmployees(){
    employees.forEach( emp => {
        console.log("\nName: "+emp["name"]);
        console.log("Designation: "+emp["designation"]);   
    }
    );
}

profile(1,"Akash","Java Dev");