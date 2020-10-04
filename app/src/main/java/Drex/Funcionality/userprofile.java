package Drex.Funcionality;

public class userprofile {

    public String f_name;
    public  String l_name;
    public String mobile;
    public String id;
    private  String imageURL;

    public userprofile(String f_name, String l_name, String mobile, String id,String imageURL) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.mobile = mobile;
        this.id = id;
        this.imageURL = imageURL;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
