import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable {
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;

    public BaseProduct(String title,float rating,int calories,int proteins,int fats,int sodium,int price){
        super(title);
        this.rating=rating;
        this.calories=calories;
        this.proteins=proteins;
        this.fats=fats;
        this.sodium=sodium;
        this.price=price;
    }

    public String toString(){
        return super.toString()+" "+rating+"#";
    }



    public Object getRating() {
        return rating;
    }

    public Object getCalories() {
        return calories;
    }
    public Object getProtein() {
        return proteins;
    }
    public Object getFats() {
        return fats;
    }
    public Object getSodium() {
        return sodium;
    }
    public Object getPrice(){
        return price;
    }
    public void setRating(float rat){
        rating=rat;
  }
    public void setCalories(int cal){
        calories=cal;
  }
    public void setProteins(int prots){
        proteins=prots;
    }
    public void setFats(int fat){
        fats=fat;
 }
    public void setSodium(int sod){
        sodium=sod;
 }
    public void setPrice(int pr){
        price=pr;
 }


    public float getRatingF() {
        return rating;
    }

    public int getCaloriesI() {
        return calories;
    }

    public int getProteinI() {
        return proteins;
    }

    public int getFatI() {
        return fats;
    }

    public int getSodiumI() {
        return sodium;
    }

    public int getPriceI() {
        return price;
    }

}
