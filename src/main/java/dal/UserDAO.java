package dal;

import dto.*;
import dto.interfaces.IUser;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {
    // CRUD operations on User
    // TODO: (Method that checks if a user is in the database?)
    //  + deleteUser method
    public void createUser(IUser user){
        if (!isValidUser(user)){
            return;
        }
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        User checkUser = session.get(User.class, user.getUserId());
        System.out.println("Saved user \"" + checkUser.getUserName() + "\" to database.");
        session.close();
    }

    public IUser getUser(int userId){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        IUser user = session.get(User.class, userId);
        session.getTransaction().commit();
        session.close();
        System.out.println("User found:\n" + user);
        return user;
    }

    public void updateUser(IUser user){
        if (!isValidUser(user)){
            return;
        }
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Updated user:\n" + user);
    }

    public void deleteUser(IUser user){
        // TODO: This method
    }

    private boolean isValidUser(IUser user){
        return String.valueOf(user.getUserId()).length() != 0 && user.getUserName().length() != 0 &&
                user.getIni().length() != 0 && user.getCpr().length() == 11 && user.getPassword().length() != 0;
    }


    public static void main(String[] args){
        // Create dummy user
        // User user = new User(42, "Dråbelyd",
        //         "DUI", "420360-1337", "dummyBoi");


    }

    // public void listUsers(){
    //     Session session = factory.openSession();
    //     Transaction tx = null;
    //
    //     try{
    //         tx = session.beginTransaction();
    //         List users = session.createQuery("FROM users").list();
    //         for (Iterator iterator = users.iterator(); iterator.hasNext(); ){
    //             User user = (User) iterator.next();
    //             System.out.print("user id: " + user.getUserId());
    //             System.out.print("  Username: " + user.getUserName());
    //             System.out.println("  Ini: " + user.getIni());
    //         }
    //         tx.commit();
    //     } catch (HibernateException e){
    //         if (tx!=null) tx.rollback();
    //         e.printStackTrace();
    //     } finally {
    //         session.close();
    //     }
    // }
}
