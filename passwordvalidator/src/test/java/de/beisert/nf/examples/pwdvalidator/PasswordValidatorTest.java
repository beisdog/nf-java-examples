package de.beisert.nf.examples.pwdvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = { "short", "nonumberinthis", "12345678", "DavidIstToll1" })
    public void testPasswordInvalid(String password) {
        String message = PasswordValidator.validatePasswordAndGetMessage(password);
        System.out.println(String.format("'%s' validates to: %s", password, message));
        Assertions.assertNotEquals(PasswordValidator.MESSAGE_VALID, message);
    }

    @ParameterizedTest
    @ValueSource(strings = { "DavidIstToll1%", "Wr89434kj?=)" })
    public void testPasswordValid(String password) {
        String message = PasswordValidator.validatePasswordAndGetMessage(password);
        System.out.println(String.format("'%s' validates to: %s", password, message));
        Assertions.assertEquals(PasswordValidator.MESSAGE_VALID, message);
    }
}
