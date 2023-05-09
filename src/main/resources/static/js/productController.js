
//development APIs
const addAPI= 'http://localhost:8081/item/add';
const displayAPI = 'http://localhost:8081/item/all';


let productController = [];

function displayItem()
{
productController = [];

       //fetch data from database using the REST API endpoint from Spring Boot
       //GET http method is default
       fetch(displayAPI)
           .then((resp) => resp.json())
           .then(function(data) {
               console.log("2. receive data")
               console.log(data);

               data.forEach(function (item, index) {
                   const itemObj = {
                       id: item.id,
                       title: item.title,
                       description: item.description,
                       targetdate: item.targetdate

                  };
                   productController.push(itemObj);     // This array consists of 3 objects
             });

             renderProductPage();   // Display all objects from the productController array

           })
           .catch(function(error) {
               console.log(error);
           });
}



//(3)  Display all products when user launch the product.html page
//const displayProduct = () => {
function renderProductPage() {

    let display = "";

    for (let i = 0; i < productController.length; i++ ) {

        display += `
            <tr>
                <td>${productController[i].title}</td>
                <td>${productController[i].description}</td>
                   <td>${productController[i].targetdate}</td>
            </tr>
        `

//        display += `
//            <div  class="col-lg-4">
//            <div class="card" style="width: 18rem;">
//                <img src=${productController[i].imageUrl} class="card-img-top"
//                    alt="image">
//                <div class="card-body">
//                    <h5 class="card-title">${productController[i].name}</h5>
//                    <p class="card-text">${productController[i].style}</p>
//                    <a id="item${i+1}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal" onClick="displayDetails(${i})">More</a>
//                </div>
//            </div>
//        </div>
//        `
    }

    document.querySelector("#toDoList").innerHTML= display;

} //End of renderProductPage function


function addProduct(title, description, targetdate)
{
//  FormData is an Object provided by the Browser API for us to send the data over to the backend
   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('targetdate', targetdate);


  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status - 200 ok, 500, 404..
            if (response.ok) {
                alert("Successfully Added List!")
                displayItem()
                 window.location.href = '/index';
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding task to List")
        });
}






