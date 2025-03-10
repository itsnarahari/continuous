package com.continuous.boot.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.continuous.boot.dao.ProductRepository;
import com.continuous.boot.models.Customer;
import com.continuous.boot.models.Products;
import com.continuous.boot.service.CustomerService;

import java.io.IOException;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ProductRepository productRepository;

    /**
     * Method under test: {@link CustomerController#download()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDownload() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'first.txt', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new CustomerController()).download();
    }

    /**
     * Method under test: {@link CustomerController#create(Customer)}
     */
    @Test
    void testCreate() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());
        when(this.customerService.create((Customer) any())).thenReturn(customer);

        Customer customer1 = new Customer();
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setName("Name");
        customer1.setProducts(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(customer1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"products\":[]}"));
    }

    /**
     * Method under test: {@link CustomerController#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        when(this.customerService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findAll()}
     */
    @Test
    void testFindAll2() throws Exception {
        when(this.customerService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/customer");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findAll(Long)}
     */
    @Test
    void testFindAll3() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());
        when(this.customerService.findAll((Long) any())).thenReturn(customer);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"products\":[]}"));
    }

    /**
     * Method under test: {@link CustomerController#findAll(Long)}
     */
    @Test
    void testFindAll4() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());
        when(this.customerService.findAll((Long) any())).thenReturn(customer);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/customer/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"products\":[]}"));
    }

    /**
     * Method under test: {@link CustomerController#findAllCustom()}
     */
    @Test
    void testFindAllCustom() throws Exception {
        when(this.customerService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/custom");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findAllCustom()}
     */
    @Test
    void testFindAllCustom2() throws Exception {
        when(this.customerService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/customer/custom");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findAllProducts()}
     */
    @Test
    void testFindAllProducts() throws Exception {
        when(this.productRepository.findAll((org.springframework.data.domain.Sort) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findAllProducts()}
     */
    @Test
    void testFindAllProducts2() throws Exception {
        when(this.productRepository.findAll((org.springframework.data.domain.Sort) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/products");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#findProductsById(Long)}
     */
    @Test
    void testFindProductsById() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setCustomer(customer);
        products.setId(123L);
        products.setProductName("Product Name");
        when(this.customerService.findAllProducts((Long) any())).thenReturn(products);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"productName\":\"Product Name\"}"));
    }

    /**
     * Method under test: {@link CustomerController#findProductsById(Long)}
     */
    @Test
    void testFindProductsById2() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setCustomer(customer);
        products.setId(123L);
        products.setProductName("Product Name");
        when(this.customerService.findAllProducts((Long) any())).thenReturn(products);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/products/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"productName\":\"Product Name\"}"));
    }
}

