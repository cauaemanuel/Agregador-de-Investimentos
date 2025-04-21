package casa.on.agregadordeinvestimentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgregadordeinvestimentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgregadordeinvestimentosApplication.class, args);
	}

}
