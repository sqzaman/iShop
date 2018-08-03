package ishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


/*
@EntityScan(basePackageClasses = {
		IShopOAuth2ServiceApplication.class,
		Jsr310JpaConverters.class
})
*/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class IShopOAuth2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IShopOAuth2ServiceApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}
}
