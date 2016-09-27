package assignments.product;

/*
 * This represents the secret word to guess
 */
public class Secret {

    // MUST use this as a representation (because lab is a bit about Stings)
    private String answer;  // The word to guess
    private String mask;  // Masking the answer, initially one underscore for each char in answer.
    private String quessedCharacters;

    public Secret(String answer) {
        this.answer = answer;
        this.quessedCharacters = "";
        mask = "";
        for(int i = 0; i < answer.length(); i++) {
            mask += "_";
        }
        System.out.println("Answer: " + answer);
    }

    public boolean isValidQuess(Character character) {
        return this.quessedCharacters.indexOf(character) < 0;
    }

    public boolean isSolved() {
        return this.mask.indexOf("_") < 0;
    }

    public boolean isCorrectGuess(Character character) {
        return this.answer.indexOf(character) >= 0;
    }
    public void updateStrings(Character character) {
        String newMask = "";
        this.quessedCharacters += character;
        for(int i = 0; i < answer.length(); i++) {
            if(answer.charAt(i) == character) {
                newMask += character;
            }else {
                if(this.mask.charAt(i) != '_') {
                    newMask += this.mask.charAt(i);
                }else {
                    newMask += "_";
                }

            }
        }
        this.mask = newMask;
        System.out.println(this.mask);
    }

    // TODO


}
