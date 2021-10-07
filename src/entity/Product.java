
package entity;


public class Product {
    
    private String productName;
    private String productGroup;
    private int quantityOfGoods;
    private double productPrice;

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

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        this.quantityOfGoods = quantityOfGoods;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productGroup=" + productGroup + ", quantityOfGoods=" + quantityOfGoods + ", productPrice=" + productPrice + '}';
    }

    
   
    }

    

