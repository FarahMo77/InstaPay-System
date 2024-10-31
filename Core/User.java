package Core;

public abstract class User{
    String url = "jdbc:sqlite:D:/College/4th/SDA2023-2024/InstaPay-Project/pro/myDatabase.db";
    private String userName;

    private String password;
    private String mobileNo;
    protected boolean isRegistered = false;
    public User(){
        this.userName = "";
        this.password = "";
        this.mobileNo = "";
    }
    public User(String userName, String email, String password, String mobileNo){
        this.userName = userName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.isRegistered = true;
    }
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void setUserName(String username){
        userName = username;
    }

    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }
    public void setPwd(String pwd){
        password = pwd;
    }
    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
    public String getMobileNo(){
        return mobileNo;
    }
    public void registered(){
        this.isRegistered = true;
    }
}
