package gov.tubitak.tutorial.hibernate.entities;
// Generated Dec 10, 2015 2:19:06 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Tmp.
 * @see gov.tubitak.tutorial.hibernate.entities.Tmp
 * @author Hibernate Tools
 */
@Stateless
public class TmpHome {

	private static final Log log = LogFactory.getLog(TmpHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Tmp transientInstance) {
		log.debug("persisting Tmp instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tmp persistentInstance) {
		log.debug("removing Tmp instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tmp merge(Tmp detachedInstance) {
		log.debug("merging Tmp instance");
		try {
			Tmp result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tmp findById(int id) {
		log.debug("getting Tmp instance with id: " + id);
		try {
			Tmp instance = entityManager.find(Tmp.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
