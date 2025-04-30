package Module1c;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarCipherTest {

    // Test encryption with a shift of 3
    @Test
    public void testEncryption() {
        String input = "Hello, World!";
        String expected = "Khoor, Zruog!";
        assertEquals(expected, CaesarCipher.encrypt(input, 3));
    }

    // Test decryption with a shift of 3
    @Test
    public void testDecryption() {
        String encrypted = "Khoor, Zruog!";
        String expected = "Hello, World!";
        assertEquals(expected, CaesarCipher.decrypt(encrypted, 3));
    }

    // Test decryption to ensure it works with the reverse shift
    @Test
    public void testDecryptToOriginal() {
        String input = "Caesar Cipher!";
        int shift = 5;
        String encrypted = CaesarCipher.encrypt(input, shift);
        String decrypted = CaesarCipher.decrypt(encrypted, shift);
        assertEquals(input, decrypted);
    }

    // Test edge case with empty string (encryption and decryption)
    @Test
    public void testEmptyString() {
        String emptyString = "";
        assertEquals("", CaesarCipher.encrypt(emptyString, 3));
        assertEquals("", CaesarCipher.decrypt(emptyString, 3));
    }

    // Test edge case with null input (encryption and decryption)
    @Test
    public void testNullInput() {
        assertNull(CaesarCipher.encrypt(null, 3));
        assertNull(CaesarCipher.decrypt(null, 3));
    }

    // Test edge case with non-letter characters
    @Test
    public void testNonLetterCharacters() {
        String input = "1234 !@#$";
        assertEquals("1234 !@#$", CaesarCipher.encrypt(input, 5));
        assertEquals("1234 !@#$", CaesarCipher.decrypt(input, 5));
    }

    // Test with a shift of 0 (should return the original string)
    @Test
    public void testNoShift() {
        String input = "No Shift";
        assertEquals(input, CaesarCipher.encrypt(input, 0));
        assertEquals(input, CaesarCipher.decrypt(input, 0));
    }
}
