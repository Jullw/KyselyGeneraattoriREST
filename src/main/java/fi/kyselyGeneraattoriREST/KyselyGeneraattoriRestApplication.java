package fi.kyselyGeneraattoriREST;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class KyselyGeneraattoriRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyGeneraattoriRestApplication.class, args);
        }
	
	@Bean
	public CommandLineRunner demo( UserRepository urepository) {
		return (args) -> {
		
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", 
					"user@email.com","USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@email.com" ,"ADMIN");

			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
