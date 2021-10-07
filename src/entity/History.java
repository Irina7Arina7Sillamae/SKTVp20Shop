
package entity;

import java.util.Date;


public class History {
     
    private Buyer buyer;
    private Product product;
    private Date saleOfGoods;
    private Date paymentforGoods;

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

    public Date getPaymentforGoods() {
        return paymentforGoods;
    }

    public void setPaymentforGoods(Date paymentforGoods) {
        this.paymentforGoods = paymentforGoods;
    }

    @Override
    public String toString() {
        return "History{" + "buyer=" + buyer + ", product=" + product + ", saleOfGoods=" + saleOfGoods + ", paymentforGoods=" + paymentforGoods + '}';
    }

    
}
