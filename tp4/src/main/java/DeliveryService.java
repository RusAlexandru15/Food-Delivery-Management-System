import java.io.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.*;

import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class DeliveryService implements Serializable,IDeliveryServiceProcessing {
    private Set<Client> clients;
    private Set<MenuItem> menu;
    private Map<Order, List<MenuItem>> orders;
    private List<MenuItem> filter;
    Object[][] data;
    Object[] columns={"title","rating","calories","protein","fats","sodium","price"};
    private static String path="C:\\Users\\User\\OneDrive\\Desktop\\tp4\\src\\main\\resources\\seriaFile.bin";

    public DeliveryService(){
        clients=new HashSet<>();
        orders=new HashMap<>();
        menu=new HashSet<>();

        filter=new ArrayList<>();

        data=new Object[12380][7];
        deserialize();
    }

    public void addClient(Client cl){
        clients.add(cl);
        serialize();
    }



    public boolean checkLogClient(String name,String password){
        for(Client cl:clients)
            if(cl.getName().equals(name) && cl.getPassword().equals(password))
                return true;
        return false;
    }



    public  void serialize(){
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream wr = new ObjectOutputStream(fileOut);
            wr.writeObject(clients);
            wr.writeObject(menu);
            wr.writeObject(orders);
            wr.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void deserialize()
    {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream rd = new ObjectInputStream(fileIn);
            clients = (HashSet<Client>) rd.readObject();
            menu=(HashSet<MenuItem>) rd.readObject();
            orders=(HashMap<Order, List<MenuItem>>) rd.readObject();
            rd.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void importProducts() {
        int row = 0;
        FileOperator fOp=new FileOperator();

        Set<MenuItem> menu2=fOp.readFromFile();
        for(MenuItem mn:menu2)
              menu.add(mn);
        Iterator<MenuItem> it=menu.iterator();

        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof BaseProduct){
                data[row][0]=valueOf(obj.getTitle());
                data[row][1]=valueOf(((BaseProduct) obj).getRating());
                data[row][2]=valueOf(((BaseProduct) obj).getCalories());
                data[row][3]=valueOf(((BaseProduct) obj).getProtein());
                data[row][4]=valueOf(((BaseProduct) obj).getFats());
                data[row][5]=valueOf(((BaseProduct) obj).getSodium());
                data[row][6]=valueOf(((BaseProduct) obj).getPrice());
            }
            row++;
        }
    }

    @Override
    public void deleteProduct(String title) {
       for(MenuItem mn:menu)
           if(mn.getTitleString().equals(title))
           {
               menu.remove(mn);
               serialize();
               break;
           }
    }

    @Override
    public void addBaseProduct(String title,float rat,int cal,int prots,int fats,int sod,int price) {
        BaseProduct bProd=new BaseProduct(title,rat,cal,prots,fats,sod,price);
        menu.add(bProd);
       serialize();
    }

    @Override
    public void editBaseProduct(String title, float rat, int cal, int prots, int fats, int sod, int price) {
        for(MenuItem mn:menu)
            if( mn.getTitleString().equals(title)){
                    mn.setTitle(title);
                    ((BaseProduct) mn).setRating(rat);
                    ((BaseProduct) mn).setCalories(cal);
                    ((BaseProduct) mn).setProteins(prots);
                    ((BaseProduct) mn).setFats(fats);
                    ((BaseProduct) mn).setSodium(sod);
                    ((BaseProduct) mn).setPrice(price);
                break;
            }
        serialize();
    }

    public Object[][] getData() {
        Iterator<MenuItem> it=menu.iterator();
        data=new Object[12380][7];
        int row=0;
        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof BaseProduct){
                data[row][0]=valueOf(obj.getTitle());
                data[row][1]=valueOf(((BaseProduct) obj).getRating());
                data[row][2]=valueOf(((BaseProduct) obj).getCalories());
                data[row][3]=valueOf(((BaseProduct) obj).getProtein());
                data[row][4]=valueOf(((BaseProduct) obj).getFats());
                data[row][5]=valueOf(((BaseProduct) obj).getSodium());
                data[row][6]=valueOf(((BaseProduct) obj).getPrice());
                row++;
            }

        }
        return data;
    }
    public Object[][] getComposedData() {
        Iterator<MenuItem> it=menu.iterator();
        Object[][] data2=new Object[200][2];
        int row=0;
        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof CompositeProduct){
               data2[row][0] = valueOf(obj.getTitle());
                data2[row][1] = valueOf(((CompositeProduct) obj).getComposedTitle());
                row++;
            }
        }
        return data2;
    }


    public Object[] getColumnNames() {
        return columns;
    }


    public void addCompositeProduc(String text , ArrayList list){
        CompositeProduct cp=new CompositeProduct(text);
        cp.setList(list);
        cp.computePrice();
        menu.add(cp);
        serialize();
    }

    public void editComposedProduct(String title,String [] str)
    {
        for(MenuItem mn:menu)
            if(mn.getTitleString().equals(valueOf(title)))
            {
                if(mn instanceof  CompositeProduct) {
                    ((CompositeProduct) mn).resetProductList();
                    for (MenuItem mn2 : menu) {
                        if (mn2 instanceof BaseProduct) {
                            for (String s : str) {
                                if (mn2.getTitleString().equals(s)) {
                                    ((CompositeProduct) mn).addComposed((BaseProduct) mn2);

                                }
                            }
                        }
                        ((CompositeProduct) mn).computePrice();
                    }
                    break;
                }
            }
    }


    public void filterProducts(String title, Float rating, int calorie, int proteins, int fats, int sodium, int price) {
         filter=new ArrayList<>(menu);

        if(title.length()>0) {
            filter = menu.stream().filter(p -> p.getTitleString().contains(title)).collect(Collectors.toList());
        }
        if(rating!=-1) {
            filter=filter.stream().filter(p -> p.getRatingF()==rating).collect(Collectors.toList());
        }
        if(calorie!=-1) {

            filter=filter.stream().filter(p -> p.getCaloriesI()==calorie).collect(Collectors.toList());
        }
        if(proteins!=-1) {
            filter = filter.stream().filter(p -> p.getProteinI() == proteins).collect(Collectors.toList());

        }
        if(fats!=-1){
            filter = filter.stream().filter(p -> p.getFatI()==fats).collect(Collectors.toList());

        }
        if(sodium!=-1){
            filter = filter.stream().filter(p -> p.getSodiumI()==sodium).collect(Collectors.toList());

        }
        if(price!=-1){
            filter = filter.stream().filter(p -> p.getPriceI()==price).collect(Collectors.toList());

        }
    }


    public Object[][] getFilterBaseData() {
        Iterator<MenuItem> it=filter.iterator();
       Object[][] data2=new Object[12380][7];
        int row=0;
        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof BaseProduct){
                data2[row][0]=valueOf(obj.getTitle());
                data2[row][1]=valueOf(((BaseProduct) obj).getRating());
                data2[row][2]=valueOf(((BaseProduct) obj).getCalories());
                data2[row][3]=valueOf(((BaseProduct) obj).getProtein());
                data2[row][4]=valueOf(((BaseProduct) obj).getFats());
                data2[row][5]=valueOf(((BaseProduct) obj).getSodium());
                data2[row][6]=valueOf(((BaseProduct) obj).getPrice());
                row++;
            }

        }
        return data2;
    }

    public Object[][] getFilterComposedData() {
        Iterator<MenuItem> it=filter.iterator();
        Object[][] data2=new Object[200][3];
        int row=0;
        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof CompositeProduct){
                data2[row][0] = valueOf(obj.getTitle());
                data2[row][1] = valueOf(((CompositeProduct) obj).getComposedTitle());
                data2[row][2]=valueOf(((CompositeProduct) obj).getComposedPrice());
                row++;
            }
        }
        return data2;
    }
    public Object[][] getComposedClientData() {
        Iterator<MenuItem> it=menu.iterator();
        Object[][] data2=new Object[200][3];
        int row=0;
        while(it.hasNext()) {
            MenuItem obj = it.next();
            if (obj instanceof CompositeProduct){
                data2[row][0] = valueOf(obj.getTitle());
                data2[row][1] = valueOf(((CompositeProduct) obj).getComposedTitle());
                data2[row][2]=valueOf(((CompositeProduct) obj).getComposedPrice());
                row++;
            }
        }
        return data2;
    }

    public void takeOrder(String[] allProducts,int totalPrice,String clientName ){
        LocalDateTime now = LocalDateTime.now();
        List<MenuItem> items=new ArrayList<>();

        int id= orders.size();
        id++;
        Order ord=new Order(id,clientName,now.toLocalDate(),now.toLocalTime(),totalPrice);
        for(String st:allProducts) {
            items.add(menu.stream().filter(p -> p.getTitleString().equals(st)).findFirst().get());
        }
        orders.put(ord,items);
        serialize();
    }
    public void printAllOrders(){
        Set<Map.Entry<Order, List<MenuItem>>> entrySet = orders.entrySet();
        for(Map.Entry<Order, List<MenuItem>> entry:entrySet)
            System.out.println(entry.getKey());

    }
    //reports
    public String reportStartEndHour(LocalTime startHour, LocalTime endHour) {
        List<Order> ordersReport= orders.keySet().stream()
                .filter(date -> date.getTime().isBefore(endHour) && date.getTime().isAfter(startHour)).toList();
        String s=ordersReport.stream().map(Order::toString).reduce("",String::concat);
        String replace = s.replace("#", "\n");
        return replace;
    }

    public String reportProducts(int quant) {
        List<MenuItem> products=new ArrayList<>();
        orders.values().forEach(p -> products.addAll(new ArrayList<>(p)));
        List<MenuItem> menuItemList=menu.stream().filter(p -> products.stream().filter(op -> p.getTitleString().equals(op.getTitleString())).count() >= quant).collect(Collectors.toList());
        String s=menuItemList.stream().map(MenuItem::toString).reduce("",String::concat);
        String replace = s.replace("#", "\n");
        return replace;
    }

    public String  reportClients(int nrOrd,int value) {
        List<Client> clientsList=clients.stream().filter(client->
                orders.entrySet().stream()
                        .filter(o -> o.getKey().getClientName().equals(client.getName()) && o.getKey().getPrice()>=value )
                        .count() >= nrOrd).collect(Collectors.toList());
        return clientsList.stream().map(Client::toString).reduce("",String::concat);
    }

    public String reportDate(LocalDate date, int quant) {
        List<MenuItem> products=new ArrayList<>();
        orders.entrySet().stream()
                .filter(o -> o.getKey().getDate().equals(date))
                .forEach(p -> products.addAll(new ArrayList<>(p.getValue())));
        List<MenuItem> menuItemList=menu.stream().filter(p -> products.stream().filter(op -> p.getTitleString().equals(op.getTitleString())).count() >= quant).collect(Collectors.toList());
        String s= menuItemList.stream().map(MenuItem::toString).reduce("",String::concat);
        String replace = s.replace("#", "\n");
        return replace;
    }


}
