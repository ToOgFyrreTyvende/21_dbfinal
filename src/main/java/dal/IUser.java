package dal;

public interface IUser {
    int getUserId();
    void setUserId(int userId);
    public String getUserName();
    public void setUserName(String userName);
    public String getIni();
    public void setIni(String ini);
    public String getCpr();
    public void setCpr(String cpr);
    public String getPassword();
    public void setPassword(String password);
}
