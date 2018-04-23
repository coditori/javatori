package com.massoudafrashteh.code;

import com.massoudafrashteh.code.application.Application;
import com.massoudafrashteh.code.model.Customer;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes=Application.class,
        webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    private Customer newCustomer = new Customer();

    @Before
    public void setup() {
        newCustomer.setName("Massoud");
    }

    @Test
    public void test1_delete_customer_failure() {
        webTestClient.delete().uri("/customers/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    public void test2_add_customer_done() {
        webTestClient.post().uri("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(newCustomer))
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.name")
                .isEqualTo(newCustomer.getName());
    }

    @Test
    public void test3_find_customer_done() {
        webTestClient.get().uri("/customers/{id}", 1)
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
        webTestClient.delete().uri("/customers/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void test6_find_customer_failure() {
        webTestClient.get().uri("/customers/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
