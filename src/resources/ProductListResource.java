/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.ProductDAO;
import domain.Product;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Status;

/**
 *
 * @author jiaweili
 */
public class ProductListResource extends Jooby{
    
    public ProductListResource(ProductDAO dao) {

		/**
		 * A product catalogue management service.
		 */
		path("/api/products", () -> {

			/**
			 * Get the details for all products in the catalogue.
			 *
			 * @return products in the catalogue.
			 */
			get(() -> {
				return dao.getProducts();
			});

			/**
			 * Add an product to the .
			 *
			 * @param body The product to add to the catalogue.
			 * @return 201 response if successful.
			 */
			post((req, rsp) -> {
				Product product = req.body(Product.class);
				dao.addProduct(product);
				rsp.status(Status.CREATED)
					.header("location",
						"http://" + req.hostname()+":"+req.port()+""+req.path()+"/"+product.getName());
			});

		}).produces(MediaType.json).consumes(MediaType.json);
	}

}

  
