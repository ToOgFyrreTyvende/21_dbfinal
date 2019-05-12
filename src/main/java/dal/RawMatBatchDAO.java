package dal;

import dto.RawMatBatch;
import dto.interfaces.IRawMatBatch;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of raw material batches to the database.
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
public class RawMatBatchDAO {
    // TODO: CRUD operations on RawMatBatch
    public int createRMB(Session session, IRawMatBatch rmb){
        if (isInvalidRMB(rmb)) return -1;

        session.beginTransaction();
        int rmbId = (Integer) session.save(rmb);
        session.getTransaction().commit();
        return rmbId;
    }

    public IRawMatBatch getRMB(Session session, int rmbId){
        session.beginTransaction();
        IRawMatBatch retrRmb = session.get(RawMatBatch.class, rmbId);
        session.getTransaction().commit();
        return retrRmb;
    }

    public void updateRMB(Session session, IRawMatBatch rmb){
        if (isInvalidRMB(rmb)) return;
        IRawMatBatch oldRMB = getRMB(session, rmb.getBatchId());
        if (oldRMB == null) return;

        oldRMB = rmb;
        session.beginTransaction();
        session.update(oldRMB);
        session.getTransaction().commit();
    }

    public void deleteRMB(Session session, IRawMatBatch rmb){
        IRawMatBatch oldRMB = getRMB(session, rmb.getBatchId());
        if (oldRMB == null) return;
        session.beginTransaction();
        session.delete(oldRMB);
        session.getTransaction().commit();
    }

    private boolean isInvalidRMB(IRawMatBatch rmb){
        return String.valueOf(rmb.getTotal()).length() == 0 ||
                rmb.getSupplierName().length() == 0 ||
                String.valueOf(rmb.getRemaining()).length() == 0;
    }
}
