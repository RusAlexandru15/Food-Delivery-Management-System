import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Order implements Serializable {
    //private static  int count ;
    private int id;
    private String clientName;
    private LocalDate date;
    private LocalTime time;
    private int price;

    public Order(int id,String clName,  LocalDate orderDate, LocalTime orderTime,int pr) {
        this.id=id;
        date = orderDate;
        time = orderTime;
      clientName=clName;
      price=pr;

    }

    public boolean equals(Object o) {
        if(this==o) return true;

        Order ord=(Order) o;
        return this.id==ord.id && this.clientName.equals(ord.clientName);
    }

    public int hashCode() {
        int hash=15;
        hash=26*hash+ Objects.hashCode(this.id);
        return hash;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime(){
        return time;
    }

    public String toString(){

        String s= "ORDER "+id+" CLIENT "+clientName+" "+price+"$ "+date+" "+time;
        s=s.substring(0, s.length() - 13);
        s+="#";
        return s;
    }

    public String getClientName(){
        return clientName;
    }
    public int getPrice(){
        return price;
    }

}
