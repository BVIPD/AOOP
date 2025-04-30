package Module1c;
public class CaesarCipher {

    // Encrypt a string with a given shift
    public static String encrypt(String text, int shift) {
        if (text == null) {
            return null;
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c); // Non-letter characters remain unchanged
            }
        }
        return encryptedText.toString();
    }

    // Decrypt a string with a given shift
    public static String decrypt(String text, int shift) {
        if (text == null) {
            return null;
        }

        return encrypt(text, 26 - shift); // Decrypting is the reverse of encryption
    }
}
