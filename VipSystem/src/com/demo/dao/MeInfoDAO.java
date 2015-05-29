package com.demo.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.MeInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * MeInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.demo.dao.MeInfo
 * @author MyEclipse Persistence Tools
 */
public class MeInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MeInfoDAO.class);
	// property constants
	public static final String MEMBER_PASSWORD = "memberPassword";
	public static final String MEMBER_NAME = "memberName";
	public static final String MEMBER_PHONE_NUMBER = "memberPhoneNumber";
	public static final String MEMBER_COST = "memberCost";
	public static final String VIP_NUM = "vipNum";

	public void save(MeInfo transientInstance) {
		log.debug("saving MeInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MeInfo persistentInstance) {
		log.debug("deleting MeInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MeInfo findById(java.lang.String id) {
		log.debug("getting MeInfo instance with id: " + id);
		try {
			MeInfo instance = (MeInfo) getSession().get("com.demo.model.MeInfo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MeInfo instance) {
		log.debug("finding MeInfo instance by example");
		try {
			List results = getSession().createCriteria("com.demo.model.MeInfo")
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
		log.debug("finding MeInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MeInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMemberPassword(Object memberPassword) {
		return findByProperty(MEMBER_PASSWORD, memberPassword);
	}

	public List findByMemberName(Object memberName) {
		return findByProperty(MEMBER_NAME, memberName);
	}

	public List findByMemberPhoneNumber(Object memberPhoneNumber) {
		return findByProperty(MEMBER_PHONE_NUMBER, memberPhoneNumber);
	}

	public List findByMemberCost(Object memberCost) {
		return findByProperty(MEMBER_COST, memberCost);
	}

	public List findByVipNum(Object vipNum) {
		return findByProperty(VIP_NUM, vipNum);
	}

	public List findAll() {
		log.debug("finding all MeInfo instances");
		try {
			String queryString = "from MeInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MeInfo merge(MeInfo detachedInstance) {
		log.debug("merging MeInfo instance");
		try {
			MeInfo result = (MeInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MeInfo instance) {
		log.debug("attaching dirty MeInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MeInfo instance) {
		log.debug("attaching clean MeInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}