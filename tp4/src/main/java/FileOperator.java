import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileOperator {
    private FileWriter myWriter;
    private  BufferedReader myReader;
    private static String path="C:\\Users\\User\\OneDrive\\Desktop\\tp4\\src\\main\\resources\\products.csv";

    public FileOperator() {
        try {
            myWriter = new FileWriter("Reports.txt");
            myReader=new BufferedReader(new java.io.FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public Set<MenuItem> readFromFile(){
        String outLine;
        Set<MenuItem> baseMenu=new HashSet<>();
        try {
            myReader.readLine(); //first line
            while ((outLine = myReader.readLine()) != null) {
                String[] fields = outLine.split(",");
                BaseProduct product = new BaseProduct(fields[0], Float.parseFloat(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                        Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
                baseMenu.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         return baseMenu;
     }


    public void textWrite(String s) {
        try {
            myWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
