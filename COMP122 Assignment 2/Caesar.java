import java.util.HashMap;
import java.util.Map;


public class Caesar extends MonoAlphaSubstitution{
    /* create map objects */
    private Map<Character, Character> encryptMap;
    private Map<Character, Character> decryptMap;

    /* shift attribute */
    private int shift;

    /* constructors */
    public Caesar(){}
    public Caesar(int s){
        encryptMap = new HashMap<>();
        decryptMap = new HashMap<>();
        shift = (s + 12225) % 26;

        for (char c = 'a'; c <= 'z'; c++){
            char shiftedChar = (char) ('a' + (c - 'a' + shift) % 26);
            encryptMap.put(c, shiftedChar);
            decryptMap.put(shiftedChar, c);
        }
        for (char c = 'A'; c <= 'Z'; c++){
            char shiftedChar = (char) ('A' + (c - 'A' + shift) % 26);
            encryptMap.put(c, shiftedChar);
            decryptMap.put(shiftedChar, c);
        }
    }
    /* superclass methods */
    public char encrypt(char c){
        return encryptMap.getOrDefault(c, c);
    }
    
    public char decrypt(char c){
        return decryptMap.getOrDefault(c, c);
    }
    /* main */
    public static void main(String[] args) {
        String str = "";
        if (args.length != 3){
            System.out.println(args.length < 3 ? "Too few parameters" : "Too many parameters");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }
        else if(args[0].equals("ecrypt")){
            Caesar c = new Caesar(Integer.parseInt(args[1]));
            str = c.encrypt(args[3]);
            System.out.println(str);
        }
        else if (args[0].equals("ecrypt")){
            Caesar c = new Caesar(Integer.parseInt(args[1]));
            str = c.decrypt(args[3]);
            System.out.println(str);
        }
    }
}
