package dto;

import dto.interfaces.IUser;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")})
public class User implements IUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int	userId;

    @Column(name = "user_name", unique = true, nullable = false, length = 45)
    private String userName;

    @Column(name = "initials", unique = false, nullable = false, length = 4)
    private String ini;

    @Column(name = "user_cpr", unique = true, nullable = false, length = 11)
    private String cpr;

    @Column(name = "user_password", unique = false, nullable = false, length = 50)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "users_products",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products;
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

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    public Set<Product> getProducts(){
        return products;
    }

    public void setProducts(Set<Product> products){
        this.products = products;
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
