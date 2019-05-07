package hibernate;

import dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtils {
    private static Properties prop;
    private static SessionFactory factory;
    static {
        // Configure Hibernate
        prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://" + System.getenv("DB_URL") + "/21_dbfinal");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
        prop.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.hbm2ddl.auto","create"); //Opretter tabeller automatisk
        prop.setProperty("hibernate.hbm2ddl.auto","update"); //Opdaterer eksisterende tabeller
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query

        factory = new Configuration()
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
    }

    public static SessionFactory getSessionFactory(){
        return factory;
    }

    public static void main(String[] args){


        // Make a Hibernate Session
        // SessionFactory sessionFactory = new Configuration();
        // Session session = sessionFactory.openSession();
    }
}
