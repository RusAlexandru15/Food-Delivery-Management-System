import javax.swing.*;
import java.awt.event.ActionListener;

public class LogInGUI extends JFrame {

    private final JLabel adminLabel;
    private final JButton logAdminButton;
    private final JPasswordField adminPasswordText;
    private final JLabel adminNameLabel;
    private final JTextField adminNameText;
    private final JLabel adminPasswordLabel;


    private JLabel clientLabel;
    private JLabel clientNameLabel;
    private JTextField clientNameText;
    private JLabel clientPasswordLabel;
    private JPasswordField clientPasswordText;
    private JButton  logClientButton;

    private  JTextField clientNameTextReg;
    private  JLabel clientNameLabelReg;
    private  JLabel clientPasswordLabelReg1;
    private final JPasswordField clientPasswordTextReg1;
    private final JLabel clientPasswordLabelReg2;
    private final JPasswordField clientPasswordTextReg2;
    private final JButton regClientButton;
    private final JLabel resultLabel;
    public LogInGUI() {
        //client login
        this.setBounds(250, 150, 450, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        clientLabel = new JLabel("CLIENT");
        clientLabel.setBounds(75, 30, 100, 36);
        getContentPane().add(clientLabel);

        clientNameLabel = new JLabel("username:");
        clientNameLabel.setBounds(20, 70, 90, 36);
        getContentPane().add(clientNameLabel);

        clientNameText =new JTextField ();
        clientNameText.setBounds(80, 80, 100, 20);
        getContentPane().add(clientNameText);

        clientPasswordLabel = new JLabel("password:");
        clientPasswordLabel.setBounds(20, 110, 90, 36);
        getContentPane().add(clientPasswordLabel);

        clientPasswordText =new JPasswordField ();
        clientPasswordText.setBounds(80, 120, 100, 20);
        getContentPane().add(clientPasswordText);

        logClientButton = new JButton("LOGIN");
        logClientButton.setBounds(60,160,100,30);
        getContentPane().add( logClientButton);

        //client register
        clientNameLabelReg = new JLabel("username:");
        clientNameLabelReg.setBounds(20, 220, 90, 36);
        getContentPane().add(clientNameLabelReg);

        clientNameTextReg =new JTextField ();
        clientNameTextReg.setBounds(80, 230, 100, 20);
        getContentPane().add(clientNameTextReg);

        clientPasswordLabelReg1 = new JLabel("password:");
        clientPasswordLabelReg1.setBounds(20, 260, 90, 36);
        getContentPane().add(clientPasswordLabelReg1);

        clientPasswordTextReg1 =new JPasswordField ();
        clientPasswordTextReg1.setBounds(80, 270, 100, 20);
        getContentPane().add(clientPasswordTextReg1);

        clientPasswordLabelReg2 = new JLabel("repeat:");
        clientPasswordLabelReg2.setBounds(35, 300, 90, 36);
        getContentPane().add(clientPasswordLabelReg2);

        clientPasswordTextReg2 =new JPasswordField ();
        clientPasswordTextReg2.setBounds(80, 310, 100, 20);
        getContentPane().add(clientPasswordTextReg2);

        regClientButton = new JButton("REGISTER");
        regClientButton.setBounds(60,350,100,30);
        getContentPane().add( regClientButton);

        //administrator log in

        adminLabel = new JLabel("ADMIN");
        adminLabel.setBounds(275, 30, 100, 36);
        getContentPane().add(adminLabel);

        adminNameLabel = new JLabel("username:");
        adminNameLabel.setBounds(220, 70, 90, 36);
        getContentPane().add(adminNameLabel);

        adminNameText =new JTextField ();
        adminNameText.setBounds(280, 80, 100, 20);
        getContentPane().add(adminNameText);

        adminPasswordLabel = new JLabel("password:");
        adminPasswordLabel.setBounds(220, 110, 90, 36);
        getContentPane().add(adminPasswordLabel);

        adminPasswordText =new JPasswordField ();
        adminPasswordText.setBounds(280, 120, 100, 20);
        getContentPane().add(adminPasswordText);

        logAdminButton = new JButton("LOGIN");
        logAdminButton.setBounds(260,160,100,30);
        getContentPane().add( logAdminButton);




        resultLabel = new JLabel("");
        resultLabel.setBounds(160, 395, 200, 36);
        getContentPane().add(resultLabel);
    }
    public void setMyButtonActionListener1( ActionListener actionListener)
    {
        logClientButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener2( ActionListener actionListener)
    {
        regClientButton.addActionListener(actionListener);
    }
    public void setMyButtonActionListener3( ActionListener actionListener)
    {
        logAdminButton.addActionListener(actionListener);
    }


    //for admin login
    public void setResultLabel(String text){
        resultLabel.setText(text);
    }



    public String getAdminLogName() {
        return adminNameText.getText();
    }

    public String getAdminLogPass() {
        return adminPasswordText.getText();
    }
    public void resetAllText(){
        adminNameText.setText("");
        adminPasswordText.setText("");

        clientNameTextReg.setText("");
        clientPasswordTextReg1.setText("");
        clientPasswordTextReg2.setText("");

        clientNameText.setText("");
        clientPasswordText.setText("");

    }


    public String getClientLogName() {
        return clientNameText.getText();
    }

    public String getClientLogPass() {
        return clientPasswordText.getText();
    }


    public String getClientRegName() {
        return clientNameTextReg.getText();
    }

    public String getClientRegPass1() {
        return clientPasswordTextReg1.getText();
    }
    public String getClientRegPass2() {
        return clientPasswordTextReg2.getText();
    }

}
