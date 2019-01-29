package b190172.adminfrontend.webflow.handler;

import org.springframework.stereotype.Component;

import b190172.backend.model.Product;

@Component("addProductHandler")
public class AddProductHandler {
	
	
	public Product initFlow() {
		System.out.println("executed");
		return new Product();
	}

}
