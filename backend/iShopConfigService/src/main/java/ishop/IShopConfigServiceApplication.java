package ishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class IShopConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IShopConfigServiceApplication.class, args);
	}
}
