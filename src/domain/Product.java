/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiaweili
 */
public class Product {
    private String name;
    private String description;
    private String uri;

    public Product(String name, String description, String uri) {
        this.name = name;
        this.description = description;
        this.uri = uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", description=" + description + ", uri=" + uri + '}';
    }
    
    
    
}
