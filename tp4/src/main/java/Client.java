import java.io.Serializable;

public class Client implements Serializable {
    private String name;
    private String password;

    public Client(String name,String password)  {
        this.name=name;
        this.password=password;
    }
    public String toString()
    {
        return "client "+name+" ";
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
