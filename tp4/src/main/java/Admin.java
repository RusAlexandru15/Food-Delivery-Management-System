
public class Admin  {
    private String name;
    private String password;

    public Admin(String n,String pass){
        name=n;
        password=pass;
    }
    public String toString(){
        return "Administrator "+name+" parola: "+password+"\n";
    }

}
