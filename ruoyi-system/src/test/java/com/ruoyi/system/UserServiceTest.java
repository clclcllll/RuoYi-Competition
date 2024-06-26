package com.ruoyi.system;

import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAuthenticate() {
        User user = userService.authenticate("admin", "password");
        assertNotNull(user);
        assertEquals("admin", user.getUsername());
    }

    @Test
    public void testChangePassword() {
        boolean result = userService.changePassword("admin", "password", "newpassword");
        assertTrue(result);
    }
}
