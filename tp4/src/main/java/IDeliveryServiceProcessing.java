import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface IDeliveryServiceProcessing {
    public  void importProducts();
    public void deleteProduct(String title);
    public void addBaseProduct(String title,float rat,int cal,int prots,int fats,int sod,int price);
    public void editBaseProduct(String title,float rat,int cal,int prots,int fats,int sod,int price);

    public void addCompositeProduc(String text , ArrayList list);
    public void editComposedProduct(String title,String [] str);
    public void filterProducts(String title, Float rating, int calorie, int proteins, int fats, int sodium, int price);
    public void takeOrder(String[] allProducts,int totalPrice,String clientName );

    public String reportStartEndHour(LocalTime startHour, LocalTime endHour);
    public String reportProducts(int quant);
    public String  reportClients(int nrOrd,int value);
    public String reportDate(LocalDate date, int quant);
}
