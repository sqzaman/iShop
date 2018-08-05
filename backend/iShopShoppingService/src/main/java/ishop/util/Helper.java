package ishop.util;

import java.time.Instant;
import java.util.Random;

public class Helper {
	private static Helper instance = new Helper();

	private Helper() {

	}

	public static Helper getInstance() {
		return instance;
	}

	public String generateRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 32) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		return String.format("%s%s", Instant.now().getEpochSecond(), salt.toString());


	}

}
