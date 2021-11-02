
package interfaces;

import entity.Buyer;
import entity.History;
import entity.Product;
import java.util.List;


public interface Keeping {
    public void saveProducts(List<Product> products);
    public List<Product> loadProducts();
    public void saveBuyers(List<Buyer> buyers);
    public List<Buyer> loadBuyers();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
    
}
