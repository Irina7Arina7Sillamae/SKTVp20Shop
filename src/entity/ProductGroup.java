
package entity;

import java.util.Date;


public class ProductGroup {
    private String productGroupName;
    private String expiryDate;

    public ProductGroup() {
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ProductGroup{" + "productGroupName=" + productGroupName + ", expiryDate=" + expiryDate + '}';
    }

    
    
    
}
