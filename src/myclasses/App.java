
package myclasses;

import entity.Buyer;
import entity.History;
import entity.Product;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/*  Реализация логики отслеживающей количество проданного товара в магазине  */

public class App {
    
   private Scanner scanner = new Scanner(System.in);
    //-----Данные библиотеки-----//
   private List<Product> products = new ArrayList<>();
   private List<Buyer> buyers = new ArrayList<>();
   private List<History> histories = new ArrayList<>();
     //-----Сохранение-----//
   private Keeping keeping = new KeeperToFile();
   
   public App(){
       products = keeping.loadProducts();
       buyers = keeping.loadBuyers();
       histories = keeping.loadHistories();
   }
    
    public void run() {  
       
        String repeat = "r";
        do{
            System.out.println("*** Выберите номер задачи: ***");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить товар");
            System.out.println("2: Список товаров");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список покупателей");
            System.out.println("5: Продажа товара покупателю");
            System.out.println("6: Оплата товара покупателем");
            System.out.println("7: Список проданных товаров");
            int task = scanner.nextInt(); scanner.nextLine();
            int n = 0;
            switch (task) {

                case 0:
                    repeat="q";
                    System.out.println("*** Пока! ***");
                    break;
                case 1:
                    System.out.println("*** Добавление товара ***");
                            products.add(addProduct());
                            keeping.saveProducts(products);
                            break;                     
                  
                case 2:
                    System.out.println("-------------------");
                    System.out.println("***  Список товара ***");
                    for(int i = 0; i < products.size(); i++) {
                        if(products.get(i) != null && products.get(i).getCount() > 0) {
                            System.out.println(products.get(i).toString());
                        }                        
                    }
                    System.out.println("-------------------");
                    break;
               
                 
                case 3:
                    System.out.println("*** Добавление покупателя ***");
                        buyers.add(addBuyer());
                        keeping.saveBuyers(buyers);
                           break;                                
                case 4:
                    System.out.println("-------------------");
                    System.out.println("*** Список покупателей ***");
                    for(int i = 0; i < buyers.size(); i++) {
                        if(buyers.get(i) != null) {
                            System.out.println(buyers.get(i).toString());
                        }
                    }                
                    System.out.println("-------------------");
                    break;
                case 5:
                         System.out.println("-------------------");
                    System.out.println("*** Продажа товара ***");
                        History history = addHistory(); 
                        
                        if (history == null) {
                            break;
                        }
                        history.getProduct().setCount(history.getProduct().getCount() - 1);
                        
                        keeping.saveProducts(products);
                        histories.add(history);
                        keeping.saveHistories(histories);
                         System.out.println("-------------------");
                            System.out.println("Товар: "+ history.getProduct().getProductName()
                                                + " Категория: " + history.getProduct().getProductGroup()
                                                + " Цена за еденицу: " + history.getProduct().getPrice() + "EUR"                                              
                                                + " Отпущен покупателю: " + history.getBuyer().getBuyername()
                                                + " Cтатус покупателя: " + history.getBuyer().getStatusname() );
                            System.out.println("-------------------");
                            break;
                case 6:
                    System.out.println("*** Оплата купленного товара ***");
                    System.out.println("*** Список неоплаченного товара: ***");
                    /*int n = 0;*/
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null 
                                && histories.get(i).getPaymentDate() == null 
                                    && histories.get(i).getProduct().getCount() 
                                    < histories.get(i).getProduct().getQuantity()){
                            System.out.println(i+1+". Товар "
                                    +histories.get(i).getProduct().getProductName()+"/n"
                                    +histories.get(i).getProduct().getProductGroup()+"/n"
                                    +" отпущен "+histories.get(i).getBuyer().getBuyername()+"/n"
                                    +" "+histories.get(i).getBuyer().getStatusname()
                            );
                            /*System.out.printf("%d. Товар \"%s\" купил %s %s%n"
                                    ,i+1
                                    ,histories.get(i).getProduct().getProductName()
                                    ,histories.get(i).getBuyer().getBuyername()
                                    ,histories.get(i).getBuyer().getStatusname()
                                    );*/
                            n++;
                        }
                    }
                    if(n < 1){                     
                        System.out.println("*** Нет неоплаченных товаров! ***");
                        System.out.println("-------------------");
                    break;
                    }
                    System.out.println("--------------------");
                    System.out.print("*** Выберите номер неоплаченного товара: ***");
                    int numberHistory = scanner.nextInt(); scanner.nextLine();
                    Calendar c = new GregorianCalendar();
                    histories.get(numberHistory - 1).setPaymentDate(c.getTime());
                    histories.get(numberHistory - 1).getProduct().setCount(
                         histories.get(numberHistory - 1).getProduct().getCount()+1);
                    keeping.saveProducts(products);
                    keeping.saveHistories(histories);
                   
                    System.out.println("*** Счет на покупку товара: ***"
                            +histories.get(numberHistory - 1).getProduct().getProductName()
                            +histories.get(numberHistory - 1).getProduct().getProductGroup()
                            +" оплачен"
                    );
                    System.out.println("-------------------");
                break;
                case 7:
                    System.out.println("-------------------");
                    System.out.println("*** Список неоплаченных товаров: ***");
                    
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i) != null && histories.get(i).getPaymentDate() == null){
                            System.out.println(i+1+". Товар "
                                    +histories.get(i).getProduct().getProductName()
                                    +" куплен "+histories.get(i).getBuyer().getBuyername()
                                    +" "+histories.get(i).getBuyer().getStatusname()
                            );
                            n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("*** Нет неоплаченных товаров! ***");
                        System.out.println("-------------------");
                        break;
                    }                    
                    break; 
                    
              
                default:
                    System.out.println("*** Выберите цифру из списка! ***");
            }
        }while("r".equals(repeat));
    }
    
    
    private Product addProduct() {
        Product product = new Product();
        System.out.println("* Введите название товара: *   ");  
        product.setProductName(scanner.nextLine());
        System.out.println("* Введите группу товара: *   ");
        product.setProductGroup(scanner.nextLine());
        System.out.println("* Введите количество товара: *   ");
        product.setQuantity((int) scanner.nextInt());scanner.nextLine();
        product.setCount(product.getQuantity());
        System.out.println("* Введите цену за еденицу товара: *   ");
        product.setPrice(scanner.nextInt());scanner.nextLine();
        return product;
        }
    
     private Buyer addBuyer() {
        Buyer buyer = new Buyer();
        System.out.println("* Введите имя покупателя: *   ");  
        buyer.setBuyername(scanner.nextLine());
        System.out.println("* Введите статус покупателя: *   ");
        buyer.setStatusname(scanner.nextLine());
        System.out.println("* Введите телефон покупателя: *   ");
        buyer.setPhone(scanner.nextLine());
        return buyer;
        }
     
     private History addHistory() {
        History history = new History();
        System.out.println("*** Список товаров: ***");
        System.out.println("-------------------");
        int n = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) != null && products.get(i).getCount()>0){
                /*StringBuilder sbAuthorNames = new StringBuilder();
                for (int j = 0; j < products[i].getAuthors().length; j++) {
                    sbAuthorNames.append(products[i].getAuthors()[j].getFirstname())
                                    .append(" ")
                                    .append(products[i].getProductName()[j].getProductGroup())
                                    .append(". ");
                }*/
                
                System.out.println(i+1
                        +" // товар: "+products.get(i).getProductName()
                        +" // группа товара: "+products.get(i).getProductGroup()
                        +" // кол-во полученного: "+products.get(i).getQuantity() + "шт"                        +" * цена за еденицу: "+products.get(i).getPrice()
                        +" // В наличии: " + products.get(i).getCount()+ "шт"                    
                );
                n++;
            }
        }
        if(n<1) {
            System.out.println("*** Нет товаров для продажи! ***");
            return history;
        }
        
        System.out.print("*** Выберите номер товара: ***");
        int numberProduct = scanner.nextInt(); scanner.nextLine();
        System.out.println("-------------------");
        System.out.println("*** Список покупателей: ***");
        for (int i = 0; i < buyers.size(); i++) {
            if(buyers.get(i) != null){
                System.out.println(i+1+". "+buyers.get(i).toString());
            }
        }
        System.out.print("*** Выберите номер покупателя: ***");
        int numberBuyer = scanner.nextInt(); scanner.nextLine();
        history.setProduct(products.get(numberProduct-1));
        history.setBuyer(buyers.get(numberBuyer-1));
        Calendar c = new GregorianCalendar();
        history.setPaymentDate(c.getTime());
        
        return history;
    }
   
}
    
 
