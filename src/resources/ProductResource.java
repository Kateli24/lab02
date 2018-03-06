/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.ProductDAO;
import domain.Product;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.Status;

/**
 *
 * @author jiaweili
 */
public class ProductResource extends Jooby{

	public ProductResource(ProductDAO dao) {

		path("/api/products/product", () -> {

			/**
			 * Get the details for a specific product.
			 *
			 * @param name The item's name.
			 * @return The product matching the given name.
			 */
			get("/:name", (req) -> {
				String name = req.param("name").value();

				if (dao.ifExist(name)) {
					return dao.getProductByName(name);
				} else {
					throw new Err(Status.NOT_FOUND, "No product matches that name");
				}

			});

			/**
			 * Delete a specific product from the catalogue.
			 *
			 * @param name The name of the product to delete.
			 */
			delete("/:name", (req, rsp) -> {
				String name = req.param("name").value();

				if (dao.ifExist(name)) {
					dao.deleteProduct(name);
					rsp.status(Status.NO_CONTENT);
				} else {
					rsp.status(Status.NOT_FOUND);
				}
			});

			/**
			 * Update the details for a specific product.
			 *
			 * @param name The name of the product to update.
			 * @param body The new details for the product.
			 */
			put("/:name", (req, rsp) -> {
				String name = req.param("name").value();
				Product product = req.body().to(Product.class);

				// make sure the names match an existing item or there is a conflict that will likely cause data corruption in the database (PKs should always be immutable)
				if (name.equals(product.getName()) && dao.ifExist(name)) {
					dao.putProduct(name, product);
					rsp.status(Status.ACCEPTED);
				} else {
					rsp.status(Status.CONFLICT);
				}
			});

		}).produces(MediaType.json).consumes(MediaType.json);

	}

}

    

