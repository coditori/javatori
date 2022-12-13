package com.massoudafrashteh.code;

import com.massoudafrashteh.code.application.Application;
import com.massoudafrashteh.code.model.Customer;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes=Application.class,
        webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int port;

    private Customer newCustomer = new Customer();
    private static final Long SAMPLE_ID = 999L;
    private static Long id;

    @Before
    public void setup() {
        newCustomer.setName("Massoud");
    }

    @Test
    public void test1_delete_customer_failure() {
        webTestClient.delete().uri("/customers/{id}", SAMPLE_ID)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    public void test2_add_customer_done() {
        WebClient webClient = WebClient.create("http://localhost:" + port);
        Customer customer = webClient.post().uri("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(newCustomer))
                .retrieve()
                .bodyToMono(Customer.class)
                .block();

        id = customer.getId();
        assertThat(customer.getName(), is(newCustomer.getName()));
    }

    @Test
    public void test3_find_customer_done() {
        webTestClient.get().uri("/customers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name")
                .isEqualTo(newCustomer.getName());
    }

    @Test
    public void test4_findAll_customer_done() {
        Flux<Customer> customers = webTestClient.get().uri("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Customer.class).getResponseBody();

        StepVerifier
                .create(customers)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void test5_delete_customer_done() {
        webTestClient.delete().uri("/customers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void test6_find_customer_failure() {
        webTestClient.get().uri("/customers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
