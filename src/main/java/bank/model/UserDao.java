package bank.model;

import bank.utils.AccountTransaction;
import bank.utils.Auth;
import bank.utils.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<User> getUsers(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User>list = query.list();
		session.close();
		return list;
	}

	public int saveUser(User user){
		try{
			Session session = sessionFactory.openSession();
			session.save(user);
			session.close();
			return 1;
		}
		catch (Exception e){
			System.out.println(e);
			return 0;
		}
	}

	public List<User> findUser(Auth auth){
		Session session = sessionFactory.openSession();
		String hql = "FROM User u WHERE u.email = :email AND u.password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("email",auth.getEmail());
		query.setParameter("password",auth.getPassword());
		List<User> list = query.list();
		return list;
	}

	public  int makeTransaction(AccountTransaction transaction){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println(transaction.getEmail() + " " + transaction.getPassword());
		String hql = "FROM User u WHERE u.email = :email AND u.password = :password";
		Query q = session.createQuery(hql);
		q.setParameter("email",transaction.getEmail());
		q.setParameter("password",transaction.getPassword());
		List<User> list = q.list();
		if(list.size() == 1){
			User u = list.get(0);
			switch (transaction.getType())	{
				case "credit":
					u.setBalance((long) (u.getBalance() - transaction.getAmount()));
					break;
				case "debit":
					u.setBalance((long) (u.getBalance() + transaction.getAmount()));
					break;
				default:
					return 0;
			}
			System.out.println(u);
			session.update(u);
			t.commit();
			session.close();
			return  1;
		}
		return 0;
	}
}
