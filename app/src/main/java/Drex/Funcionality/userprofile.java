package Drex.Funcionality;

public class userprofile {

    public String f_name;
    public  String l_name;
    public String mobile;
    public String password;


    public userprofile(String f_name, String l_name, String mobile/*, String userPassword*/) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.mobile = mobile;
       // this.password = userPassword;
    }

    public String getUsername() {
        return f_name;
    }

    public void setUsername(String f_name) {
        this.f_name = f_name;
    }

    public String getUserEmail() {
        return l_name;
    }

    public void setUserEmail(String l_name) {
        this.l_name = l_name;
    }

    public String getUserAddress() {
        return mobile;
    }

    public void setUserAddress(String mobile) {
        this.mobile = mobile;
    }

//    public String getUserPassword() {
//        return password;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.password = userPassword;
//    }
}
