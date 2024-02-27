package com.tulesh.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testGetAuthorities() {
        // Arrange, Act and Assert
        assertTrue((new User()).getAuthorities().isEmpty());
    }

    @Test
    void testIsEnabled() {
        // Arrange, Act and Assert
        assertTrue((new User()).isEnabled());
        assertFalse(
                (new User(1L, "templNametempfName", "password", "templName", "tempfName", "templName.tempfName@example.org", "6625550144", "Profile", false))
                        .isEnabled());
    }

    @Test
    void testSetEnabled() {
        // Arrange
        User user = new User();

        // Act
        user.setEnabled(true);

        // Assert
        assertTrue(user.getEnabled());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        User actualUser = new User();
        actualUser.setEmail("templName.tempfName@example.org");
        actualUser.setFirstName("templName");
        actualUser.setId(1L);
        actualUser.setLastName("tempfName");
        actualUser.setPassword("password");
        actualUser.setPhone("6625550144");
        actualUser.setProfile("Profile");
        actualUser.setUsername("templNametempfName");
        String actualToStringResult = actualUser.toString();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        Long actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        String actualPassword = actualUser.getPassword();
        String actualPhone = actualUser.getPhone();
        String actualProfile = actualUser.getProfile();
        String actualUsername = actualUser.getUsername();
        boolean actualIsAccountNonExpiredResult = actualUser.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = actualUser.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = actualUser.isCredentialsNonExpired();

        // Assert that nothing has changed
        assertEquals("6625550144", actualPhone);
        assertEquals("tempfName", actualLastName);
        assertEquals("templName", actualFirstName);
        assertEquals("Profile", actualProfile);
        assertEquals("User{id=1, username='templNametempfName', password='password', firstName='templName', lastName='tempfName', email='templName.tempfName"
                + "@example.org', phone='6625550144', profile='Profile', enabled=true}", actualToStringResult);
        assertEquals("password", actualPassword);
        assertEquals("templName.tempfName@example.org", actualEmail);
        assertEquals("templNametempfName", actualUsername);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        User actualUser = new User(1L, "templNametempfName", "password", "templName", "tempfName", "templName.tempfName@example.org", "6625550144",
                "Profile", true);
        actualUser.setEmail("templName.tempfName@example.org");
        actualUser.setFirstName("templName");
        actualUser.setId(1L);
        actualUser.setLastName("tempfName");
        actualUser.setPassword("password");
        actualUser.setPhone("6625550144");
        actualUser.setProfile("Profile");
        actualUser.setUsername("templNametempfName");
        String actualToStringResult = actualUser.toString();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        Long actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        String actualPassword = actualUser.getPassword();
        String actualPhone = actualUser.getPhone();
        String actualProfile = actualUser.getProfile();
        String actualUsername = actualUser.getUsername();
        boolean actualIsAccountNonExpiredResult = actualUser.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = actualUser.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = actualUser.isCredentialsNonExpired();

        // Assert that nothing has changed
        assertEquals("6625550144", actualPhone);
        assertEquals("tempfName", actualLastName);
        assertEquals("templName", actualFirstName);
        assertEquals("Profile", actualProfile);
        assertEquals("User{id=1, username='templNametempfName', password='password', firstName='templName', lastName='tempfName', email='templName.tempfName"
                + "@example.org', phone='6625550144', profile='Profile', enabled=true}", actualToStringResult);
        assertEquals("password", actualPassword);
        assertEquals("templName.tempfName@example.org", actualEmail);
        assertEquals("templNametempfName", actualUsername);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        User actualUser = new User("Testuser", "password");
        actualUser.setEmail("templName.tempfName@example.org");
        actualUser.setFirstName("templName");
        actualUser.setId(1L);
        actualUser.setLastName("tempfName");
        actualUser.setPassword("password");
        actualUser.setPhone("6625550144");
        actualUser.setProfile("Profile");
        actualUser.setUsername("templNametempfName");
        String actualToStringResult = actualUser.toString();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        Long actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        String actualPassword = actualUser.getPassword();
        String actualPhone = actualUser.getPhone();
        String actualProfile = actualUser.getProfile();
        String actualUsername = actualUser.getUsername();
        boolean actualIsAccountNonExpiredResult = actualUser.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = actualUser.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = actualUser.isCredentialsNonExpired();

        // Assert that nothing has changed
        assertEquals("6625550144", actualPhone);
        assertEquals("tempfName", actualLastName);
        assertEquals("templName", actualFirstName);
        assertEquals("Profile", actualProfile);
        assertEquals("User{id=1, username='templNametempfName', password='password', firstName='templName', lastName='tempfName', email='templName.tempfName"
                + "@example.org', phone='6625550144', profile='Profile', enabled=true}", actualToStringResult);
        assertEquals("password", actualPassword);
        assertEquals("templName.tempfName@example.org", actualEmail);
        assertEquals("templNametempfName", actualUsername);
        assertEquals(1L, actualId.longValue());
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
    }
}
