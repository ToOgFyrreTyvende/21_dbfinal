package hibernate;

import dto.*;
import dto.interfaces.IRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;
import java.util.Set;

public class HibernateUtils {
    private static final Properties prop;
    private static final SessionFactory factory;
    private static List<IRole> defaultRoles;
    static {
        // Configure Hibernate
        prop = new Properties();
        //<editor-fold desc="Setting properties">
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://" + System.getenv("DB_URL") + "/21_dbfinal");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
        prop.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.hbm2ddl.auto","create"); //Opretter tabeller automatisk
        prop.setProperty("hibernate.hbm2ddl.auto","update"); //Opdaterer eksisterende tabeller
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query
        //</editor-fold>

        factory = new Configuration()
        //<editor-fold desc="buildSessionFactory">
                .addProperties(prop)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductBatch.class)
                .addAnnotatedClass(ProductBatchStatus.class)
                .addAnnotatedClass(RawMatBatch.class)
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(RecipeHistory.class)
                .buildSessionFactory();
        //</editor-fold>

        //<editor-fold desc="Create default roles">
        IRole adminRole = new Role();
        adminRole.setRoleId(1);
        adminRole.setRoleName("Admin");

        IRole prodLederRole = new Role();
        prodLederRole.setRoleId(2);
        prodLederRole.setRoleName("Produktionsleder");

        IRole farmaceutRole = new Role();
        farmaceutRole.setRoleId(3);
        farmaceutRole.setRoleName("Farmaceut");

        IRole laborantRole = new Role();
        laborantRole.setRoleId(4);
        laborantRole.setRoleName("Laborant");
        //</editor-fold>

        //<editor-fold desc="Add roles to defaultRoles set">
        defaultRoles.add(adminRole);
        defaultRoles.add(prodLederRole);
        defaultRoles.add(farmaceutRole);
        defaultRoles.add(laborantRole);
        //</editor-fold>
    }

    public static SessionFactory getSessionFactory(){
        return factory;
    }

    public static void createDefaultRoles(){
        Session session = factory.openSession();
        session.beginTransaction();
        for (int i = 0; i < defaultRoles.size(); i++){
            session.save(defaultRoles.get(i));
            System.out.println("Inserted default role \""
                    + defaultRoles.get(i).getRoleName() + "\" Successfully");
        }
        session.getTransaction().commit();
        session.close();
        // session.save(defaultRoles.get(2));
        // System.out.println("Inserted default role \""
        //         + defaultRoles.get(2).getRoleName() + "\" Successfully");
        // session.save(defaultRoles.get(3));
        // System.out.println("Inserted default role \""
        //         + defaultRoles.get(3).getRoleName() + "\" Successfully");
        // session.save(defaultRoles.get(4));
        // System.out.println("Inserted default role \""
        //         + defaultRoles.get(4).getRoleName() + "\" Successfully");
    }

    public static void main(String[] args){
        createDefaultRoles();

        // Make a Hibernate Session
        // SessionFactory sessionFactory = new Configuration();
        // Session session = sessionFactory.openSession();
    }
}
