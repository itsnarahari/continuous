package com.continuous;

import com.continuous.boot.models.Users;
import com.continuous.boot.service.UserService;
import com.continuous.boot.service.UtilsResponse;
import com.continuous.boot.utils.UserUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.test.boot.utils.*")
public class StaticMethodMockTest {

    @InjectMocks
    UserService userService;


    @Before
    public void setUp() {
        openMocks(UserUtils.class);
    }

    @Test
    public void test() {
        // Given
        String email = "abc@gmail.com";
        Users users = new Users(34, "test", "test@gmail.com");
        PowerMockito.mockStatic(UserUtils.class);

        // When
        when(UserUtils.isSuccess(email)).thenReturn("success");

        // Then
        UtilsResponse response = userService.staticMockTest(users);
        assertEquals("success", "success");
    }
}
