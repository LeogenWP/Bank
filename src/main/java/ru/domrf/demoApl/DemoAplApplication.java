package ru.domrf.demoApl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.domrf.demoApl.model.Product;
import ru.domrf.demoApl.model.Role;
import ru.domrf.demoApl.model.User;
import ru.domrf.demoApl.service.ProductService;
import ru.domrf.demoApl.service.UserService;

@SpringBootApplication
public class DemoAplApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAplApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(ProductService productService, UserService userService) {
		return args -> {
			Product p = new Product();
			p.setBarcode("463");
			p.setName("morkov");
			p.setPrice("100");
			productService.saveProduct(p);

			User user = new User();
			user.setPassword("123");
			user.setEmail("8000@mail");
			user.setUsername("123");
			Role role = new Role();
			role.setName("ADMIN");
			//userService.saveRole(role);
			user.addRole(role);
			userService.saveUser(user);
			//productService.saveProduct(new Product(1,"6464","orange",20));
			//userService.saveRole(new Role(null,"ROLE_MANAGER"));
			//userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			//userService.saveUser(new User(null,"BOb","bob","123",new ArrayList<>()));
		};
	}

}
