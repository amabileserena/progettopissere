package View;

import java.util.ArrayList;

public class Amministratore {

    String password = "amministratore123";
    String loginName = "amministratore";

    public ArrayList<Product> purchasedProducts = new ArrayList<Product>();

    public String getPassword(){

        return this.password;
    }


    public String getLoginName(){

        return this.loginName;
    }

}
