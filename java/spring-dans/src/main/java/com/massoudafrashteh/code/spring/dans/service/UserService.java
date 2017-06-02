package com.massoudafrashteh.code.spring.dans.service;

import java.util.List;

import com.massoudafrashteh.code.spring.dans.domain.User;

public interface UserService {

	/**
	 * Adds a new <code>User</code> to Database if passed <code>User</code> does not already exist.
	 * 
	 * @param user
	 *            should be a new <code>User</code>
	 * @return User
	 */
	public User save(User user);

	/**
	 * Finds and returns <code>User</code> based on passed user <code>id</code>
	 * 
	 * @param id
	 *            user primary key
	 * @return <code>User</code> if <code>id</code> exists in Database; <code>null</code> otherwise.
	 * @see User
	 */
	public User findById(long id);

	/**
	 * Returns a <code>User</code> <code>List</code> from Database.
	 * 
	 * @return A <code>List</code> of <code>User</code> objects; <code>null</code> otherwise.
	 */
	public List<User> findAll();

	/**
	 * Update an exist <code>User</code> in Database.
	 * 
	 * @param user
	 *            should be a exist <code>User</code>
	 * @return User
	 */
	public User update(User user);

	/**
	 * Deletes a specific <code>User</code> based on passed user <code>id</code>
	 * 
	 * @param id
	 *            used for finding <code>User</code> in Database.
	 */
	public void deleteById(long id);

}
