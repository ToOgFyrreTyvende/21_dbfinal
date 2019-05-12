package dal;

import dto.Product;
import dto.interfaces.IProduct;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of products to the database.
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
public class ProductDAO {
    // TODO: CRUD opertions on Products

    public int createProduct(Session session, IProduct product){
        if (isInvalidProduct(product)) return -1;

        session.beginTransaction();
        int prodId = (Integer) session.save(product);
        session.getTransaction().commit();
        return prodId;
    }

    public IProduct getProduct(Session session, int prodId){
        session.beginTransaction();
        IProduct product = session.get(Product.class, prodId);
        session.getTransaction().commit();
        return product;
    }

    public void updateProduct(Session session, IProduct product){
        if (isInvalidProduct(product)) return;

        IProduct oldProd = getProduct(session, product.getProdId());
        if (oldProd == null) return;

        oldProd = product;
        session.beginTransaction();
        session.update(oldProd);
        session.getTransaction().commit();
    }

    public void deleteProduct(Session session, IProduct product){
        IProduct oldProd = getProduct(session, product.getProdId());
        if (oldProd == null) return;

        session.beginTransaction();
        session.delete(oldProd);
        session.getTransaction().commit();
    }

    private boolean isInvalidProduct(IProduct product){
        return product.getProductName().length() == 0 ||
                String.valueOf(product.getShelfTime()).length() == 0 ||
                String.valueOf(product.getYield()).length() == 0;
    }
}
