package dal;

import dto.Ingredient;
import dto.interfaces.IIngredient;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of ingredients to the database.
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
public class IngredientDAO {
    public int createIngredient(Session session, IIngredient ingredient){
        if (isInvalidIngredient(ingredient)) return -1;

        session.beginTransaction();
        int ingrId = (Integer) session.save(ingredient);
        session.getTransaction().commit();
        return ingrId;
    }

    public IIngredient getIngredient(Session session, int ingrId){
        session.beginTransaction();
        IIngredient retrIngr = session.get(Ingredient.class, ingrId);
        session.getTransaction().commit();
        return retrIngr;
    }

    public void updateIngredient(Session session, IIngredient ingr){
        IIngredient oldIngr = getIngredient(session, ingr.getIngredientId());
        if (oldIngr == null) return;
        oldIngr = ingr;
        session.beginTransaction();
        session.update(oldIngr);
        session.getTransaction().commit();
    }

    public void deleteIngredient(Session session, IIngredient ingr){
        IIngredient oldIngr = getIngredient(session, ingr.getIngredientId());
        if (oldIngr == null) return;
        session.beginTransaction();
        session.delete(oldIngr);
        session.getTransaction().commit();
    }

    private boolean isInvalidIngredient(IIngredient ingr){
        return ingr.getIngredientName().length() == 0;
    }
}
