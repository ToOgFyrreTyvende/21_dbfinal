package dal;

import dto.Role;
import dto.interfaces.IRole;
import org.hibernate.Session;

/**
 * Handles all CRUD operations of Users to the database.
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
public class RoleDAO {
    // CRUD operations on Role
    public int createRole(Session session, IRole role){
        if (isInvalidRole(role)) return -1;

        session.beginTransaction();
        int roleId = (Integer) session.save(role);
        session.getTransaction().commit();
        return roleId;
    }

    public IRole getRole(Session session, int roleId){
        session.beginTransaction();
        IRole retrRole = session.get(Role.class, roleId);
        session.getTransaction().commit();
        return retrRole;
    }

    public void updateUser(Session session, IRole role){
        if (isInvalidRole(role)) return;
        IRole oldRole = getRole(session, role.getRoleId());
        if (oldRole == null) return;

        oldRole = role;
        session.beginTransaction();
        session.update(oldRole);
        session.getTransaction().commit();
    }

    public void deleteUser(Session session, IRole role){
        IRole oldRole = getRole(session, role.getRoleId());
        if (oldRole == null) return;
        session.beginTransaction();
        session.delete(oldRole);
        session.getTransaction().commit();
    }

    private boolean isInvalidRole(IRole role){
        return role.getRoleName().length() == 0;
    }
}
