
package myclasses;

import entity.Buyer;
import entity.History;
import entity.Product;
import entity.ProductGroup;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class App {
    public void run() {
       
        Product product1 = new Poduct();
        product1.setProductGroup("Арматура");
        product1.setProductName("Арматура рифленая d8 А500С");
        product1.setQuantityOfGoods(100);
        product1.setProductPrice(2.50);
        
        Buyer buyer1 = new Buyer();
        buyer1.setBuyerName("OU Fewory");
        buyer1.setStatusName("OU");
        buyer1.setPhone("58113989");
        
        ProductGroup productGroup1 = new ProductGroup();
        productGroup1.setProductGroupName("Металлопрокат");
        productGroup1.setExpiryDate("2100");
        
        
        History history1 = new History();
        history1.setBuyer(buyer1);
        history1.setProduct(product1);
        Calendar c = new GregorianCalendar();
        history1.setSaleOfGoods(c.getTime());
        
        System.out.println(history1.toString());
        
        
        
        
        
       
        
        
        
    
}

    private static class Poduct extends Product {

        public Poduct() {
        }
    }
}
   
