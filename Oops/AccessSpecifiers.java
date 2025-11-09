import java.util.*;

public class AccessSpecifiers {
    public static void main(String args[]){
        BankAccount myAccount = new BankAccount();
        myAccount.username = "Happy";
        myAccount.setPassword("null1234");
    }
}

class BankAccount{
    public String username;
    public String password;
    pubic void setPassword(String pwd){
        password = pwd;
    }
}
