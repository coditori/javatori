package restful.repository;

import java.util.List;

import restful.model.User;

public interface UserRepository {
	/**
	 * Returns a <code>User</code> <code>List</code> from Database.
	 * 
	 * @return A <code>List</code> of <code>User</code> objects; <code>null</code> otherwise.
	 */
	public List<User> findAll();

	/**
	 * Finds and returns <code>User</code> based on passed user <code>id</code>
	 * 
	 * @param id
	 *            user primary key
	 * @return <code>User</code> if <code>id</code> exists in Database; <code>null</code> otherwise.
	 *         id
	 * @see User
	 */
	public User findById(final Long id);

	/**
	 * Adds a new <code>User</code> to Database if passed <code>User</code> does not already exist.
	 * 
	 * @param user
	 *            new <code>User</code>
	 */
	public void add(final User user);

	/**
	 * Deletes a specific <code>User</code> based on passed user <code>id</code>
	 * 
	 * @param id
	 *            used for finding <code>User</code> in Database.
	 */
	public void deleteById(final long id);
}
