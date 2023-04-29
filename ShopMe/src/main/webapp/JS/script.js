let amount = 0;

function add_to_cart(pid, pname, price)
{
	let cart_array = localStorage.getItem("cart");
	
	//for checking if any product is added or there is no product in cart
	if(cart_array == null)
	{
		//add product for the 1st tym when there was no product in cart
		
		let products = []; //products array
		
		//creating object of product to add inside cart
		let product = {productId: pid, productName: pname, productQuantity:1, productPrice:price}
		products.push(product);
		
		localStorage.setItem("cart",JSON.stringify(products));
		console.log("product added for 1st tym")
		showToast("Product is added to cart")
	}
	else{
		//now there are some products in cart so now need to check if we are added same product or new product
		
		//fetching all the products present inside cart]  
		let cart_object_array = JSON.parse(cart_array);
		
		//checking if product already present
		let old_product = cart_object_array.find((item) => item.productId == pid)
		
		
		if(old_product)
		{
			//product already present
			
			//increasing quantity temporarily
			old_product.productQuantity = old_product.productQuantity+1
			
			//search for product in array
			cart_object_array.map((item) => {
				
				if(item.productId == old_product.productId)
				{
					
					item.productQuantity = old_product.productQuantity;
					
				}
				console.log("quantity is increased")
				showToast(item.productName + " quantity is increased")
				
			})
			localStorage.setItem("cart",JSON.stringify(cart_object_array));
		}
		else{
			//product needs to be added
			
			let product = {productId: pid, productName: pname, productQuantity:1, productPrice:price}
			cart_object_array.push(product);
			localStorage.setItem("cart",JSON.stringify(cart_object_array));
			console.log("product added")
			showToast("Product is added to cart")
		}
		
	}
	update_cart()
}

//update cart

function update_cart()
{
	let cartString = localStorage.getItem("cart");
	
	let cart = JSON.parse(cartString);
	
	if(cart == null || cart.length == 0)
	{
		console.log("cart is empty")
		$(".cart-items").html("( 0 )");
		$(".cart-body").html("<h5 class='text-center'>Your cart is empty!</h5>");
		$(".checkout-btn").attr('disabled',true);
	}
	else{
		//card having items
		$(".cart-items").html(`( ${cart.length} )`);
		
		let table = `
		
			<table class='table'>
			
				<thead class='thead-light'>
					<tr>
						<th>Item Name </th>
						<th>Price </th>
						<th>Quantity </th>
						<th>Total Price </th>
						<th>Action </th>
					</tr>
				</thead>
		
		`;
		
		let totalPrice = 0;
		cart.map((item) => {
			
			table += `
			
				<tr>
					<td> ${item.productName} </td>
					<td> ${item.productPrice} </td>
					<td> <button class='btn btn-warning' onclick='increament(${item.productId})'>+</button> ${item.productQuantity} <button class='btn btn-warning' onclick='decreament(${item.productId})'>-</button> </td>
					<td> ${item.productPrice * item.productQuantity} </td>
					<td> <button onclick='deleteCartItem(${item.productId})' class='btn btn-danger'>Remove</button> </td>
				</tr>
			
			`
			totalPrice += item.productPrice*item.productQuantity;
		})
		
		table = table + `
			<tr>
				<td style='font-size:20px' colspan='5' class='text-secondary text-right font-weight-bold pt-5'>Total Price : &#8377; ${totalPrice} </td>
			</tr>
		</table>`;
		amount = totalPrice;
		
		$(".cart-body").html(table);
		$(".checkout-btn").attr('disabled',false);
	}
}

function deleteCartItem(pid)
{
	let cart_array = JSON.parse(localStorage.getItem("cart"));
	
	let new_cart_array = cart_array.filter((item) => item.productId != pid);
	
	localStorage.setItem("cart",JSON.stringify(new_cart_array));
	
	update_cart()
	showToast("Product is removed from cart")
}


$( document ).ready(function(){
	update_cart()
});


function showToast(content)
{
	$("#toast").addClass("display");
	$("#toast").html(content);
	setTimeout(()=> {
		$("#toast").removeClass("display");
	}, 2000);
}

function goToCheckout(){
	window.location = "Checkout.jsp"
}


const paymentStart = () => {
	console.log("payment started..");
	console.log(amount);
	if(amount == 0)
	{
		alert("No item selected!");
		return;
	}
	else{
		document.getElementById("jsCart").value = localStorage.getItem("cart");
		document.getElementById("checkForm").action = "/ShopMe/CheckoutServlet";
		document.getElementById("checkForm").method = "POST";
		document.getElementById("checkForm").submit();
	}
}

function buyNow(prodId, name, price)
{
	console.log(prodId)
	console.log(name)
	let cartString = localStorage.getItem("cart");
	
	let cartArray = JSON.parse(cartString);
	let cart =[];
	
	if(cartArray == null || cartArray.length == 0)
	{
		//add to cart
		let product = {productId: prodId, productName: name, productQuantity:1, productPrice:price}
			cart.push(product);
			localStorage.setItem("cart",JSON.stringify(cart));
			console.log("product added")
			showToast("Product is added to cart")
	}
	else{
		//increase quantity
		let obj = cartArray.filter((item) => item.productId == prodId);
	
		obj.productQuantity = obj.productQuantity+1
			
			//search for product in array
			cartArray.map((item) => {
				
				if(item.productId == obj.productId)
				{
					
					item.productQuantity = obj.productQuantity;
					
				}
				console.log("quantity is increased")
				showToast(item.productName + " quantity is increased")
				
			})
			localStorage.setItem("cart",JSON.stringify(cartArray));
	}
	
	goToCheckout()
}


function increament(id)
{
	
	let cartArray = JSON.parse(localStorage.getItem("cart"));
	
	let obj = cartArray.filter((item) => item.productId == id);
	
	
	obj.map((item)=>{
		item.productQuantity += 1;
		console.log(item.productQuantity)
	})
	
	localStorage.setItem("cart",JSON.stringify(cartArray));
	
	update_cart()
	

	
}

function decreament(id)
{
	let cartArray = JSON.parse(localStorage.getItem("cart"));
	
	let obj = cartArray.filter((item) => item.productId == id);
	
	
	obj.map((item)=>{
		
		if(item.productQuantity > 1){
			item.productQuantity -= 1;
		}
		
	})
	
	localStorage.setItem("cart",JSON.stringify(cartArray));
	
	update_cart()
}


