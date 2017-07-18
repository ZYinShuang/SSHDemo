package com.jredu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jredu.dao.UserDao;
import com.jredu.entity.User;

@Repository
public class UserDaoImpl  implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.getNamedQuery("findUser");
		query.setString("name", user.getName());
		query.setString("pwd", user.getPwd());
		List<User> list=query.list();
		if(list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
