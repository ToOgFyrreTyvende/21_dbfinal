import dal.IUserDAO;
import dal.UserDAOMySQL;

public class main {
    public static void main(String[] args){
        IUserDAO daoMySQL = new UserDAOMySQL();
    }
}