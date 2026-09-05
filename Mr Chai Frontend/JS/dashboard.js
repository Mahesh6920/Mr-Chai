document.addEventListener("DOMContentLoaded", () => {

    console.log("Dashboard JS loaded");

    fetchProducts();

});


async function fetchProducts() {

    try {

        console.log("Calling product API...");

        const response = await fetch("http://localhost:8080/products");

        console.log("Response status:", response.status);

        if (!response.ok) {
            throw new Error("HTTP Error: " + response.status);
        }

        const products = await response.json();

        console.log("Products received:", products);

        displayProducts(products);

    } catch (error) {

        console.error("Error fetching products:", error);

    }
}


function displayProducts(products) {

    const productList = document.getElementById("product-list");

    console.log("Product list element:", productList);

    productList.innerHTML = "";

    products.forEach(product => {

        const productItem = document.createElement("div");

        productItem.classList.add("product-card");

        productItem.innerHTML = `
            
            <img 
                src="../Images/${product.productURL}" 
                alt="${product.productName}" 
                class="product-image"
            >

            <div class="product-info">

                <h3 class="product-name">
                    ${product.productName}
                </h3>

                <p class="product-description">
                    ${product.productDescription}
                </p>

                <p class="product-price">
                    ₹${product.productPrice}
                </p>

                <button class="add-cart-btn">
                    Add to Cart
                </button>

            </div>
        `;

        productList.appendChild(productItem);

    });
}