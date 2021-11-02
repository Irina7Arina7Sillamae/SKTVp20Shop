
package entity;

import java.io.Serializable;

public class Buyer implements Serializable {
    
    private String buyername;
    private String statusname;
    private String phone;

    public Buyer() {
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "* Покупатель * " + " Имя покупателя: " + buyername 
                + ", статус: " + statusname 
                + ", тел. " + phone ;
    }

    
   
    
}