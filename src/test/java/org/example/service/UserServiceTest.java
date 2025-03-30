package org.example.service;

import org.example.dao.UserRepository;
import org.example.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("Should get user successfully")
    void shouldGetUserSuccessfully() {
        // Arrange
        Long userId = 1L;
        User expectedUser = new User(userId, "John Doe", "john@example.com");
        when(userRepository.findById(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertNotNull(actualUser);
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    @DisplayName("Should throw exception when user ID is null")
    void shouldThrowExceptionWhenUserIdIsNull() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> userService.getUserById(null));
    }

    @Test
    @DisplayName("Should create user successfully")
    void shouldCreateUserSuccessfully() {
        // Arrange
        User user = new User(1L, "Jane Doe", "jane@example.com");
        when(userRepository.save(user)).thenReturn(true);

        // Act
        boolean result = userService.createUser(user);

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Should throw exception when creating user with null values")
    void shouldThrowExceptionWhenCreatingUserWithNullValues() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser(null));
    }
}


