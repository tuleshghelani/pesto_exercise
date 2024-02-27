package com.tulesh.springboot.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CustomExceptionDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomException#setHttpStatus(HttpStatus)}
     *   <li>{@link CustomException#getHttpStatus()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        CustomException customException = new CustomException("An error occurred");

        // Act
        customException.setHttpStatus(HttpStatus.CONTINUE);

        // Assert that nothing has changed
        assertEquals(HttpStatus.CONTINUE, customException.getHttpStatus());
    }

    /**
     * Method under test: {@link CustomException#CustomException(String)}
     */
    @Test
    void testNewCustomException() {
        // Arrange, Act and Assert
        assertEquals(HttpStatus.NOT_FOUND, (new CustomException("An error occurred")).getHttpStatus());
        assertEquals(HttpStatus.NOT_FOUND, (new CustomException("An error occurred", new Throwable())).getHttpStatus());
        assertEquals(HttpStatus.CONTINUE,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.CONTINUE)).getHttpStatus());
        assertEquals(HttpStatus.SWITCHING_PROTOCOLS,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.SWITCHING_PROTOCOLS)).getHttpStatus());
        assertEquals(HttpStatus.PROCESSING,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.PROCESSING)).getHttpStatus());
        assertEquals(HttpStatus.CHECKPOINT,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.CHECKPOINT)).getHttpStatus());
        assertEquals(HttpStatus.OK,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.OK)).getHttpStatus());
        assertEquals(HttpStatus.CREATED,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.CREATED)).getHttpStatus());
        assertEquals(HttpStatus.ACCEPTED,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.ACCEPTED)).getHttpStatus());
        assertEquals(HttpStatus.NON_AUTHORITATIVE_INFORMATION,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.NON_AUTHORITATIVE_INFORMATION))
                        .getHttpStatus());
        assertEquals(HttpStatus.NO_CONTENT,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.NO_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.RESET_CONTENT,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.RESET_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.PARTIAL_CONTENT,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.PARTIAL_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.MULTI_STATUS,
                (new CustomException("An error occurred", new Throwable(), HttpStatus.MULTI_STATUS)).getHttpStatus());
        assertEquals(HttpStatus.CONTINUE, (new CustomException("An error occurred", HttpStatus.CONTINUE)).getHttpStatus());
        assertEquals(HttpStatus.SWITCHING_PROTOCOLS,
                (new CustomException("An error occurred", HttpStatus.SWITCHING_PROTOCOLS)).getHttpStatus());
        assertEquals(HttpStatus.PROCESSING,
                (new CustomException("An error occurred", HttpStatus.PROCESSING)).getHttpStatus());
        assertEquals(HttpStatus.CHECKPOINT,
                (new CustomException("An error occurred", HttpStatus.CHECKPOINT)).getHttpStatus());
        assertEquals(HttpStatus.OK, (new CustomException("An error occurred", HttpStatus.OK)).getHttpStatus());
        assertEquals(HttpStatus.CREATED, (new CustomException("An error occurred", HttpStatus.CREATED)).getHttpStatus());
        assertEquals(HttpStatus.ACCEPTED, (new CustomException("An error occurred", HttpStatus.ACCEPTED)).getHttpStatus());
        assertEquals(HttpStatus.NON_AUTHORITATIVE_INFORMATION,
                (new CustomException("An error occurred", HttpStatus.NON_AUTHORITATIVE_INFORMATION)).getHttpStatus());
        assertEquals(HttpStatus.NO_CONTENT,
                (new CustomException("An error occurred", HttpStatus.NO_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.RESET_CONTENT,
                (new CustomException("An error occurred", HttpStatus.RESET_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.PARTIAL_CONTENT,
                (new CustomException("An error occurred", HttpStatus.PARTIAL_CONTENT)).getHttpStatus());
        assertEquals(HttpStatus.MULTI_STATUS,
                (new CustomException("An error occurred", HttpStatus.MULTI_STATUS)).getHttpStatus());
        assertEquals(HttpStatus.ALREADY_REPORTED,
                (new CustomException("An error occurred", HttpStatus.ALREADY_REPORTED)).getHttpStatus());
        assertEquals(HttpStatus.IM_USED, (new CustomException("An error occurred", HttpStatus.IM_USED)).getHttpStatus());
        assertEquals(HttpStatus.MULTIPLE_CHOICES,
                (new CustomException("An error occurred", HttpStatus.MULTIPLE_CHOICES)).getHttpStatus());
        assertEquals(HttpStatus.MOVED_PERMANENTLY,
                (new CustomException("An error occurred", HttpStatus.MOVED_PERMANENTLY)).getHttpStatus());
        assertEquals(HttpStatus.FOUND, (new CustomException("An error occurred", HttpStatus.FOUND)).getHttpStatus());
        assertEquals(HttpStatus.MOVED_TEMPORARILY,
                (new CustomException("An error occurred", HttpStatus.MOVED_TEMPORARILY)).getHttpStatus());
        assertEquals(HttpStatus.SEE_OTHER,
                (new CustomException("An error occurred", HttpStatus.SEE_OTHER)).getHttpStatus());
    }
}
