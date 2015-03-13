package com.prapps.ongc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.prapps.core.dao.AbstractAppsDao;
import com.prapps.core.domain.User;
import com.prapps.core.vo.Role;
import com.prapps.ongc.domain.Performance;

@Component
public class OngcDaoImpl extends AbstractAppsDao implements OngcDao {

	@Override
	public Performance addPerformance(Performance performance) {
		User user = (User) loadDistinctEntity(User.class, "userName", performance.getUser().getUserName());
		performance.setUser(user);
		getSession().save(performance);
		Criteria criteria = getSession().createCriteria(Performance.class);
		//criteria.add(Restrictions.eq("user.userName", performance.getUser().getUserName()));
		criteria.add(Restrictions.eq("rank", performance.getRank()));
		criteria.add(Restrictions.eq("score", performance.getScore()));
		criteria.add(Restrictions.eq("tmtName", performance.getTmtName()));
		criteria.add(Restrictions.eq("tmtDate", performance.getTmtDate()));
		return (Performance) criteria.uniqueResult();
	}
	
	@Override
	public List<Performance> getPerformances(com.prapps.core.vo.User user) {
		for(Role role : user.getRoles()) {
			if(role.getName().equals("ROLE_MNGR")) {
				return loadEntity(Performance.class);
			}
		}
		Criteria criteria = getSession().createCriteria(Performance.class, "performance");
		criteria.createAlias("performance.user", "user");
		criteria.add(Restrictions.eq("user.userName", user.getUserName()));
		return criteria.list();
	}
	
	@Override
	public User getUserInfo(String userName) {
		return (User) loadDistinctEntity(User.class, "userName", userName);
	}
	
	@Override
	public List<User> getPlayerList() {
		return loadEntity(User.class, "appCode", "ONGC");
	}
}
