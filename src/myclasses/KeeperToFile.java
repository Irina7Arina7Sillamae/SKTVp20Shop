
package myclasses;

import entity.Buyer;
import entity.History;
import entity.Product;
import interfases.Keeping;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KeeperToFile implements Keeping{

    @Override
    public void saveProducts(List<Product> products) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("products");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override
    public List<Product> loadProducts() {
        FileInputStream fis = null;
         ObjectInputStream ois = null;
        List<Product> products = new ArrayList<>();         
        try {
            fis = new FileInputStream("products");
            ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Файл books еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Ошибка чтения books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Нет класса", ex);
        }
        return products;
    }
    

    @Override
    public void saveBuyers(List<Buyer> buyers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("buyers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buyers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<Buyer> loadBuyers() {
        FileInputStream fis = null;
         ObjectInputStream ois = null;
        List<Buyer> buyers = new ArrayList<>();         
        try {
            fis = new FileInputStream("buyers");
            ois = new ObjectInputStream(fis);
            buyers = (List<Buyer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Файл books еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Ошибка чтения books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Нет класса", ex);
        }
        return buyers;
    }

    @Override
     public void saveHistories(List<History> histories) {
      FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("histories");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }
    

    @Override
    public List<History> loadHistories() {
       FileInputStream fis = null;
         ObjectInputStream ois = null;
        List<History> histories = new ArrayList<>();         
        try {
            fis = new FileInputStream("histories");
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Файл books еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Ошибка чтения books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KeeperToFile.class.getName()).log(Level.SEVERE, "Нет класса", ex);
        }
        return histories;
    }

    
}
