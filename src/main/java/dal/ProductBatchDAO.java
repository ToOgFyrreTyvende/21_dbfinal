package dal;

import dto.ProductBatch;
import dto.interfaces.IProductBatch;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of Product Batches to the database.
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
public class ProductBatchDAO {
    // CRUD operations on ProductBatch
    public int createProdBatch(Session session, IProductBatch prodBatch){
        if (isInvalidProdBatch(prodBatch)) return -1;

        session.beginTransaction();
        int prodBatchId = (Integer) session.save(prodBatch);
        session.getTransaction().commit();
        return prodBatchId;
    }

    public IProductBatch getProdBatch(Session session, int prodBatchId){
        session.beginTransaction();
        IProductBatch retrProdBatch = session.get(ProductBatch.class, prodBatchId);
        session.getTransaction().commit();
        return retrProdBatch;
    }

    public void updateProdBatch(Session session, IProductBatch prodBatch){
        if (isInvalidProdBatch(prodBatch)) return;
        IProductBatch oldProdBatch = getProdBatch(session, prodBatch.getProdBatchId());
        if (oldProdBatch == null) return;
        oldProdBatch = prodBatch;
        session.beginTransaction();
        session.update(oldProdBatch);
        session.getTransaction().commit();
    }

    public void deleteProdBatch(Session session, IProductBatch prodBatch){
        IProductBatch oldProdBatch = getProdBatch(session, prodBatch.getProdBatchId());
        if (oldProdBatch == null) return;
        session.beginTransaction();
        session.delete(oldProdBatch);
        session.getTransaction().commit();
    }

    private boolean isInvalidProdBatch(IProductBatch prodBatch){
        return prodBatch.getProduct().getProductName().length() == 0;
    }
}
