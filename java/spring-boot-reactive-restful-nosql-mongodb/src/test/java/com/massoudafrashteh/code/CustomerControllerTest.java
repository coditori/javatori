package com.massoudafrashteh.code;

import com.massoudafrashteh.code.application.Application;
import com.massoudafrashteh.code.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes=Application.class,
        webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    private final Customer newCustomer = new Customer();
    private static String id;
    private final static String SAMPLE_ID = "5adde2c25671d31692ac2a55";

    @Before
    public void setup() {
        newCustomer.setName(new Date().toString());
    }

    @Test
    public void test1_delete_customer_failure() {
        webTestClient.delete().uri("/customers/{id}", SAMPLE_ID)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody()
                .isEmpty();
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
        System.out.println("id " + id);
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
        webTestClient.get().uri("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Customer.class).hasSize(1);
    }

//    @Test
    public void test5_delete_customer_done() {
        webTestClient.delete().uri("/customers/{id}", id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void test6_find_customer_failure() {
        webTestClient.get().uri("/customers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody()
                .isEmpty();
    }
}
