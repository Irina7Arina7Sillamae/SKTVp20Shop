
package entity;

import java.io.Serializable;


public class Product implements Serializable {
    
    private String productName;
    private String productGroup;
    private int quantity;
    private int price;
    private int count;

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "* Товар *" 
                + " наименование: " + productName 
                + ", группа товара: " + productGroup 
                + ", поступило: " + quantity + "шт"
                + ", цена за еденицу товара: " + price + "EUR"
                + ", в наличии: " + count + "шт";
    }

}
