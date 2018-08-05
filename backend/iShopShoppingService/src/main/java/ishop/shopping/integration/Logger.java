package ishop.shopping.integration;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("ShoppingLogger")
public class Logger {

	public void log(String message) {
		System.out.println("Logging --------- "+new Date()+ " "+message);
	}
		
}
