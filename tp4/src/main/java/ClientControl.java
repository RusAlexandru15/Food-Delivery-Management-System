public class ClientControl {
    private Client client;
    private ClientGUI clGUI;
    private DeliveryService devServ;

    public ClientControl(Client cl,DeliveryService devServ){
        this.client=cl;
        this.devServ=devServ;
        devServ.serialize();
    }

    void start() {
        // devServ=new DeliveryService();
        clGUI = new ClientGUI();

        Initialize();
        clGUI.setVisible(true);
    }

    private void Initialize() {

        clGUI.setClientNameLabel(client.getName());//??
        clGUI.setMyButtonActionListener16(e->{
            //refreshing table
            clGUI.viewTables(devServ);
        });

        clGUI.setMyButtonActionListener17(e->{
            //search from table
            clGUI.searchTables(devServ);
        });

        clGUI.setMyButtonActionListener18(e->{

            clGUI.clearFilters();
        });

        clGUI.setMyButtonActionListener19(e->{
           //add desired products to a list
            clGUI.addProductOrder();
        });

        clGUI.setMyButtonActionListener20(e->{
            clGUI.makeOrder(devServ);
            devServ.printAllOrders();
        });

    }

}
