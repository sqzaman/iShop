package ishop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ishop.shopping.domain.ShoppingCartCheckedOutEvent;

@Component
public class CheckoutListener {
	@Autowired
	@Qualifier("ShoppingLogger")
	private Logger logger;
	
	  @EventListener
	  public void onCheckoutEvent(ShoppingCartCheckedOutEvent checkOutEvent) {
		  logger.log("Shoppingcart is checked out at "+checkOutEvent.getDate()+" , totalprice = "+checkOutEvent.getCart().getTotalPrice());
	  }
}


