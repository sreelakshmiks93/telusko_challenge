package day2.inventory;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
	 List<Product> products = new ArrayList<>();

	    public void addProduct(Product p){
	        products.add(p);
	    }

	    public List<Product> getAllProducts(){
	        return products;
	    }

	    public Product getProduct(String name){
	    	 // Filter using Stream API
	    	Optional<Product> x =  products.stream()
	    	.filter(y -> y.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase()))
	    	.findFirst();

	    	if(x.isPresent()) {
	    		return x.get();
	    	}
	        return null;
	    }

	    public List<Product> getProductWithText(String text) {
	        String str = text.toLowerCase();
	        List<Product> prods = new ArrayList<>();

	        // Filter using Stream API
	        prods = products.parallelStream().filter(p -> {
	            String name = p.getName().toLowerCase();
	            String type = p.getType().toLowerCase();
	            String place = p.getPlace().toLowerCase();
	            return (name.contains(str) || type.contains(str) || place.contains(str));
	        }).collect(Collectors.toList());
	        return prods;
	    }

		public List<Product> searchByPlace(String text) {
			String str = text.toLowerCase();
	        List<Product> prods = new ArrayList<>();

	        // Filter by place
	        prods = products.parallelStream().filter(p -> p.getPlace().toLowerCase().equals(str)).collect(Collectors.toList());
	        return prods;
		}

		public List<Product> findProductsOutOfWarranty() {
			List<Product> prods = new ArrayList<>();

	        // Filter by place
			int year = Year.now().getValue();
	        prods = products.parallelStream().filter(x -> x.getWarranty() < year).collect(Collectors.toList());
	        return prods;
		}
}
