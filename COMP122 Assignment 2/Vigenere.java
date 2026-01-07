
public class Vigenere extends Substitution {
    /* Attributes */
    private String key;
    private int keyIndex;
    /* Object Constructors */
    public Vigenere() {
        this.key = "A";
        this.keyIndex = 0;
    }

    public Vigenere(String key) {
        this.key = key;
        this.keyIndex = 0;
    }

    /* Override Encrypt and Decrypt methods */
    @Override
    public char encrypt(char c) {
        if (!Character.isLetter(c)) {
            keyIndex = (keyIndex + 1) % key.length();
            return c;
        }
        char base = Character.isUpperCase(c) ? 'A' : 'a';
        int shift = key.charAt(keyIndex % key.length()) - 'A'; 
        char encrypted = (char) ((c - base + shift) % 26 + base);
        keyIndex = (keyIndex + 1) % key.length();
        return encrypted;
    }

    @Override
    public char decrypt(char c) {
        if (!Character.isLetter(c)) {
            keyIndex = (keyIndex + 1) % key.length();
            return c;
        }
        char base = Character.isUpperCase(c) ? 'A' : 'a';
        int shift = key.charAt(keyIndex % key.length()) - 'A'; 
        char decrypted = (char) ((c - base - shift + 26) % 26 + base);
        keyIndex = (keyIndex + 1) % key.length();
        return decrypted;
    }

    /* main. */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(args.length < 3 ? "Too few parameters!" : "Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        String mode = args[0];
        String key = args[1];
        String text = args[2];

        if (!mode.equals("encrypt") && !mode.equals("decrypt")) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        Vigenere cipher = new Vigenere(key);
        String result = mode.equals("encrypt") ? cipher.encrypt(text) : cipher.decrypt(text);

        System.out.println(result);
}
}
