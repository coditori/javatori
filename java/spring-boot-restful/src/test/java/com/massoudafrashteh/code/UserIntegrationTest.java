package com.massoudafrashteh.code;

import com.massoudafrashteh.code.application.Application;
import com.massoudafrashteh.code.domain.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = Application.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String ENDPOINT = "/users";
    private static final User newUser = new User();
    private static Long id;

    @Before
    public void setup() {
        newUser.setFirstName("Massoud");
    }

    @Test
    public void test0_add_game_success() {
        ResponseEntity<User> user = restTemplate.postForEntity(ENDPOINT,
                new HttpEntity<User>(newUser),
                User.class);
        System.out.println("newUser " + user);
        id = user.getBody().getId();

        assertThat(user.getStatusCode(),
                is(equalTo(HttpStatus.CREATED)));
        assertThat(user.getBody().getFirstName(),
                is(equalTo(newUser.getFirstName())));
    }

    @Test
    public void test1_add_game_failure() {
        ResponseEntity<User> user = restTemplate.exchange(ENDPOINT,
                HttpMethod.POST,
                null,
                User.class);

        assertThat(user.getStatusCode(),
                not(equalTo(HttpStatus.CREATED)));
    }

    @Test
    public void test2_find_game_success() {
        System.out.println("id " + id);
        ResponseEntity<User> user = restTemplate.getForEntity(ENDPOINT + "/" + id,
                User.class);

        assertThat(user.getStatusCode(),
                is(equalTo(HttpStatus.OK)));
        assertThat(user.getBody().getFirstName(),
                is(equalTo(newUser.getFirstName())));
    }

    @Test
    public void test3_findall_game_success() {
        ResponseEntity<User[]> games = restTemplate.getForEntity(ENDPOINT,
                User[].class);

        assertThat(games.getStatusCode(),
                is(equalTo(HttpStatus.OK)));
        assertThat(games.getBody().length,
                is(equalTo(1)));
    }

    @Test
    public void test4_update_game_success() {
        newUser.setFirstName("New name");
        ResponseEntity<User> user = restTemplate.exchange(ENDPOINT + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<User>(newUser),
                User.class);

        assertThat(user.getStatusCode(),
                is(equalTo(HttpStatus.OK)));
        assertThat(user.getBody().getLastName(),
                is(equalTo(newUser.getLastName())));
    }


    @Test
    public void test5_delete_game_success() {
        ResponseEntity<String> response = restTemplate.exchange(ENDPOINT + "/" + id,
                HttpMethod.DELETE,
                null,
                String.class);

        assertThat(response.getStatusCode(),
                is(equalTo(HttpStatus.OK)));
    }

    @Test
    public void test6_find_game_failure() {
        ResponseEntity<User> user = restTemplate.getForEntity(ENDPOINT + "/" + id,
                User.class);

        assertThat(user.getStatusCode(),
                not(equalTo(HttpStatus.OK)));
    }


    @Test
    public void test7_findall_game_failure() {
        ResponseEntity<User[]> games = restTemplate.getForEntity(ENDPOINT,
                User[].class);

        assertThat(games.getStatusCode(),
                is(equalTo(HttpStatus.OK)));
        assertThat(games.getBody().length,
                is(equalTo(0)));
    }

    @Test
    public void test8_update_game_failure() {
        newUser.setFirstName("New name");
        ResponseEntity<User> user = restTemplate.exchange(ENDPOINT + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<User>(newUser),
                User.class);

        assertThat(user.getStatusCode(),
                not(equalTo(HttpStatus.OK)));
    }

    @Test
    public void test9_delete_game_failure() {
        ResponseEntity<String> response = restTemplate.exchange(ENDPOINT + "/" + id,
                HttpMethod.DELETE,
                null,
                String.class);

        assertThat(response.getStatusCode(),
                not(equalTo(HttpStatus.OK)));
    }
}
