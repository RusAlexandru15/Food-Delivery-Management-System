public class LogInControl {
    private LogInGUI logGUI;
    private DeliveryService devServ;



    void start() {
        logGUI = new LogInGUI();
        devServ=new DeliveryService();
        Initialize();
        logGUI.setVisible(true);
        devServ.serialize();
    }

    private void Initialize() {

        logGUI.setMyButtonActionListener1(e->{
              //log in client
            String clName= logGUI.getClientLogName();
            String clPass=logGUI.getClientLogPass();
           if(devServ.checkLogClient(clName,clPass))
           {
               //start the GUI
               ClientControl clCon=new ClientControl(new Client(clName,clPass),devServ);
               clCon.start();

               logGUI.setResultLabel("Welcome!");
           }
           else
               logGUI.setResultLabel("Wrong name or password");
           logGUI.resetAllText();

        });
        logGUI.setMyButtonActionListener2(e->{
            //register client
            String clName= logGUI.getClientRegName();
            String clPass1=logGUI.getClientRegPass1();
            String clPass2=logGUI.getClientRegPass2();

            if(clName.length()!=0 && clPass1.length()!=0 && clPass1.equals(clPass2) ) {
                //start the GUI
                devServ.addClient(new Client(clName,clPass1));

                logGUI.setResultLabel("Client registered!");
            }
            else
                logGUI.setResultLabel("invalid input!");
            logGUI.resetAllText();

        });

        logGUI.setMyButtonActionListener3(e->{
             //log admin
            String name= logGUI.getAdminLogName();
            String pass=logGUI.getAdminLogPass();
            if(name.equals("alex") && pass.equals("0000")) {
                logGUI.setResultLabel("Welcome!");
                //open the adminGUI with specified admin
                AdminControl admCon=new AdminControl(new Admin("alex","0000"),devServ);
                admCon.start();
            }
            else
                logGUI.setResultLabel("Wrong name or password");
            logGUI.resetAllText();
        });

    }
}
