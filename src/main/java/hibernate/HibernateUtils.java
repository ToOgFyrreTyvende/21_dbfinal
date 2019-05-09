package hibernate;

import dto.*;
import dto.interfaces.IIngredient;
import dto.interfaces.IRole;
import dto.interfaces.IUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HibernateUtils {
    private static final Properties prop;
    private static final SessionFactory factory;
    private static List<IRole> defaultRoles = new ArrayList<>();
    private static List<IIngredient> defaultIngredients = new ArrayList<>();

    static{
        // Configure Hibernate
        prop = new Properties();
        //<editor-fold desc="Setting properties">
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://" + System.getenv("DB_URL") + "/21_dbfinal");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
        prop.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.hbm2ddl.auto", "create"); //Opretter tabeller automatisk
        prop.setProperty("hibernate.hbm2ddl.auto", "update"); //Opdaterer eksisterende tabeller
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

        //<editor-fold desc="Create default ingredients">
        IIngredient sildenafil = new Ingredient();
        sildenafil.setIngredientId(1);
        sildenafil.setIngredientName("Sildenafil");
        sildenafil.setActive(true);

        IIngredient estradiol = new Ingredient();
        estradiol.setIngredientId(2);
        estradiol.setIngredientName("Estradiol");
        estradiol.setActive(true);

        IIngredient opovidon = new Ingredient();
        opovidon.setIngredientId(3);
        opovidon.setIngredientName("Opovidon");
        opovidon.setActive(false);
        //</editor-fold>

        //<editor-fold desc="Add roles/ingredients to defaultRoles/Ingredients ArrayList">
        defaultRoles.add(adminRole);
        defaultRoles.add(prodLederRole);
        defaultRoles.add(farmaceutRole);
        defaultRoles.add(laborantRole);

        defaultIngredients.add(sildenafil);
        defaultIngredients.add(estradiol);
        defaultIngredients.add(opovidon);
        //</editor-fold>
    }

    public static SessionFactory getSessionFactory(){
        return factory;
    }

    private static void createDefaultRoles(){
        Session session1 = factory.openSession();
        session1.beginTransaction();
        for (IRole defaultRole : defaultRoles){
            session1.saveOrUpdate(defaultRole);
            System.out.println("Inserted default role \""
                    + defaultRole.getRoleName() + "\" Successfully");
        }
        session1.getTransaction().commit();
        System.out.println("Finished saving default roles to database,");
        System.out.println("Retrieving role(s) now to check for errors...");
        Role firstRole = (Role) session1.get(Role.class, 1);
        Role secondRole = (Role) session1.get(Role.class, 2);
        System.out.println("Retrieved role name: " + firstRole.getRoleName());
        System.out.println("Role 2: " + secondRole.getRoleName());
        session1.close();
    }

    private static void createDefaultIngredients(){
        Session session = factory.openSession();
        session.beginTransaction();
        for (IIngredient ingredient : defaultIngredients){
            session.saveOrUpdate(ingredient);
            System.out.println("Inserted default ingredient \""
                    + ingredient.getIngredientName() + "\" Succesfully");
        }
        session.getTransaction().commit();
        System.out.println("Finished saving default ingredients to database.");
        System.out.println("Retrieving first ingredient to check for errors...");
        Ingredient firstIngr = (Ingredient) session.get(Ingredient.class, 1);
        System.out.println("Retrieved ingredient name: " + firstIngr.getIngredientName());
        session.close();
    }

    public static void main(String[] args){
        createDefaultRoles();
        System.out.println();
        createDefaultIngredients();
        // System.out.println();
        // userTesting();
    }

    /*
    private static List<IUser> testUsers = new ArrayList<>();
    static {
        testUsers.add(new User(111, "testAdmin", "adm", "111111-1111", "root"));
        testUsers.add(new User(222, "testPLead", "pro", "222222-2222", "lead"));
        testUsers.add(new User(333, "testFarma", "farm", "333333-3333", "farm"));
        testUsers.add(new User(444, "testLaborant", "lab", "444444-4444", "lab"));
        testUsers.add(new User(555, "testmulti", "lab", "555555-5555", "spec"));
    }
    private static void userTesting(){
        System.out.println("----- Beginning user testing -----");
        IUser testMulti = testUsers.get(4);
        System.out.println("init user:\n" + testMulti);
        List<IRole> multiRoleList = new ArrayList<>();
        // Start session
        Session getRoleSession = factory.openSession();
        // Session saveUserSession = factory.openSession();
        getRoleSession.beginTransaction();
        // Get roles from db
        System.out.println();
        multiRoleList.add(getRoleSession.get(Role.class, 1));
        System.out.println("Add " + multiRoleList.get(0).getRoleName() + " to multiRoleList");
        multiRoleList.add(getRoleSession.get(Role.class, 4));
        System.out.println("Add " + multiRoleList.get(1).getRoleName() + " to multiRoleList");
        // set Test users roles
        testMulti.setUserRoles(multiRoleList);
        System.out.println("multirole user has " + testMulti.getUserRoles().size() + " roles");
        System.out.println();
        // session save & commit
        getRoleSession.saveOrUpdate(testUsers.get(4));
        getRoleSession.getTransaction().commit();
        // Checking
        System.out.println("Done saving, now retrieving...");
        IUser retreivedUser = getRoleSession.get(User.class, 1);
        System.out.println("Retrieved user:\n" + retreivedUser);
        System.out.println("Role 1: " + retreivedUser.getUserRoles().get(0) +
                "\nRole 2: " + retreivedUser.getUserRoles().get(1));
        getRoleSession.close();
    }*/
}
