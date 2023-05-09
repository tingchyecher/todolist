//Global variable - to store the image object
//let storeImage = ""


//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database


//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {


  // Prevent default action of the Form submission
  event.preventDefault();


  //1) Select the inputs
  const title = document.querySelector('#inputTitle').value;
  const description = document.querySelector('#inputDescription').value;
  const date = document.querySelector('#inputDate').value;

  //Browser security will not be able to track/store the actual path of where you choose your image
  // C:/Users/Desktop/t-shirt_new.jpg
  //C:\fakepath\t-shirt_new.jpg
  //console.log(document.querySelector('#newItemImageFile').value + '\n' + "Hello world");


//    2)
//      Do the Validation code here

        const currentDate = new Date();
        const selectDate = new Date(date);
        if (selectDate < currentDate) {
        alert("Please select a future date!")
        }
//        console.log(date);
//        console.log(currentDate);





  // 3)  calls a function from the productController.js to access the API to add items to the database
  addProduct(title, description, date);  //arguments

});





