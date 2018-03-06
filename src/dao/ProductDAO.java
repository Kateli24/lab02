/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jiaweili
 */
public class ProductDAO {
    
    private static final Map<String,Product> products = new HashMap<>();
    
    public void addProduct(Product newProduct){
        products.put(newProduct.getName(),newProduct);
    }
    
    public List<Product> getProducts(){
        return new ArrayList(products.values());  
    }
    
    public Product getProductByName(String productName){
        return products.get(productName);
    }
    
    public void putProduct(String name, Product newProduct){
        products.put(name, newProduct);
    }
    
    public void deleteProduct(String name){
        products.remove(name);
        
    }
    
    public boolean ifExist(String name){
        return products.containsKey(name);
    }
  
   
}
