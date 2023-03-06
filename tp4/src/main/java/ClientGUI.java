import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientGUI extends JFrame {

    private final JLabel titleLabel;
    private  JLabel clientNameLabel;
    private JTable table;
    private JTable table2;
    private JScrollPane sr;
    private JScrollPane sr2;
    private JButton viewButton;
    private JLabel clLabel;

 //search functionality
 private final JLabel baseProductLabel;

    private final JLabel productTitleLabel;
    private JTextField productTitleField ;

    private final JLabel ratingLabel;
    private JTextField ratingField ;
    private final JLabel fatLabel;
    private JTextField fatField ;
    private final JLabel caloriesLabel;
    private JTextField caloriesField ;

    private final JLabel sodiumLabel;
    private JTextField sodiumField ;

    private final JLabel proteinLabel;
    private JTextField proteinField ;


    private final JLabel priceLabel;
    private JTextField priceField ;

    private JButton searchButton;
    private JButton  clearFilterButton;

    //orders
    private JTextField orderField;
    private JTextField priceOrderField;
    private JLabel orderLabel;
    private JButton addButton;
    private JButton orderButton;
    private List<String> tempList;
    private int totalPrice;


    public ClientGUI(){
        this.setBounds(30, 30, 1500, 1100);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tempList=new ArrayList<>();
        totalPrice=0;

        titleLabel = new JLabel("FOOD DELIVERY");
        titleLabel.setBounds(600, 30, 100, 56);
        getContentPane().add(titleLabel);

        clientNameLabel = new JLabel();
        clientNameLabel.setBounds(1200, 30, 100, 56);
        getContentPane().add(clientNameLabel);

        clLabel = new JLabel("CLIENT");
        clLabel.setBounds(1150, 30, 100, 56);
        getContentPane().add(clLabel);


        viewButton = new JButton("MENU");
        viewButton.setBounds(60,160,100,30);
        getContentPane().add( viewButton);


        //search functionality
        baseProductLabel = new JLabel("FILTER");
        baseProductLabel.setBounds(940, 70, 200, 30);
        getContentPane().add(baseProductLabel);

        productTitleLabel = new JLabel("TITLE:");
        productTitleLabel.setBounds(869, 110, 70, 30);
        getContentPane().add(productTitleLabel);

        productTitleField = new JTextField("");
        productTitleField.setBounds(910, 110, 100, 30);
        getContentPane().add(productTitleField);


        ratingLabel = new JLabel("RATING:");
        ratingLabel.setBounds(850, 150, 70, 30);
        getContentPane().add(ratingLabel);

        ratingField = new JTextField("");
        ratingField.setBounds(910, 150, 60, 30);
        getContentPane().add(ratingField);

        fatLabel = new JLabel("FATS:");
        fatLabel.setBounds(1005, 150, 50, 30);
        getContentPane().add(fatLabel);

        fatField = new JTextField("");
        fatField.setBounds(1055, 150, 60, 30);
        getContentPane().add(fatField);

        caloriesLabel = new JLabel("CALORIES:");
        caloriesLabel.setBounds(840, 190, 70, 30);
        getContentPane().add(caloriesLabel);

        caloriesField = new JTextField("");
        caloriesField.setBounds(910, 190, 60, 30);
        getContentPane().add(caloriesField);

        sodiumLabel = new JLabel("SODIUM:");
        sodiumLabel.setBounds(1000, 190, 90, 30);
        getContentPane().add(sodiumLabel);

        sodiumField = new JTextField("");
        sodiumField.setBounds(1055, 190, 60, 30);
        getContentPane().add(sodiumField);


        proteinLabel = new JLabel("PROTEIN:");
        proteinLabel.setBounds(840, 230, 70, 30);
        getContentPane().add(proteinLabel);

        proteinField = new JTextField("");
        proteinField.setBounds(910, 230, 60, 30);
        getContentPane().add(proteinField);

        priceLabel = new JLabel("PRICE:");
        priceLabel.setBounds(1000, 230, 90, 30);
        getContentPane().add(priceLabel);

        priceField = new JTextField("");
        priceField.setBounds(1055, 230, 60, 30);
        getContentPane().add(priceField);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(850,270,100,30);
        getContentPane().add( searchButton);

        clearFilterButton=new JButton("CLEAR");
        clearFilterButton.setBounds(970,270,100,30);
        getContentPane().add( clearFilterButton);

        //order
        orderField = new JTextField("");
        orderField.setBounds(900, 340, 440, 30);
        getContentPane().add(orderField);

        priceOrderField = new JTextField("");
        priceOrderField.setBounds(1350, 340, 50, 30);
        getContentPane().add(priceOrderField);

        orderLabel =new JLabel("order");
        orderLabel.setBounds(850,340,60,30);
        getContentPane().add(orderLabel);

        addButton = new JButton("ADD");
        addButton.setBounds(900,380,100,30);
        getContentPane().add( addButton);

        orderButton = new JButton("ORDER");
        orderButton.setBounds(1010,380,100,30);
        getContentPane().add( orderButton);



    }

    public void setMyButtonActionListener16( ActionListener actionListener)
    {
        viewButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener17( ActionListener actionListener)
    {
        searchButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener18( ActionListener actionListener)
    {
        clearFilterButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener19( ActionListener actionListener)
    {
        addButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener20( ActionListener actionListener)
    {
        orderButton.addActionListener(actionListener);
    }


    public void setClientNameLabel(String text) {

        clientNameLabel.setText(text);
    }

    public void viewTables(DeliveryService dev){

        Object[] columns={"title","elements","price"};

        if(sr != null)
            getContentPane().remove(sr);
        table=new JTable(dev.getData(), dev.getColumnNames());
        sr=new JScrollPane(table);
        sr.setBounds(180,75,600,400);
        getContentPane().add(sr);

        if(sr2!=null)
            getContentPane().remove(sr2);
        table2=new JTable(dev.getComposedClientData(), columns);
        sr2=new JScrollPane(table2);
        sr2.setBounds(180,500,600,200);

        getContentPane().add(sr2);

    }

    public void searchTables(DeliveryService dev) {
        Object[] columns={"title","elements","price"};
        float rating=-1;
        int calories=-1,protein=-1,fat=-1,sodium=-1,price=-1;
        String title=productTitleField.getText();
        if(ratingField.getText().length()>0)
            rating = Float.parseFloat(ratingField.getText());
        if(caloriesField.getText().length()>0)
           calories = Integer.parseInt(caloriesField.getText());
        if(proteinField.getText().length()>0)
           protein = Integer.parseInt(proteinField.getText());
        if(fatField.getText().length()>0)
           fat = Integer.parseInt(fatField.getText());
        if(sodiumField.getText().length()>0)
           sodium = Integer.parseInt(sodiumField.getText());
        if(priceField.getText().length()>0)
           price = Integer.parseInt(priceField.getText());



        dev.filterProducts(title,rating,calories,protein,fat,sodium,price);

        if(sr != null)
            getContentPane().remove(sr);
        table=new JTable(dev.getFilterBaseData(), dev.getColumnNames());
        sr=new JScrollPane(table);
        sr.setBounds(180,75,600,400);
        getContentPane().add(sr);

        if(sr2!=null)
            getContentPane().remove(sr2);
        table2=new JTable(dev.getFilterComposedData(), columns);
        sr2=new JScrollPane(table2);
        sr2.setBounds(180,500,600,200);
        getContentPane().add(sr2);
    }

    public void clearFilters() {
        productTitleField.setText("");
        ratingField.setText("");
        caloriesField.setText("");
        proteinField.setText("");
        fatField.setText("");
        sodiumField.setText("");
        priceField.setText("");
    }

    public void addProductOrder()
    {
        int row2 = table2.getSelectedRow();
        int row=table.getSelectedRow();

        String title="";
        String text="";
        if(row!=-1) {
            title = table.getModel().getValueAt(row, 0).toString()+"#";
            tempList.add(title);
            int priceAdd = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());
            totalPrice+=priceAdd;
        }
        if(row2!=-1){
            title = title+table2.getModel().getValueAt(row2, 0).toString()+"#";
            tempList.add(title);
            int priceAdd = Integer.parseInt(table2.getModel().getValueAt(row2, 2).toString());
            totalPrice+=priceAdd;

        }
        for(String t:tempList)
            text=text+t;
        if(text.length()>0) {
            StringBuffer sb = new StringBuffer(text); //sterge ultimul caracter
            sb.deleteCharAt(sb.length() - 1);
           orderField.setText(String.valueOf(sb));
           priceOrderField.setText(String.valueOf(totalPrice));
        }
        table.getSelectionModel().clearSelection();//CLEARS THE SELECTED ROW
        table2.getSelectionModel().clearSelection();
    }

    public void makeOrder(DeliveryService devServ){
        String textTotal="";
        if(orderField.getText().length()>0) {
            for (String st : tempList)
                textTotal = textTotal + st;
            String[] allTitles = textTotal.split("#");
            devServ.takeOrder(allTitles, totalPrice, clientNameLabel.getText());

            orderField.setText("");
            priceOrderField.setText("");
            tempList = new ArrayList<>();
            totalPrice = 0;
        }

    }

}
