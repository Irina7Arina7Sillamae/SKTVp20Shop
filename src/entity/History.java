
package entity;

import java.io.Serializable;
import java.util.Date;


public class History implements Serializable {
     
    private Buyer buyer;
    private Product product;
    private Date saleOfGoods;
    private Date paymentForGoods;

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

    public Date getSaleOfGoods() {
        return saleOfGoods;
    }

    public void setSaleOfGoods(Date saleOfGoods) {
        this.saleOfGoods = saleOfGoods;
    }

    public Date getPaymentForGoods() {
        return paymentForGoods;
    }

    public void setPaymentForGoods(Date paymentForGoods) {
        this.paymentForGoods = paymentForGoods;
    }

    @Override
    public String toString() {
        return "History{" + "buyer=" + buyer + ", product=" + product + ", saleOfGoods=" + saleOfGoods + ", paymentForGoods=" + paymentForGoods + '}';
    }

   
    }

    
    
