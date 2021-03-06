package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Servicerelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.Servicerelation
 * @author MyEclipse Persistence Tools
 */

public class ServicerelationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ServicerelationDAO.class);
	// property constants
	public static final String SEQ_NUM = "seqNum";

	protected void initDao() {
		// do nothing
	}

	public void save(Servicerelation transientInstance) {
		log.debug("saving Servicerelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Servicerelation persistentInstance) {
		log.debug("deleting Servicerelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Servicerelation findById(java.lang.Integer id) {
		log.debug("getting Servicerelation instance with id: " + id);
		try {
			Servicerelation instance = (Servicerelation) getHibernateTemplate()
					.get("com.bean.Servicerelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Servicerelation instance) {
		log.debug("finding Servicerelation instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Servicerelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Servicerelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySeqNum(Object seqNum) {
		return findByProperty(SEQ_NUM, seqNum);
	}

	public List findAll() {
		log.debug("finding all Servicerelation instances");
		try {
			String queryString = "from Servicerelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Servicerelation merge(Servicerelation detachedInstance) {
		log.debug("merging Servicerelation instance");
		try {
			Servicerelation result = (Servicerelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Servicerelation instance) {
		log.debug("attaching dirty Servicerelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Servicerelation instance) {
		log.debug("attaching clean Servicerelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServicerelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ServicerelationDAO) ctx.getBean("ServicerelationDAO");
	}
	
	public List findByServiceId(Object serviceId) {
		try {
			String queryString = "from Servicerelation sr where sr.serviceByServiceId.serviceId = ?";
			return getHibernateTemplate().find(queryString, serviceId);
		} catch (RuntimeException re) {
			log.error("find by property serviceId failed", re);
			throw re;
		}
	}
}