package hibernate;

import dal.*;
import dto.*;
import dto.interfaces.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateUtils {
    private static final Properties prop;
    private static final SessionFactory factory;
    private static List<IRole> defaultRoles = new ArrayList<>();
    private static List<IIngredient> defaultIngredients = new ArrayList<>();
    private static List<IProductBatchStatus> defaultPBStatuses = new ArrayList<>();
    private static List<IRawMatBatch> defaultRawMatBatches = new ArrayList<>();

    static{
        // Configure Hibernate
        prop = new Properties();
        //<editor-fold desc="Setting properties">
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://" + System.getenv("DB_URL") + "/andersm");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
        prop.setProperty("hibernate.connection.password", System.getenv("DB_PASS"));
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.hbm2ddl.auto", "create"); //Opretter tabeller automatisk
        prop.setProperty("hibernate.hbm2ddl.auto", "update"); //Opdaterer eksisterende tabeller
        prop.setProperty("hibernate.show_sql", "true"); //If you wish to see the generated sql query
        // prop.setProperty("hibernate.format_sql", "true"); // If you want generated sql to be formatted nicely
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
        defaultRoles.add(adminRole);

        IRole prodLederRole = new Role();
        prodLederRole.setRoleId(2);
        prodLederRole.setRoleName("Produktionsleder");
        defaultRoles.add(prodLederRole);

        IRole farmaceutRole = new Role();
        farmaceutRole.setRoleId(3);
        farmaceutRole.setRoleName("Farmaceut");
        defaultRoles.add(farmaceutRole);

        IRole laborantRole = new Role();
        laborantRole.setRoleId(4);
        laborantRole.setRoleName("Laborant");
        defaultRoles.add(laborantRole);
        //</editor-fold>

        //<editor-fold desc="Create default ingredients">
        IIngredient sildenafil = new Ingredient();
        sildenafil.setIngredientId(1);
        sildenafil.setIngredientName("Sildenafil");
        sildenafil.setActive(true);
        defaultIngredients.add(sildenafil);

        IIngredient estradiol = new Ingredient();
        estradiol.setIngredientId(2);
        estradiol.setIngredientName("Estradiol");
        estradiol.setActive(true);
        defaultIngredients.add(estradiol);

        IIngredient opovidon = new Ingredient();
        opovidon.setIngredientId(3);
        opovidon.setIngredientName("Opovidon");
        opovidon.setActive(false);
        defaultIngredients.add(opovidon);
        //</editor-fold>

        //<editor-fold desc="Create default statuses">
        IProductBatchStatus status1 = new ProductBatchStatus();
        status1.setProdBatchStatusId(1);
        status1.setProdBatchStatus("Ready to begin production");
        defaultPBStatuses.add(status1);

        IProductBatchStatus status2 = new ProductBatchStatus();
        status2.setProdBatchStatusId(2);
        status2.setProdBatchStatus("In production");
        defaultPBStatuses.add(status2);

        IProductBatchStatus status3 = new ProductBatchStatus();
        status3.setProdBatchStatusId(3);
        status3.setProdBatchStatus("Production complete");
        defaultPBStatuses.add(status3);
        //</editor-fold>

        //<editor-fold desc="Create default Raw Mat Batches">
        IRawMatBatch rmb1 = new RawMatBatch();
        rmb1.setBatchId(1);
        rmb1.setIngredients(defaultIngredients.get(0));
        rmb1.setTotal(550.0);
        rmb1.setRemaining(rmb1.getTotal());
        rmb1.setSupplierName("Google");
        rmb1.setSupplierBatchId(1);
        rmb1.setResidual(false);
        defaultRawMatBatches.add(rmb1);

        IRawMatBatch rmb2 = new RawMatBatch();
        rmb2.setBatchId(2);
        rmb2.setIngredients(defaultIngredients.get(1));
        rmb2.setTotal(625.0);
        rmb2.setRemaining(rmb2.getTotal());
        rmb2.setSupplierName("DTU");
        rmb2.setSupplierBatchId(2);
        rmb2.setResidual(false);
        defaultRawMatBatches.add(rmb2);

        IRawMatBatch rmb3 = new RawMatBatch();
        rmb3.setBatchId(3);
        rmb3.setIngredients(defaultIngredients.get(2));
        rmb3.setTotal(475.0);
        rmb3.setRemaining(rmb3.getTotal());
        rmb3.setSupplierName("Delegate");
        rmb3.setSupplierBatchId(3);
        rmb3.setResidual(false);
        defaultRawMatBatches.add(rmb3);
        //</editor-fold>
    }

    public static SessionFactory getSessionFactory(){
        return factory;
    }

    public static List<IRole> getDefaultRoles(){
        return defaultRoles;
    }

    public static List<IIngredient> getDefaultIngredients(){
        return defaultIngredients;
    }

    private static void createDefaultRoles(){
        Session session1 = factory.openSession();
        session1.beginTransaction();
        for (IRole defaultRole : defaultRoles){
            if (session1.get(Role.class, defaultRole.getRoleId()) != null) continue;
            session1.save(defaultRole);
            System.out.println("Inserted default role \""
                                       + defaultRole.getRoleName() + "\" Successfully");
        }
        session1.getTransaction().commit();
        System.out.println("Finished saving default roles to database,");
        System.out.println("Retrieving role(s) now to check for errors...");
        Role firstRole = (Role) session1.get(Role.class, 1);
        Role secondRole = (Role) session1.get(Role.class, 2);
        System.out.println("Role 1: " + firstRole.getRoleName());
        System.out.println("Role 2: " + secondRole.getRoleName());
        session1.close();
    }

    private static void createDefaultIngredients(){
        Session session = factory.openSession();
        session.beginTransaction();
        for (IIngredient ingredient : defaultIngredients){
            if (session.get(Ingredient.class, ingredient.getIngredientId()) != null) continue;
            session.save(ingredient);
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

    private static void createDefaultStatuses(){
        Session session = factory.openSession();
        session.beginTransaction();
        for (IProductBatchStatus status : defaultPBStatuses){
            if (session.get(ProductBatchStatus.class, status.getProdBatchStatusId()) != null) continue;
            session.save(status);
            System.out.println("Inserted default ProductBatchStatus: \"" +
                                       status.getProdBatchStatus() + "\" succesfully");
        }
        session.getTransaction().commit();
        System.out.println("Finished saving default PBStatuses to database");
        System.out.println("Retrieving first to check for errors...");
        IProductBatchStatus firstPBS = session.get(ProductBatchStatus.class, 1);
        System.out.println("Retrieved status string: " + firstPBS.getProdBatchStatus());
        session.close();
    }

    private static void createDefaultRawMatBatches(){
        Session session = factory.openSession();
        session.beginTransaction();
        for (IRawMatBatch rmb : defaultRawMatBatches){
            if (session.get(RawMatBatch.class, rmb.getBatchId()) != null) continue;
            rmb.setBatchId((Integer) session.save(rmb));
            System.out.println("Inserted default RMB for ingredient: " + rmb.getIngredients().getIngredientName() + "succesfully");
        }
        session.getTransaction().commit();
        System.out.println("Finished saving default RMB to database");
        System.out.println("Retrieving first RMB to check for errors...");
        IRawMatBatch firstRMB = session.get(RawMatBatch.class, defaultRawMatBatches.get(0).getBatchId());
        System.out.println("Retrieved rmb ingredient: " + firstRMB.getIngredients().getIngredientName());
        session.close();
    }

    public static void main(String[] args){
        System.out.println("\n----- Creating default roles -----");
        createDefaultRoles();
        System.out.println("\n----- Creating default ingredients -----");
        createDefaultIngredients();
        System.out.println("\n----- Creating default PBStatuses -----");
        createDefaultStatuses();
        System.out.println("\n----- Creating default RMBs -----");
        createDefaultRawMatBatches();
        // System.out.println("\n----- Beginning user testing -----");
        // userTesting();
        // userDAOTesting();
        System.out.println("\n----- Beginning whole system test -----");
        wholeSysTesting();
    }


    private static List<IUser> testUsers = new ArrayList<>();

    static{
        testUsers.add(new User("testAdmin", "adm", "111111-1111", "root"));
        testUsers.add(new User("testPLead", "pro", "222222-2222", "lead"));
        testUsers.add(new User("testFarma", "farm", "333333-3333", "farm"));
        testUsers.add(new User("testLaborant", "lab", "444444-4444", "lab"));
        testUsers.get(3).addRole(defaultRoles.get(3));
        testUsers.add(new User("testMulti", "adv", "555555-5555", "spec"));
        testUsers.get(4).addRole(defaultRoles.get(0));
        testUsers.get(4).addRole(defaultRoles.get(1));
    }

    private static void userTesting(){
        IUser testUsr = testUsers.get(4);
        System.out.println("init user:\n" + testUsr);
        // Collection<IRole> multiRoleList = new ArrayList<>();

        // Get roles
        System.out.println();
        // multiRoleList.add(defaultRoles.get(0));
        // System.out.println("Add " + defaultRoles.get(0).getRoleName() + " to multiRoleList");
        // multiRoleList.add(defaultRoles.get(1));
        // System.out.println("Add " + defaultRoles.get(1).getRoleName() + " to multiRoleList");
        // set Test users roles

        // testUsr.setUserRoles((ArrayList) multiRoleList);
        System.out.println("multirole user has " + testUsr.getUserRoles().size() + " roles\n");

        // Start session & begin transaction
        Session session = factory.openSession();
        session.beginTransaction();

        // session save & commit
        int testUserId = (Integer) session.save(testUsr);
        System.out.println("\nTest user was assigned id: " + testUserId + " by database\n");
        session.getTransaction().commit();
        session.beginTransaction();
        // Checking
        System.out.println("Done saving, now retrieving...");
        IUser retrievedUser = session.get(User.class, testUserId);
        System.out.println("Retrieved user:\n" + retrievedUser);
        System.out.println("Role 1: " + retrievedUser.getUserRoles().get(0) +
                                   "\nRole 2: " + retrievedUser.getUserRoles().get(1) + "\n");
        // Deleting
        session.delete(testUsr);
        session.getTransaction().commit();
        session.close();
    }

    private static void userDAOTesting(){
        UserDAO dao = new UserDAO();
        IUser testUser = testUsers.get(4);
        System.out.println("Init user:\n" + testUser + "\n");

        Session session = factory.openSession();
        // Create user
        System.out.println("Attempting to create user now...\n");
        int retrId = dao.createUser(session, testUser);
        if (retrId == -1){
            System.out.println("That user apparently already exists... Aborting test run...");
            return;
        }
        testUser.setUserId(retrId);
        System.out.println("\nUser created with id: " + testUser.getUserId() + "\n");

        // Update user
        System.out.println("Attempting to update user now...\n");
        testUser.setUserName("UpdatedTest");
        testUser.setIni("upd");
        dao.updateUser(session, testUser);
        System.out.println("No errors so far... Going well i hope!\n");

        // Get user
        System.out.println("Attempting to retrieve user now...\n");
        IUser retrUser = dao.getUser(session, testUser.getUserId());
        System.out.println("Retrieved user:\n\t" + retrUser);
        System.out.println("Retrieved users roles:" +
                                   "\n\tRole 1: " + retrUser.getUserRoles().get(0) +
                                   "\n\tRole 2: " + retrUser.getUserRoles().get(1));

        // Delete user
        System.out.println("\nAttempting to delete user now...\n");
        dao.deleteUser(session, testUser);

        session.close();
    }

    private static void wholeSysTesting(){
        //<editor-fold desc="Create new DAO objects">
        UserDAO uDAO = new UserDAO();
        RoleDAO roleDAO = new RoleDAO();
        IngredientDAO iDAO = new IngredientDAO();
        ProductDAO prodDAO = new ProductDAO();
        ProductBatchDAO pBDAO = new ProductBatchDAO();
        RawMatBatchDAO rmbDAO = new RawMatBatchDAO();
        //</editor-fold>

        System.out.println("Init users\n" + testUsers.get(4) + "\n" + testUsers.get(3));

        IProduct prod1 = new Product();
        prod1.setProdId(1);
        prod1.setProductName("testProd1");
        prod1.setUsers(Arrays.asList(testUsers.get(4), testUsers.get(3)));

        IRecipe recipe1 = new Recipe();
        recipe1.setAmount(35.0);
        recipe1.setIngredient(defaultIngredients.get(0));
        recipe1.setProduct(prod1);
        IRecipe recipe2 = new Recipe();
        recipe2.setAmount(45.0);
        recipe2.setIngredient(defaultIngredients.get(1));
        recipe2.setProduct(prod1);

        prod1.setRecipes(Arrays.asList(recipe1, recipe2));
        prod1.setShelfTime(420.0);
        prod1.setYield(0.85);

        IProductBatch pb1 = new ProductBatch();
        pb1.setProdBatchId(1);
        pb1.setProduct(prod1);
        pb1.setBatchStatus(defaultPBStatuses.get(0));
        pb1.setRawMatBatches(Arrays.asList(defaultRawMatBatches.get(0),
                                           defaultRawMatBatches.get(1),
                                           defaultRawMatBatches.get(2)));
        IProductBatch pb2 = pb1;
        pb2.setProdBatchId(2);

        // prod1.setProdBatch(Arrays.asList(pb1, pb2));
        prod1.setUsers(Arrays.asList(testUsers.get(4), testUsers.get(3)));

        Session ses = factory.openSession();

        System.out.println("Attempting to save the two users now...");
        int autoGenId;
        autoGenId = uDAO.createUser(ses, testUsers.get(4));
        testUsers.get(4).setUserId(autoGenId);
        autoGenId = uDAO.createUser(ses, testUsers.get(3));
        testUsers.get(3).setUserId(autoGenId);
        System.out.println("If you're seeing this, it went fine :)\n");

        System.out.println("Attempting to save the product now!!!");
        int prodId;
        prodId = prodDAO.createProduct(ses, prod1);
        prod1.setProdId(prodId);
        System.out.println("If you're seeing this, it went fine!\n");

        System.out.println("Attempt create prod batch...");
        pBDAO.createProdBatch(ses, pb1);
        pBDAO.createProdBatch(ses, pb2);
        System.out.println("Went gut yes");

        System.out.println("\nRetrieving some info now...");
        System.out.println("Retrieving product...");
        IProduct retrProd = prodDAO.getProduct(ses, prod1.getProdId());
        System.out.println("Retrieved product:\n" + retrProd.getProductName());
        System.out.println("\nIngredients from product:\n\t1:\t" +
                                   retrProd.getRecipes().get(0).getIngredient().getIngredientName() + "\n\t2:\t" +
                                   retrProd.getRecipes().get(1).getIngredient().getIngredientName());
        // System.out.println("Product batch1 status:\n\t" +
        //                            retrProd.getProdBatch().get(0).getBatchStatus().getProdBatchStatus());
        // System.out.println("Product batch1 remaining amount:\n\t" +
        //                            retrProd.getProdBatch().get(0).getRawMatBatches().get(0).getRemaining());
        System.out.println("Product users:\n\t" +
                                   retrProd.getUsers().get(0) + "\n\t" +
                                   retrProd.getUsers().get(1));
        System.out.println();

        System.out.println("Deleting stuff now...");
        pBDAO.deleteProdBatch(ses, pb1);
        pBDAO.deleteProdBatch(ses, pb2);
        prodDAO.deleteProduct(ses, prod1);
        uDAO.deleteUser(ses, testUsers.get(4));
        uDAO.deleteUser(ses, testUsers.get(3));
        System.out.println("I make later, pls no judge...");
        ses.close();
    }
}
