package com.continuous.boot.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.continuous.boot.dao.CustomerRepository;
import com.continuous.boot.dao.ProductRepository;
import com.continuous.boot.models.Customer;
import com.continuous.boot.models.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @MockBean
    private ProductRepository productRepository;

    /**
     * Method under test: {@link CustomerService#create(Customer)}
     */
    @Test
    void testCreate() {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());
        when(this.customerRepository.save((Customer) any())).thenReturn(customer);

        Customer customer1 = new Customer();
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setName("Name");
        customer1.setProducts(new ArrayList<>());
        assertSame(customer1, this.customerService.create(customer1));
        verify(this.customerRepository).save((Customer) any());
    }

    /**
     * Method under test: {@link CustomerService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(this.customerRepository.findAll()).thenReturn(customerList);
        List<Customer> actualFindAllResult = this.customerService.findAll();
        assertSame(customerList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.customerRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerService#findAll(Long)}
     */
    @Test
    void testFindAll2() {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());
        Optional<Customer> ofResult = Optional.of(customer);
        when(this.customerRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(customer, this.customerService.findAll(123L));
        verify(this.customerRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#findAll(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.test.boot.service.CustomerService.findAll(CustomerService.java:31)
        //   In order to prevent findAll(Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findAll(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.customerRepository.findById((Long) any())).thenReturn(Optional.empty());
        this.customerService.findAll(123L);
    }

    /**
     * Method under test: {@link CustomerService#findAllProducts()}
     */
    @Test
    void testFindAllProducts() {
        ArrayList<Products> productsList = new ArrayList<>();
        when(this.productRepository.findAll()).thenReturn(productsList);
        List<Products> actualFindAllProductsResult = this.customerService.findAllProducts();
        assertSame(productsList, actualFindAllProductsResult);
        assertTrue(actualFindAllProductsResult.isEmpty());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerService#findAllProducts(Long)}
     */
    @Test
    void testFindAllProducts2() {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Name");
        customer.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setCustomer(customer);
        products.setId(123L);
        products.setProductName("Product Name");
        when(this.productRepository.findProductsByCustomer((Long) any())).thenReturn(products);
        assertSame(products, this.customerService.findAllProducts(123L));
        verify(this.productRepository).findProductsByCustomer((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#findAllCustom()}
     */
    @Test
    void testFindAllCustom() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(this.customerRepository.findAllCustom()).thenReturn(customerList);
        List<Customer> actualFindAllCustomResult = this.customerService.findAllCustom();
        assertSame(customerList, actualFindAllCustomResult);
        assertTrue(actualFindAllCustomResult.isEmpty());
        verify(this.customerRepository).findAllCustom();
    }
}

