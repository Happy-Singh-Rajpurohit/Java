import java.util.*;

public class AccessSpecifiers {
    public static void main(String args[]){
        BankAccount myAccount = new BankAccount();
        myAccount.username = "Happy";
        myAccount.setPassword("null1234");
        myAccount.getPassword();
        myAccount.setPassword("1234");
        myAccount.getPassword();
    }
}

class BankAccount{
    public String username;
    public String password;
    public void setPassword(String pwd){
        this.password = pwd;
    }

    String getPassword(){
        System.out.println("Password is: " + this.password);
        return this.password;
    }
}
