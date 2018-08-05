package ishop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ishop.order.domain.OrderConfirmedEvent;
import ishop.order.service.OrderLineDTO;
import ishop.order.service.ProductDTO;


@Component
public class OrderConfirmedListener {
	@Autowired
	private EmailSender emailSender;
	@Autowired
	ProductCatalogProxy productCatalogProxy;
	
	  @EventListener
	  public void onOrderConfirmedEvent(OrderConfirmedEvent orderConfirmedEvent) {
		  emailSender.sendEmail("Order is confirmed, orderNumber="+orderConfirmedEvent.getOrder().getOrdernumber(), orderConfirmedEvent.getOrder().getCustomer().getEmail());
		  
		  for (OrderLineDTO  orderLineDTO: orderConfirmedEvent.getOrder().getOrderlineList()) {
			  ProductDTO productDTO = orderLineDTO.getProduct();
			  SoldProductDTO soldProductDTO = new SoldProductDTO(productDTO.getProductnumber(), orderLineDTO.getQuantity());
		  }
	  }
}


