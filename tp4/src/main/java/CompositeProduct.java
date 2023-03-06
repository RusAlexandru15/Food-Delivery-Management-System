import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct  extends MenuItem implements Serializable {
     List<BaseProduct> productList;
     int compPrice;

    public CompositeProduct(String title) {
        super(title);
        productList=new ArrayList<>();
    }


    public Object getComposedTitle(){
        String s="";
        for(BaseProduct mn:productList)
            s+=mn.getTitleString()+"#";

        StringBuffer sb= new StringBuffer(s); //sterge ultimul caracter
        sb.deleteCharAt(sb.length()-1);
        return sb;
    }

    public String toString(){
        return "meniu compus "+this.getTitleString()+"#";
    }

    @Override
    public float getRatingF() {
        return -1;
    }

    public void setList(List list) {
        this.productList=list;
    }


    public void resetProductList() {
        productList=new ArrayList<>();
    }
    public void addComposed(BaseProduct b)
    {
        productList.add(b);
    }

    public void computePrice()
    {
        for(BaseProduct b:productList)
            compPrice+=b.getPriceI();
    }
    public Object getComposedPrice()
    {
        return compPrice;
    }

}
