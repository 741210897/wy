package com.demo.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.CoInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CoInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.demo.dao.CoInfo
 * @author MyEclipse Persistence Tools
 */
public class CoInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CoInfoDAO.class);
	// property constants
	public static final String VIP_PAY = "vipPay";

	public void save(CoInfo transientInstance) {
		log.debug("saving CoInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CoInfo persistentInstance) {
		log.debug("deleting CoInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CoInfo findById(java.lang.String id) {
		log.debug("getting CoInfo instance with id: " + id);
		try {
			CoInfo instance = (CoInfo) getSession().get("com.demo.model.CoInfo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CoInfo instance) {
		log.debug("finding CoInfo instance by example");
		try {
			List results = getSession().createCriteria("com.demo.model.CoInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CoInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CoInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVipPay(Object vipPay) {
		return findByProperty(VIP_PAY, vipPay);
	}

	public List findAll() {
		log.debug("finding all CoInfo instances");
		try {
			String queryString = "from CoInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CoInfo merge(CoInfo detachedInstance) {
		log.debug("merging CoInfo instance");
		try {
			CoInfo result = (CoInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CoInfo instance) {
		log.debug("attaching dirty CoInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CoInfo instance) {
		log.debug("attaching clean CoInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}