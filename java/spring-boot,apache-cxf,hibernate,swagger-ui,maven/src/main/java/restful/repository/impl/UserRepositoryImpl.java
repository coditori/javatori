package restful.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import restful.model.User;
import restful.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return entityManager.createQuery("from User").getResultList();
	}

	@Override
	public User findById(final Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void add(final User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteById(final long id) {
		final User user = entityManager.getReference(User.class, id);
		entityManager.remove(user);
	}
}
