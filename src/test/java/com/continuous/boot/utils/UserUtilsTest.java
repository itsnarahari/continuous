package com.continuous.boot.utils;

import com.continuous.boot.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class UserUtilsTest {
    /**
     * Method under test: {@link UserUtils#isSuccess(String)}
     */
    @Test
    void testIsSuccess() {
        assertEquals("success", UserUtils.isSuccess("jane.doe@example.org"));
        assertEquals("success", UserUtils.isSuccess("jane.doe@example.org"));
    }

    /**
     * Method under test: {@link UserUtils#get(java.util.List)}
     */
    @Test
    void testGet() {
        assertThrows(RuntimeException.class, () -> UserUtils.get(new ArrayList<>()));
    }

    /**
     * Method under test: {@link UserUtils#get(java.util.List)}
     */
    @Test
    void testGet2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by get(List)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Its empty");
        customer.setProducts(new ArrayList<>());

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        UserUtils.get(customerList);
    }

    /**
     * Method under test: {@link UserUtils#get(java.util.List)}
     */
    @Test
    void testGet3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by get(List)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName("Its empty");
        customer.setProducts(new ArrayList<>());

        Customer customer1 = new Customer();
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setName("Name");
        customer1.setProducts(new ArrayList<>());

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer);
        UserUtils.get(customerList);
    }

    /**
     * Method under test: {@link UserUtils#get(java.util.List)}
     */
    @Test
    void testGet4() {
        Customer customer = new Customer();
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setName(null);
        customer.setProducts(new ArrayList<>());

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        assertThrows(RuntimeException.class, () -> UserUtils.get(customerList));
    }
}

