package dal;

import dto.*;
import dto.interfaces.IUser;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of Users to the database.
 * All methods require a Session object given to them,
 * meaning one must have executed the following code to
 * use any methods
 * <pre>{@code
 *     SessionFactory f = HibernateUtils.getSessionFactory();
 *     Session s = f.openSession();
 * }</pre>
 * After each method, one must remember to close the session,
 * as the methods will not do this for you!
 * Example:
 * <pre>{@code
 *     s.close();
 * }</pre>
 */
public class UserDAO {
    // CRUD operations on User
    // TODO: (Method that checks if a user is in the database?)

    /**
     * Creates a new user in the database, unless given user is invalid.
     * User is invalid if it has no username, initials, cpr (of correct length),
     * or password.
     * Returns <tt>userId</tt> of type <tt>int</tt> unless user is invalid,
     * in which case it returns <tt>-1</tt>.
     *
     * @param session Pre-opened <tt>Session</tt> object
     * @param user <tt>IUser</tt> object, which should be created in
     *             the database.
     *             Will be checked for validity!
     * @return <tt>int</tt>: auto-generated id of created user
     */
    public int createUser(Session session, IUser user){
        if (isInvalidUser(user)) return -1;

        session.beginTransaction();
        int userId = (Integer) session.save(user);
        session.getTransaction().commit();
        // System.out.println("Saved following user to database:\n" + retrUser);
        return userId;
    }

    /**
     * Retrieves a user with specified <tt>userId</tt> from database.
     * Returns <tt>IUser</tt> object if a user is found with given <tt>userId</tt>,
     * otherwise returns <tt>null</tt> if no user is found
     * @param session Pre-opened <tt>Session</tt> object
     * @param userId The id of requested user
     * @return <tt>IUser</tt> object if user is found, otherwise <tt>null</tt>
     */
    public IUser getUser(Session session, int userId){
        session.beginTransaction();
        IUser user = session.get(User.class, userId);
        // IUser user = session.get(User.class, userId);
        // if (user == null){
        //     System.out.println("No user found with specified id..." +
        //             "\nReturning empty user");
        //     return new User();
        // }
        session.getTransaction().commit();
        // System.out.println("User found:\n" + user);
        return user;
    }

    public void updateUser(Session session, IUser user){
        if (isInvalidUser(user)) return;

        IUser oldUser = getUser(session, user.getUserId());
        if (oldUser == null){
            System.out.println("No user found, aborting...");
            return;
        }
        oldUser = user;
        session.beginTransaction();
        session.update(oldUser);
        session.getTransaction().commit();
        // session.close();
        // System.out.println("Updated user:\n" + user);
    }

    public void deleteUser(Session session, IUser user){
        IUser oldUser = getUser(session, user.getUserId());
        if (oldUser == null){
            System.out.println("No user found, aborting...");
            return;
        }
        session.beginTransaction();
        session.delete(oldUser);
        session.getTransaction().commit();
    }

    private boolean isInvalidUser(IUser user){
        return user.getUserName().length() == 0 || user.getIni().length() == 0 ||
                user.getCpr().length() != 11 || user.getPassword().length() == 0;
    }


    public static void main(String[] args){


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
