package com.nit.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.Entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManager em;

	@Autowired
	private UserJPARepository repo;

	public User loginValidation(User user) {
		User obj = repo.findByEmailAddressAndPassword(user.getEmailAddress(), user.getPassword());
		return obj;
	
	}

	@Transactional
	public User update(User user) {

		Session currentSession = em.unwrap(Session.class);

		System.out.println("Checking if user exists in DB or not");

		Query<User> query = currentSession.createQuery(
				"select u from User u WHERE (u.Email_address = :Email OR u.id = :id) AND u.Password = :Password",
				User.class);
		query.setParameter("Email", user.getEmailAddress());
		query.setParameter("id", user.getId());
		query.setParameter("Password", user.getPassword());
		List<User> list = query.getResultList();

		if (list.size() > 0) {
			System.out.println("Exists:\n" + list.get(0));

			Query query2 = currentSession
					.createNativeQuery("Update User SET Name = ?, Email_address = ? , Password = ? WHERE Id = ?");
			query2.setParameter(1, user.getName());
			query2.setParameter(2, user.getEmailAddress());
			query2.setParameter(3, user.getPassword());
			query2.setParameter(4, list.get(0).getId());

			if (query2.executeUpdate() > 0)
				return user;
			else
				return new User();

		} else {
			System.out.println("User DNE");
			return new User();
		}
	}

	@Transactional
	public void delete(long id) {
		Session currentSession = em.unwrap(Session.class);
		User Obj = currentSession.get(User.class, id);
		System.out.println(Obj);
		currentSession.delete(Obj);
	}

	public List<User> get() {
		Session currentSession = em.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public boolean signUp(User user) {
		   Session currentSession = em.unwrap(Session.class);
	        try {
	            currentSession.save(user);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public User login(User user) {
		  Session currentSession = em.unwrap(Session.class);
	        Query<User> query = currentSession.createQuery("from User where emailAddress = :email and password = :password", User.class);
	        query.setParameter("email", user.getEmailAddress());
	        query.setParameter("password", user.getPassword());
	        List<User> resultList = query.getResultList();
	        return resultList.isEmpty() ? null : resultList.get(0);
	}
}
