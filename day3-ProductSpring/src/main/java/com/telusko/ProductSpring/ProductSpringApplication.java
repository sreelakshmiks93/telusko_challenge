package com.telusko.ProductSpring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		ProductService service =context.getBean(ProductService.class);

		System.out.println("==============================================");
		System.out.println("List all products");
		List<Product> products = service.getAllProducts();
		products.stream().forEach(product -> System.out.println(product));


		System.out.println("==============================================");

		System.out.println("a Particular product");

		Product p = service.getProduct("Logi Mouse");
		System.out.println(p);

		System.out.println("==============================================");
		System.out.println("a Particular text 'black'");

		List<Product> prods = service.getProductWithText("black");
		prods.stream().forEach(product -> System.out.println(product));


		System.out.println("==============================================");
		System.out.println("Search by place");
		List<Product> prodsOnBlackTable = service.searchByPlace("black Table");
		prodsOnBlackTable.stream().forEach(product -> System.out.println(product));


		System.out.println("==============================================");
		System.out.println("Search by products out of warranty");
		List<Product> expiredProds = service.findProductsOutOfWarranty();
		expiredProds.stream().forEach(product -> System.out.println(product));




	}

}
