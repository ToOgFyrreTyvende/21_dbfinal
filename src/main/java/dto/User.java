package dto;

import dal.IUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements IUser {

    private static final long serialVersionUID = 4545864587995944260L;
    @Id
    @Column(name = "user_id")
    private int	userId;
    private String userName;
    private String ini;
    private String cpr;
    private String password;
    //TODO Add relevant fields

    public User() {    }

    public User(int _userId, String _username, String _ini, String _cpr, String _password){
        this.userId = _userId;
        this.userName = _username;
        this.ini = _ini;
        this.cpr = _cpr;
        this.password = _password;
    }

    @Override
    public int getUserId() {
        return userId;
    }
    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getIni() {
        return ini;
    }
    @Override
    public void setIni(String ini) {
        this.ini = ini;
    }
    @Override
    public String getCpr() {
        return cpr;
    }
    @Override
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    // public List<String> getRoles() {
    //     return roles;
    // }
    // public void setRoles(List<String> roles) {
    //     this.roles = roles;
    // }
    //
    // public void addRole(String role){
    //     this.roles.add(role);
    // }
    // /**
    //  *
    //  * @param role
    //  * @return true if role existed, false if not
    //  */
    // public boolean removeRole(String role){
    //     return this.roles.remove(role);
    // }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", ini=" + ini + "]";
    }
}
