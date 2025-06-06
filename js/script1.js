let number = parseFloat(prompt("Enter a number:"));

if (number > 0) {
  console.log("The number is positive.");
} else if (number < 0) {
  console.log("The number is negative.");
} else {
  console.log("The number is zero.");
}

let num1 = parseFloat(prompt("Enter the first number:"));
let num2 = parseFloat(prompt("Enter the second number:"));

if (num1 > num2) {
  console.log("The first number is greater than the second number.");
} else if (num1 < num2) {
  console.log("The first number is less than the second number.");
} else {
  console.log("Both numbers are equal.");
}

let operation = prompt("Choose an operation: +, -, *, /, %");

switch (operation) {
  case "+":
    console.log("Result: " + (num1 + num2));
    break;
  case "-":
    console.log("Result: " + (num1 - num2));
    break;
  case "*":
    console.log("Result: " + (num1 * num2));
    break;
  case "/":
    if (num2 !== 0) {
      console.log("Result: " + (num1 / num2));
    } else {
      console.log("Cannot divide by zero.");
    }
    break;
  case "%":
    if (num2 !== 0) {
      console.log("Result: " + (num1 % num2));
    } else {
      console.log("Cannot perform modulus with zero.");
    }
    break;
  default:
    console.log("Invalid operation selected.");
}

for (let i = 1; i <= 100; i++) {
  if (i % 3 === 0 && i % 5 === 0) {
    console.log("FizzBuzz");
  } else if (i % 3 === 0) {
    console.log("Fizz");
  } else if (i % 5 === 0) {
    console.log("Buzz");
  } else {
    console.log(i);
  }
}

function factorial(n) {
  if (n === 0 || n === 1) return 1;
  return n * factorial(n - 1);
}

function isPalindrome(str) {
  str = str.toLowerCase().replace(/[^a-z0-9]/g, ''); // removing non alpha-numeric
  return str === str.split('').reverse().join('');
}

function sortArray(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        // Swap
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  return arr;
}

function findMinMax(arr) {
  let min = arr[0];
  let max = arr[0];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < min) min = arr[i];
    if (arr[i] > max) max = arr[i];
  }

  console.log("Largest:", max);
  console.log("Smallest:", min);
}

findMinMax([7, 2, 10, 4, 8]); 
console.log(sortArray([3, 1, 4, 1, 5, 9, 2]));
console.log(factorial(5));
console.log(isPalindrome("hello")); 

let todoList = [];

function addTask(taskName) {
  const newTask = {
    name: taskName,
    status: "pending"
  };
  todoList.push(newTask);
  console.log(`Added task: "${taskName}"`);
}

function markCompleted(taskName) {
  const task = todoList.find(t => t.name === taskName);
  if (task) {
    task.status = "completed";
    console.log(`Marked "${taskName}" as completed.`);
  } else {
    console.log(`Task "${taskName}" not found.`);
  }
}

function displayTasks() {
  console.log("To-Do List:");
  todoList.forEach((task, index) => {
    console.log(`${index + 1}. ${task.name} - ${task.status}`);
  });
}

function deleteTask(taskName) {
  const index = todoList.findIndex(t => t.name === taskName);
  if (index !== -1) {
    todoList.splice(index, 1);
    console.log(`Deleted task: "${taskName}"`);
  } else {
    console.log(`Task "${taskName}" not found.`);
  }
}

addTask("Do Exercise");
addTask("Study JavaScript");
addTask("Do assignments");

markCompleted("Study JavaScript");

deleteTask("Do Exercise");

displayTasks();