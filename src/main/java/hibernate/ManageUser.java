package hibernate;

import dto.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManageUser {
    // CRUD operations on User
    public static void main(String[] args){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
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
