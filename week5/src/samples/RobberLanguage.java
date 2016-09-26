package samples;

import static java.lang.System.out;

/**
 * Convert to Robber Language
 */
public class RobberLanguage {

    public static void main(String[] args) {
        new RobberLanguage().program();
    }

    private void program() {
       // Should be:  JoJagog totalolaror rorövovarorsospoproråkoketot"
       out.println(toRobber("Jag talar rövarspråket"));

       out.println(toRobber("Jag talar rövarspråket").
               equals("JoJagog totalolaror rorövovarorsospoproråkoketot"));
    }

    // Translate to Robber language
    public String toRobber(String text) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (isVowel(ch) || Character.isWhitespace(ch)) {
                sb.append(ch);
            } else {
                sb.append(ch).append("o").append(ch);
            }
        }
        return sb.toString();
    }

    // Helper
    public boolean isVowel(char c) {
        return "aeiouyåäö".indexOf(c) > -1 || "AEIOUYÅÄÖ".indexOf(c) > -1;
    }
}
