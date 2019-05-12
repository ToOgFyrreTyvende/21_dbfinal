package dto;

import dto.interfaces.IRole;
import dto.interfaces.IUser;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")})
public class User implements IUser, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "user_name", unique = true, nullable = false, length = 45)
    private String userName;

    @Column(name = "initials", nullable = false, length = 4)
    private String ini;

    @Column(name = "user_cpr", unique = true, nullable = false, length = 11)
    private String cpr;

    @Column(name = "user_password", nullable = false, length = 50)
    private String password;

    @ManyToMany(targetEntity = Role.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<IRole> userRoles = new ArrayList<>();

    @ManyToMany(targetEntity = Product.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "Users_Products",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List userProducts = new ArrayList();
    //TODO Add relevant fields

    public User(){
    }

    public User(String _username, String _ini, String _cpr, String _password){
        this.userName = _username;
        this.ini = _ini;
        this.cpr = _cpr;
        this.password = _password;
    }

    public User(int _userId, String _username, String _ini, String _cpr, String _password){
        this.userId = _userId;
        this.userName = _username;
        this.ini = _ini;
        this.cpr = _cpr;
        this.password = _password;
    }

    @Override
    public int getUserId(){
        return userId;
    }

    @Override
    public void setUserId(int userId){
        this.userId = userId;
    }

    @Override
    public String getUserName(){
        return userName;
    }

    @Override
    public void setUserName(String userName){
        this.userName = userName;
    }

    @Override
    public String getIni(){
        return ini;
    }

    @Override
    public void setIni(String ini){
        this.ini = ini;
    }

    @Override
    public String getCpr(){
        return cpr;
    }

    @Override
    public void setCpr(String cpr){
        this.cpr = cpr;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public List getUserRoles(){
        return userRoles;
    }

    @Override
    public void setUserRoles(ArrayList<IRole> userRoles){
        this.userRoles = userRoles;
    }

    @Override
    public List getUserProducts(){
        return userProducts;
    }

    @Override
    public void setUserProducts(ArrayList userProducts){
        this.userProducts = userProducts;
    }

    @Override
    public void addRole(IRole role){
        this.userRoles.add(role);
    }
    /**
     *
     * @param role IRole object
     * @return <tt>true</tt> if users list of roles contained role
     */
    @Override
    public boolean removeRole(IRole role){
        return this.userRoles.remove(role);
    }

    @Override
    public String toString(){
        return "User [userId=" + userId + ", userName=" + userName + ", ini=" + ini + "]";
    }
}
