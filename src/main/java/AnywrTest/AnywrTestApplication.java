package AnywrTest;

import AnywrTest.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AnywrTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnywrTestApplication.class, args);
	}

}
