package dal;

import dto.User;
import dto.interfaces.IUser;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private SessionFactory factory;
    private Session session;
    private IUser testUser;
    // private UserDAO userDao;

    @Test
    void userDAOtest(){
        // Create test user
        // userDao = new UserDAO();
        testUser = new User(1, "testmulti",
                "adv", "555555-5555", "spec");
        ArrayList testRoles = new ArrayList();
        testRoles.add(HibernateUtils.getDefaultRoles().get(0));
        testRoles.add(HibernateUtils.getDefaultRoles().get(1));
        testUser.setUserRoles(testRoles);

        // init session with hibernate
        factory = HibernateUtils.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();

        // Save user
        session.save(testUser);
        session.getTransaction().commit();
        session.beginTransaction();

        // Get user and check correct details
        IUser retrUser = session.get(User.class, testUser.getUserId());
        session.getTransaction().commit();
        session.beginTransaction();
        assertEquals(testUser.getUserId(), retrUser.getUserId());
        assertTrue(testUser.getUserName().equals(retrUser.getUserName()));
        assertTrue(testUser.getIni().equals(retrUser.getIni()));
        assertTrue(testUser.getCpr().equals(retrUser.getCpr()));
        assertTrue(testUser.getPassword().equals(retrUser.getPassword()));
        assertFalse(retrUser.getUserRoles().isEmpty());

        // Update user and save to db
        testUser.setUserName("testUpdated");
        testUser.setIni("upd");
        session.saveOrUpdate(testUser);
        session.getTransaction().commit();
        session.beginTransaction();

        // check user is different
        assertFalse(retrUser.getUserName().equals(testUser.getUserName()));
        assertFalse(retrUser.getIni().equals(testUser.getIni()));

        // Delete user in db
        session.delete(testUser);
        session.getTransaction().commit();
        session.beginTransaction();

        // Check user is deleted
        retrUser = session.get(User.class, testUser.getUserId());
        session.getTransaction().commit();
        session.close();
        assertNull(retrUser);
    }
}