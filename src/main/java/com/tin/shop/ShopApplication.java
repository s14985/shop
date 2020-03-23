package com.tin.shop;

import com.tin.shop.model.Material;
import com.tin.shop.model.Product;
import com.tin.shop.model.Roles;
import com.tin.shop.model.User;
import com.tin.shop.service.MaterialService;
import com.tin.shop.service.ProductService;
import com.tin.shop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MaterialService materialService, ProductService productService, UserService userService, PasswordEncoder passwordEncoder) {
        return args -> {
            Material cotton = new Material("Cotton");
            Material wool = new Material("Wool");
            Material artificial = new Material("Artificial");
            materialService.save(cotton);
            materialService.save(wool);
            materialService.save(artificial);
            productService.save(new Product("Black Blanket", "Small cow-like pattern", 50.00, "../../../assets/images/blanket-1.svg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", artificial));
            productService.save(new Product("Brown Blanket", "Panther pattern", 40.00, "../../../assets/images/blanket-2.svg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", artificial));
            productService.save(new Product("Gray Blanket", "Zebra stripes pattern", 60.00, "../../../assets/images/blanket-3.svg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", artificial));
            productService.save(new Product("Plain Brown Blanket", "Cotton/Cashmere blanket", 40.00, "../../../assets/images/blanket-4.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", wool));
            productService.save(new Product("Chocolate Blanket", "Snowy soft", 50.00, "../../../assets/images/blanket-5.jpeg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", cotton));
            productService.save(new Product("Decorative Blanket", "Sofa/couch throw blanket", 45.00, "../../../assets/images/blanket-6.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", cotton));
            productService.save(new Product("Heidi Throw Blanket", "Brown/White safari", 50.00, "../../../assets/images/blanket-7.jpeg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", cotton));
            productService.save(new Product("Benzara Soft Blanket", "Brown and White knitted", 35.00, "../../../assets/images/blanket-8.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", wool));
            productService.save(new Product("Natural Throw Blanket", "Pure new wool", 35.00, "../../../assets/images/blanket-9.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis metus sapien. Nulla nec ullamcorper nibh. Proin massa ante, ornare at elit eget, suscipit consectetur ante.", wool));
            userService.save(new User("Anna", "Poziomka", "Kolejowa 12", "12-123", "Warsaw", "Poland", "a.poziomka@gmail.com", passwordEncoder.encode("pass"), Roles.USER));
            userService.save(new User("Garry", "Oldman", "Drukarzy 12", "02-123", "Warsaw", "Poland", "gold@gmail.com", passwordEncoder.encode("adminpass"), Roles.ADMIN));
        };
    }
}
