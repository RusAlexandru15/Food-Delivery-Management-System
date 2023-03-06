public class AdminControl {
    private Admin adm;
    private AdminGUI admGUI;
    private DeliveryService devServ;

    public AdminControl(Admin admin,DeliveryService devServ){

        this.adm=admin;
        this.devServ=devServ;
        devServ.serialize();
    }

    void start() {
        admGUI = new AdminGUI();
       // devServ=new DeliveryService();
        Initialize();
        admGUI.setVisible(true);
    }
    private void Initialize() {

        admGUI.setMyButtonActionListener5(e->{
            //refreshing table
            admGUI.setUpProductTable(devServ);
        });

        admGUI.setMyButtonActionListener7(e->{
            //search element
            admGUI.searchElement(admGUI.getFilterText());

        });

        admGUI.setMyButtonActionListener6(e->{

            admGUI.deleteRow(devServ);

        });
        admGUI.setMyButtonActionListener8(e->{
            admGUI.addBaseElement(devServ);
        });

        admGUI.setMyButtonActionListener9(e->{
            admGUI.refreshTable(devServ);
        });

        admGUI.setMyButtonActionListener10(e->{
            admGUI.baseProductEdit(devServ);
        });


        admGUI.setMyButtonActionListener11(e->{
            admGUI.addCompositeElement();

        });
        admGUI.setMyButtonActionListener12(e->{
            admGUI.refreshComposedTable(devServ);
        });

        admGUI.setMyButtonActionListener13(e->{
            admGUI.saveComposedProduct(devServ);
        });
        admGUI.setMyButtonActionListener14(e->{
            admGUI.deleteComposedRow(devServ);
        });
        admGUI.setMyButtonActionListener15(e->{
            admGUI.composedProductEdit(devServ);
        });

        admGUI.setMyButtonActionListener21(e->{
            admGUI.hourReport(devServ);
        });
        admGUI.setMyButtonActionListener22(e->{
            admGUI.productReport(devServ);
        });

        admGUI.setMyButtonActionListener23(e->{
              admGUI.clientsReport(devServ);
        });

        admGUI.setMyButtonActionListener24(e->{
            admGUI.dateReport(devServ);
        });

    }

}
