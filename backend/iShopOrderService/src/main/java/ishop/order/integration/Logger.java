package ishop.order.integration;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	public void log(String message) {
		System.out.println("Logging --------- "+new Date()+ " "+message);
	}
}
