package ishop.order.integration;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	public void sendEmail(String message, String emailAddress) {
		System.out.println("Sending email to "+emailAddress+" with message: "+ message);
	}
}
