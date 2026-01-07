import java.util.HashMap;
import java.util.Map;

public class MonoAlphaSubstitution extends Substitution {
    /* create map objects */
    private Map<Character, Character> encryptMap;
    private Map<Character, Character> decryptMap;

    /* constructors */
    public MonoAlphaSubstitution(){
        encryptMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++){
            encryptMap.put(c,c);
        }
        for (char c = 'A'; c <= 'A'; c++){
            encryptMap.put(c,c);
        }
    }

    public MonoAlphaSubstitution(String s){
        encryptMap = new HashMap<>();
        decryptMap = new HashMap<>();
        for (int i=0; i<s.length(); i+=2){
            encryptMap.put(s.charAt(i),s.charAt(i+1));
            decryptMap.put(s.charAt(i+1),s.charAt(i));
        }
    }

    /* implements superclass methods */
    public char encrypt(char c){
        return encryptMap.getOrDefault(c, c);
    }
    
    public char decrypt(char c){
        return decryptMap.getOrDefault(c, c);
    }

    /* main */
    public static void main(String[] args) {
        if (args.length < 3){
            System.out.println("Too few parameters!\n" + //
                                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        else if (args.length > 3){
            System.out.println("Too many parameters!\n" + //
                                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        else if (args[0].equals("encrypt")){
            String str = "";
            MonoAlphaSubstitution m = new MonoAlphaSubstitution(args[1]);
            str += m.encrypt(args[2]);
            System.out.println(str);
        }
        else if (args[0].equals("decrypt")){
            String str = "";
            MonoAlphaSubstitution m = new MonoAlphaSubstitution(args[1]);
            str += m.decrypt(args[2]);
            System.out.println(str);
        }
        else{
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\n" + //
                                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
    }
}
