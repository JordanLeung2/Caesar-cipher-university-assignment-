abstract class Substitution implements Cipher{

    /* Abstract methods, yeah i dunno what else */
    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    /* basic encrypt and decryot methods */
    public String encrypt(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            result.append(encrypt(c));
        }
        return result.toString();
    }

    public String decrypt(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            result.append(decrypt(c));
        }
        return result.toString();
    }
}
