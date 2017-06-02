package com.massoudafrashteh.code.spring.dans.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.massoudafrashteh.code.spring.dans.domain.User;
import com.massoudafrashteh.code.spring.dans.repository.UserRepository;
import com.massoudafrashteh.code.spring.dans.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void save() {
		final User user = new User(1L, "Massoud");
		when(userRepository.save(user)).thenReturn(user);
		final User finalUser = userService.save(user);
		assertThat(finalUser, is(notNullValue()));
		assertThat(finalUser.getId(), is(equalTo(user.getId())));
		assertThat(finalUser.getFirstName(), is(equalTo(user.getFirstName())));
	}

	@Test
	public void findById() {
		final User user = new User(1L, "Massoud");
		when(userRepository.findOne(user.getId())).thenReturn(user);
		final User finalUser = userService.findById(user.getId());
		assertThat(finalUser, is(notNullValue()));
		assertThat(finalUser.getId(), is(equalTo(user.getId())));
		assertThat(finalUser.getFirstName(), is(equalTo(user.getFirstName())));
	}

	@Test
	public void findByIdNotFound() {
		final User user = new User(999L, "wow");
		when(userRepository.findOne(user.getId())).thenReturn(null);
		final User finalUser = userService.findById(user.getId());
		assertThat(finalUser, is(nullValue()));
	}

	@Test
	public void findAll() {
		final List<User> users = new ArrayList<>();
		users.add(new User(1L, "Massoud"));
		users.add(new User(2L, "David"));
		users.add(new User(3L, "Jon"));
		when(userRepository.findAll()).thenReturn(users);
		final List<User> finalUsers = userService.findAll();
		assertThat(finalUsers.size(), is(equalTo(users.size())));
		assertThat(finalUsers.get(0).getId(), is(equalTo(users.get(0).getId())));
		assertThat(finalUsers.get(1).getId(), is(equalTo(users.get(1).getId())));
		assertThat(finalUsers.get(2).getId(), is(equalTo(users.get(2).getId())));
	}

	@Test
	public void update() {
		final User user = new User(1L, "Massoud");
		when(userRepository.save(user)).thenReturn(user);
		when(userRepository.findOne(user.getId())).thenReturn(user);
		final User foundUser = userService.findById(user.getId());
		assertThat(foundUser.getId(), is(equalTo(user.getId())));
		final String newName = new String("Jon");
		foundUser.setFirstName(newName);
		final User updatedUser = userService.update(foundUser);
		assertThat(updatedUser.getId(), is(equalTo(user.getId())));
		assertThat(updatedUser.getFirstName(), is(equalTo(newName)));
	}

	@Test
	public void deleteById() {
		final User user = new User(1L, "Massoud");
		userService.deleteById(user.getId());
		verify(userRepository, times(1)).delete(user.getId());
	}

}
