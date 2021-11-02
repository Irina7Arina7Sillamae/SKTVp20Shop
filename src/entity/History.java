
package entity;

import java.io.Serializable;
import java.util.Date;


public class History implements Serializable {
     
    private Buyer buyer;
    private Product product;
    private Date saleDate;
    private Date paymentDate;

    public History() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "History{" + "покупатель=" + buyer 
                + ", товар=" + product 
                + ", товар продан=" + saleDate 
                + ", товар оплачен=" + paymentDate 
                + '}';
      }

    }

    
    
