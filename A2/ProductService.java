import java.util.ArrayList;
import java.util.List;

import java.time.Year;
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

    public Optional<Product> getProduct(String name){
        return products.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();

        return products.stream().filter(p -> p.getName().toLowerCase().contains(str) || p.getType().toLowerCase().contains(str) || p.getPlace().toLowerCase().contains(str)).collect(Collectors.toList());
    }

    public List<Product> getProductWithPlace(String place) {
        String str = place.toLowerCase();

        return products.stream().filter(p -> p.getPlace().toLowerCase().equals(str)).collect(Collectors.toList());
    }

    public List<Product> getProductOutofWarranty() {
        Year year = Year.now();
        int currentYear = year.getValue();

        return products.stream().filter(p -> p.getWarranty() < currentYear).collect(Collectors.toList());
    }

    /* 
    // Assignment - 2 (i):
    public List<Product> getProductWithPlace(String place) {
        String str = place.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String productPlace = p.getPlace().toLowerCase();
            if(productPlace.equals(str))
                prods.add(p);
        }
        return prods;

    }

    // Assignment - 2 (ii):
    public List<Product> getProductOutofWarranty() {
        Year year = Year.now();
        int currentYear = year.getValue();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            int productWarranty = p.getWarranty();
            if(productWarranty < currentYear)
                prods.add(p);
        }
        return prods;

    }
    */

    // Assignment - 2 (iii) implemented whole using stream api...
}
