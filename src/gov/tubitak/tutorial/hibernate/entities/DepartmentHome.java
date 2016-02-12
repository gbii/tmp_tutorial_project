package gov.tubitak.tutorial.hibernate.entities;
// Generated Dec 9, 2015 5:25:43 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Department.
 * @see gov.tubitak.tutorial.hibernate.entities.Department
 * @author Hibernate Tools
 */
@Stateless
public class DepartmentHome {

	private static final Log log = LogFactory.getLog(DepartmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Department transientInstance) {
		log.debug("persisting Department instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Department persistentInstance) {
		log.debug("removing Department instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Department merge(Department detachedInstance) {
		log.debug("merging Department instance");
		try {
			Department result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Department findById(int id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = entityManager.find(Department.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
