package dal;

import dto.User;
import dto.interfaces.IRole;
import dto.interfaces.IUser;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private SessionFactory factory;
    private Session ses;
    private IUser testUser1;
    private UserDAO userDao;

    @BeforeEach
    void setUp(){
        userDao = new UserDAO();
        testUser1 = new User(555, "testmulti",
                "adv", "555555-5555", "spec");
        ArrayList testRoles = new ArrayList();
        testRoles.add(HibernateUtils.getDefaultRoles().get(0));
        testRoles.add(HibernateUtils.getDefaultRoles().get(1));
        testUser1.setUserRoles(testRoles);
        userDao.createUser(testUser1);
        factory = HibernateUtils.getSessionFactory();
        ses = factory.openSession();
        ses.beginTransaction();
    }

    @AfterEach
    void tearDown(){
        IUser deletionUser = ses.get(User.class, testUser1.getUserId());
        if (deletionUser != null) userDao.deleteUser(deletionUser);
        ses.getTransaction().commit();
        ses.close();
    }

    @Test
    void getUserTest(){
        IUser retrUser = ses.get(User.class, testUser1.getUserId());
        assertEquals(testUser1, retrUser);
    }

    @Test
    void updateUserTest(){
        IUser testUser2 = testUser1;
        testUser2.setUserName("updatedTestUser");
        testUser2.setIni("upd");
        userDao.updateUser(testUser2);
        IUser retrUser = ses.get(User.class, testUser2.getUserId());
        assertNotEquals(testUser1, retrUser);
        assertEquals(testUser2, retrUser);
    }
}