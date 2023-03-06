import javax.swing.*;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



import static javax.swing.JOptionPane.showMessageDialog;

public class AdminGUI extends JFrame {

    private final JLabel titleLabel;
    private JButton importButton;
    private JButton refreshButton;
    private JTextField textFilter ;

    private JTable table;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton addButton;
    private JButton editButton;
    private JScrollPane sr;

    //adding new base product
    private final JLabel baseProductLabel;
    private final JLabel baseTitleLabel;
    private JTextField baseTitleField ;
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
    private final JLabel baseLabel;

    private final JLabel priceLabel;
    private JTextField priceField ;
    private static int pushed;


    //composite
    private JLabel compositeLabel;
    private JButton addComposedButton;
    private JButton  refreshComposedButton;
    private JTable table2;
    private JScrollPane sr2;
    private JTextField saveField ;
    private JButton saveComposedButton;
    private JButton deleteComposedButton;
    private JButton editComposedButton;

    //reports
    private  JLabel reportsLabel;
    private JLabel sHourLabel;
    private JTextField  sHourField;
    private JLabel eHourLabel;
    private JTextField  eHourField;
    private JButton repButton1;
    private JLabel timesLabel;
    private JTextField nrOrdField;
    private JButton repButton2;

    private JLabel clRepLabel;
    private JTextField clRepField;
    private JLabel valRepLabel;
    private JTextField valRepField;
    private JButton repButton3;

    private JLabel prRepLabel;
    private JTextField prRepField;
    private JLabel dateRepLabel;
    private JTextField dateRepField;
    private JButton repButton4;

    //file writer
    FileOperator file;


    private List<MenuItem> temporaryList;

    public AdminGUI(){
        this.setBounds(30, 30, 1500, 1100);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);


        temporaryList=new ArrayList<>();

        titleLabel = new JLabel("ADMINISTRATOR");
        titleLabel.setBounds(535, 30, 100, 56);
        getContentPane().add(titleLabel);

        baseLabel=new JLabel("base");
        baseLabel.setBounds(80,125,35,36);
        getContentPane().add( baseLabel);

        importButton = new JButton("IMPORT");
        importButton.setBounds(60,160,100,30);
        getContentPane().add( importButton);

        textFilter=new JTextField();
        textFilter.setBounds(60,230,100,30);
        getContentPane().add( textFilter);


        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(60,330,100,30);
        getContentPane().add( deleteButton);

        refreshButton = new JButton("REFRESH");
        refreshButton.setBounds(60,370,100,30);
        getContentPane().add( refreshButton);

        editButton = new JButton("EDIT");
        editButton.setBounds(60,410,100,30);
        getContentPane().add( editButton);



        searchButton = new JButton("SEARCH");
        searchButton.setBounds(60,275,100,30);
        getContentPane().add( searchButton);

        //adding new simple baseproduct
        baseProductLabel = new JLabel("NEW BASE PRODUCT");
        baseProductLabel.setBounds(940, 70, 200, 30);
        getContentPane().add(baseProductLabel);

        baseTitleLabel = new JLabel("TITLE:");
        baseTitleLabel.setBounds(869, 110, 70, 30);
        getContentPane().add(baseTitleLabel);

        baseTitleField = new JTextField("");
        baseTitleField.setBounds(910, 110, 100, 30);
        getContentPane().add(baseTitleField);


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

        addButton = new JButton("ADD");
        addButton.setBounds(940,275,100,30);
        getContentPane().add( addButton);
        pushed=0;

        //composed products

        compositeLabel = new JLabel("compose");
        compositeLabel.setBounds(75,460,70,30);
        getContentPane().add( compositeLabel);

        addComposedButton = new JButton("ADD");
        addComposedButton.setBounds(60,500,100,30);
        getContentPane().add( addComposedButton);

        refreshComposedButton = new JButton("REFRESH");
        refreshComposedButton.setBounds(60,540,100,30);
        getContentPane().add( refreshComposedButton);

        saveField=new JTextField();
        saveField.setBounds(60,580,100,30);
        getContentPane().add( saveField);

        saveComposedButton = new JButton("SAVE");
        saveComposedButton.setBounds(60,620,100,30);
        getContentPane().add( saveComposedButton);

        deleteComposedButton = new JButton("DELETE");
        deleteComposedButton.setBounds(60,655,100,30);
        getContentPane().add( deleteComposedButton);

        editComposedButton = new JButton("EDIT");
        editComposedButton.setBounds(60,690,100,30);
        getContentPane().add( editComposedButton);

        //reports
        reportsLabel = new JLabel("REPORTS");
        reportsLabel.setBounds(1220, 10, 70, 30);
        getContentPane().add(reportsLabel);


        sHourLabel = new JLabel("Star Hour:");
        sHourLabel.setBounds(1130, 40, 70, 30);
        getContentPane().add(sHourLabel);

        sHourField = new JTextField("");
        sHourField.setBounds(1200, 40, 60, 30);
        getContentPane().add(sHourField);

        eHourLabel = new JLabel("End Hour:");
        eHourLabel.setBounds(1130, 80, 70, 30);
        getContentPane().add(eHourLabel);

        eHourField = new JTextField("");
        eHourField.setBounds(1200, 80, 60, 30);
        getContentPane().add(eHourField);

        repButton1 = new JButton("HOUR");
        repButton1.setBounds(1270,40,100,30);
        getContentPane().add( repButton1);

        timesLabel = new JLabel("Nr prod:");
        timesLabel.setBounds(1145, 135, 70, 30);
        getContentPane().add(timesLabel);

        nrOrdField = new JTextField("");
        nrOrdField.setBounds(1200, 135, 60, 30);
        getContentPane().add(nrOrdField);

        repButton2 = new JButton("PRODUCT");
        repButton2.setBounds(1270,135,100,30);
        getContentPane().add( repButton2);



        clRepLabel = new JLabel("Cleints:");
        clRepLabel.setBounds(1140, 180, 70, 30);
        getContentPane().add(clRepLabel);

        clRepField = new JTextField("");
        clRepField.setBounds(1200, 180, 60, 30);
        getContentPane().add(clRepField);

        valRepLabel = new JLabel("Amount:");
        valRepLabel.setBounds(1140, 220, 70, 30);
        getContentPane().add(valRepLabel);

        valRepField = new JTextField("");
        valRepField.setBounds(1200, 220, 60, 30);
        getContentPane().add(valRepField);

        repButton3 = new JButton("CLIENTS");
        repButton3.setBounds(1270,180,100,30);
        getContentPane().add( repButton3);


        prRepLabel = new JLabel("Products:");
        prRepLabel.setBounds(1140, 260, 70, 30);
        getContentPane().add(prRepLabel);

        prRepField = new JTextField("");
        prRepField.setBounds(1200, 260, 60, 30);
        getContentPane().add(prRepField);

        dateRepLabel = new JLabel("Date:");
        dateRepLabel.setBounds(1140, 300, 70, 30);
        getContentPane().add(dateRepLabel);

        dateRepField = new JTextField("");
        dateRepField.setBounds(1200, 300, 60, 30);
        getContentPane().add(dateRepField);

        repButton4 = new JButton("DATE");
        repButton4.setBounds(1290,260,100,30);
        getContentPane().add( repButton4);



    }

    public void setUpProductTable(DeliveryService dev){

        if(pushed==0) {
            dev.importProducts();
            table = new JTable(dev.getData(), dev.getColumnNames());
            sr = new JScrollPane(table);
            sr.setBounds(180, 75, 600, 600);
            getContentPane().add(sr);
            pushed=1;
        }

    }

    public String getFilterText() {
        return textFilter.getText();
    }

    public void setMyButtonActionListener5( ActionListener actionListener)
    {
        importButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener6( ActionListener actionListener)
    {
        deleteButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener7( ActionListener actionListener)
    {
        searchButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener8( ActionListener actionListener)
    {
        addButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener9( ActionListener actionListener)
    {
        refreshButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener10( ActionListener actionListener)
    {
        editButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener11( ActionListener actionListener)
    {
        addComposedButton.addActionListener(actionListener);
    }

    public void setMyButtonActionListener12( ActionListener actionListener)
    {
        refreshComposedButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener13( ActionListener actionListener)
    {
        saveComposedButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener14( ActionListener actionListener)
    {
        deleteComposedButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener15( ActionListener actionListener)
    {
        editComposedButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener21( ActionListener actionListener)
    {
        repButton1.addActionListener(actionListener);
    }
    public void setMyButtonActionListener22( ActionListener actionListener)
    {
        repButton2.addActionListener(actionListener);
    }
    public void setMyButtonActionListener23( ActionListener actionListener)
    {
        repButton3.addActionListener(actionListener);
    }
    public void setMyButtonActionListener24( ActionListener actionListener)
    {
        repButton4.addActionListener(actionListener);
    }



    public void deleteRow(DeliveryService dev){
        int column = 0;
        int row = table.getSelectedRow();

        if(row==-1)
              showMessageDialog(null, "Select a row !");
        else {
            String value = table.getModel().getValueAt(row, column).toString();
            dev.deleteProduct(value);

            getContentPane().remove(sr);
            table=new JTable(dev.getData(), dev.getColumnNames());
            sr=new JScrollPane(table);
            sr.setBounds(180,75,600,600);
            getContentPane().add(sr);

        }
    }

    public void searchElement(String text) {
        if (table != null) {
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(rowSorter);
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }
    }

    public void addBaseElement(DeliveryService dev) {
        String title= baseTitleField.getText();
        float rating=0;
        int calories=0,protein=0,fat=0,sodium=0,price=0;
         if(title.length()!=0) {

             try {
                  rating = Float.parseFloat(ratingField.getText());
                  calories = Integer.parseInt(caloriesField.getText());
                  protein = Integer.parseInt(proteinField.getText());
                  fat = Integer.parseInt(fatField.getText());
                  sodium = Integer.parseInt(sodiumField.getText());
                  price = Integer.parseInt(priceField.getText());
                 dev.addBaseProduct(title,rating,calories,protein,fat,sodium,price);
                 showMessageDialog(null, "base product added!");

             }
             catch (NumberFormatException ex){
                 showMessageDialog(null, "invalid or emptys input!");
             }

         }
         else
             showMessageDialog(null, "empty title field!");
    }

    public void refreshTable(DeliveryService dev){

            getContentPane().remove(sr);
            table=new JTable(dev.getData(), dev.getColumnNames());
            sr=new JScrollPane(table);
            sr.setBounds(180,75,600,600);
            getContentPane().add(sr);
    }


    public void baseProductEdit(DeliveryService dev) {
        int row = table.getSelectedRow();
        if(row!=-1) {
            String title = table.getModel().getValueAt(row, 0).toString();
            float rating = Float.parseFloat(table.getModel().getValueAt(row, 1).toString());
            int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
            int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
            int fats = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
            int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
            int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());
            dev.editBaseProduct(title, rating, calories, proteins, fats, sodium, price);
        }
    }

    public void refreshComposedTable(DeliveryService dev){
        Object[] columns={"title","elements"};
        if(sr2!=null)
           getContentPane().remove(sr2);
        table2=new JTable(dev.getComposedData(), columns);
        sr2=new JScrollPane(table2);
        sr2.setBounds(850,380,600,300);
        getContentPane().add(sr2);
    }

    public void addCompositeElement(){
        int row = table.getSelectedRow();
        if(row!=-1) {
            String title = table.getModel().getValueAt(row, 0).toString();
            float rating = Float.parseFloat(table.getModel().getValueAt(row, 1).toString());
            int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
            int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
            int fats = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
            int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
            int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());
          temporaryList.add(new BaseProduct(title,rating,calories,proteins,fats,sodium,price));
            table.getSelectionModel().clearSelection();//CLEARS THE SELECTED ROW
        }
    }

    public void saveComposedProduct(DeliveryService devServ) {
        if(temporaryList.size()!=0 && saveField.getText().length()!=0){
            devServ.addCompositeProduc(saveField.getText(), (ArrayList) temporaryList);
            showMessageDialog(null, "Composed product added !");
        }
        temporaryList=new ArrayList<>();
        saveField.setText("");
        table.getSelectionModel().clearSelection();
    }

    public void deleteComposedRow(DeliveryService dev){
        int column = 0;
        int row = table2.getSelectedRow();
        Object[] columns={"title","elements"};
        if(row==-1)
            showMessageDialog(null, "Select a row !");
        else {
            String value = table2.getModel().getValueAt(row, column).toString();
            dev.deleteProduct(value);

            getContentPane().remove(sr2);
            table2=new JTable(dev.getComposedData(), columns);
            sr2=new JScrollPane(table2);
            sr2.setBounds(850,380,600,300);
            getContentPane().add(sr2);
        }
    }

    public void composedProductEdit(DeliveryService dev) {
        int row2 = table2.getSelectedRow();
        int row=table.getSelectedRow();
        String compositeTitle="",title="";
        if(row2!=-1) {
            title = table2.getModel().getValueAt(row2, 0).toString();
             compositeTitle = table2.getModel().getValueAt(row2, 1).toString();
            if(row!=-1){
                compositeTitle=compositeTitle+"#"+table.getModel().getValueAt(row, 0).toString();
            }
        }
        table.getSelectionModel().clearSelection();//CLEARS THE SELECTED ROW
        String[]  allTitles= compositeTitle.split("#");
        dev.editComposedProduct(title,allTitles);
    }
    //reports
  public void hourReport(DeliveryService dev){
        String s="Hour report:\n";

        int startHour= Integer.parseInt(sHourField.getText());
        int endHour= Integer.parseInt(eHourField.getText());
      LocalTime startTime = LocalTime.of(startHour, 0, 0, 0);
      LocalTime endTime = LocalTime.of(endHour, 0, 0, 0);
       s=s+dev.reportStartEndHour(startTime,endTime);
      System.out.println(s);
      file=new FileOperator();
      file.textWrite(s);
      file.closeFile();


  }
  public void productReport(DeliveryService dev){
      String s="Products report:\n";
      int quant=Integer.parseInt(nrOrdField.getText());
      s=s+ dev.reportProducts(quant);
      System.out.println(s);
      file=new FileOperator();
      file.textWrite(s);
      file.closeFile();
  }

  public void clientsReport(DeliveryService dev){
      String s="Clients report:\n";
      int nrClients= Integer.parseInt(clRepField.getText());
      int value= Integer.parseInt(valRepField.getText());
      s=s+dev.reportClients(nrClients,value);
      System.out.println(s);
      file=new FileOperator();
      file.textWrite(s);
      file.closeFile();
  }

  public void dateReport(DeliveryService dev){
      String s="Date report:\n";
      int quant= Integer.parseInt(prRepField.getText());
      String input=dateRepField.getText();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
      LocalDate date = LocalDate. parse(input, dateFormat);
      s=s+dev.reportDate(date,quant);
      System.out.println(s);
      file=new FileOperator();
      file.textWrite(s);
      file.closeFile();
  }

}
