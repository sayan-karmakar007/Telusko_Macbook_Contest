package com.telusko.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);
		ProductService service = context.getBean(ProductService.class);


		// Adding products to the service
		service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
		service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
		service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
		service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
		service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
		service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
		service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
		service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
		service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
		service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
		service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
		service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
		service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));

		try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Product Service!");
            System.out.println("==============================================");

            boolean exit = false;

            while (!exit) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Get all products");
                System.out.println("2. Get a particular product");
                System.out.println("3. Get products with text");
                System.out.println("4. Get products with place");
                System.out.println("5. Get products out of warranty");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 0:
                        // System.out.println("\n");
                        exit = true;
                        break;

                    case 1:
                        // System.out.println("\n");
                        List<Product> allProducts = service.getAllProducts();
                        System.out.println("All Products:");
                        for (Product p : allProducts) {
                            System.out.println(p);
                        }
                        break;

                    case 2:
                        // System.out.println("\n");
                        System.out.println("Enter the name of the product:");
                        String productName = scanner.nextLine();
                        Product product = service.getProduct(productName);
						if (product != null) {
							System.out.println("Product found:");
                            System.out.println(product);
						} else {
							System.out.println("Product not found.");
						}
                        break;

                    case 3:
                        // System.out.println("\n");
                        System.out.println("Enter the search text:");
                        String searchText = scanner.nextLine();
                        List<Product> productsWithText = service.getProductWithText(searchText);
                        System.out.println("Products with Text:");
                        for (Product p : productsWithText) {
                            System.out.println(p);
                        }
                        break;

                    case 4:
                        // System.out.println("\n");
                        System.out.println("Enter the place:");
                        String place = scanner.nextLine();
                        List<Product> productsWithPlace = service.getProductWithPlace(place);
                        System.out.println("Products with Place:");
                        for (Product p : productsWithPlace) {
                            System.out.println(p);
                        }
                        break;

                    case 5:
                        // System.out.println("\n");
                        List<Product> productsOutOfWarranty = service.getProductOutofWarranty();
                        System.out.println("Products out of warranty:");
                        for (Product p : productsOutOfWarranty) {
                            System.out.println(p);
                        }
                        break;

                    default:
                        System.out.println("\nInvalid choice. Please try again.");
                        break;
                }
            }
        }

        System.out.println("\nThank you for using the Product Service!\n");
    }

}
