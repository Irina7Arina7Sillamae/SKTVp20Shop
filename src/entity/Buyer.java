
package entity;


public class Buyer {
    
    private String buyerName;
    private String statusName;
    private String phone;

    public Buyer() {
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Buyer{" + "buyerName=" + buyerName + ", statusName=" + statusName + ", phone=" + phone + '}';
    }
     
}
