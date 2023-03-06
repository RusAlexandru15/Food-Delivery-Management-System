import java.io.Serializable;
import java.util.Objects;

public   class MenuItem implements Serializable {
    private int hash;
    private String title;


    public MenuItem (String title){
        this.title=title;
        hash=this.hashCode();
    }


    public int hashCode() {
        int hash=5;
        hash=23*hash+ Objects.hashCode(this.title);
        return hash;
    }

    public boolean equals(Object o) {
        if(this==o) return true;

        MenuItem mi=(MenuItem) o;
        return this.title.equals(mi.title);
    }

    public String toString(){
        if(this instanceof BaseProduct)
        return title+" (base product)";
        else
            return "(composed product)";
    }

    public Object getTitle() {
        return title;
    }

    public String getTitleString(){
        return title;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }


    public float getRatingF() {
        return -1;
    }

    public int getCaloriesI() {
        return -1;
    }

    public int getProteinI() {
        return -1;
    }

    public int getFatI() {
        return -1;
    }

    public int getSodiumI() {
        return -1;
    }

    public int getPriceI() {
        return -1;
    }
}
