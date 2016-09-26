package assignments.basics;

import java.util.Scanner;

import static java.lang.System.*;

/*
 * This program translates from English to Pig latin
 * See,https://en.wikipedia.org/wiki/Pig_Latin
 */
public class PigLatin {

    public static void main(String[] args) {
        new PigLatin().program();
    }

    private final Scanner scan = new Scanner(in);
	
	final String vowels = "aeiouåäöAEIOUÅÄÖ";

    private void program() {
        /*
        // Only for english
        out.println(toPigLatin("My name is Eric").equals("yMay amenay isway Ericway"));
		*/
        // Kill with Ctrl + c or let IntelliJ do it
        out.println(toPigLatin("My name is Eric").equals("yMay amenay isway Ericway"));

        while (true) {
            String line = scan.nextLine();
            out.println(toPigLatin(line));
        }
        
    }

    // Write method toPigLatin (use functional decomposition!)
	String toPigLatin(String input)
	{
        int firstVowelIndex = 0;
		String pigLatin = "";

        String[] words = input.split(" ");

        for(int j = 0; j < words.length; j++)
        {
            //check if first char is a vowel, if not skip to end
            if(vowels.contains("" + words[j].charAt(0)))
            {

                for (int i=0; i < words[j].length(); i++)
                {
                    firstVowelIndex = 0;
                    char character=input.charAt(i);
                    if(vowels.contains(""+Character.toString(character)))
                    {
                        firstVowelIndex=i; //storing the index of the first vowel
                        break;
                    }


                }

                //split and create new word
                String afterVowel = words[j].substring(firstVowelIndex, words[j].length());
                String beforeVowel = words[j].substring(0, firstVowelIndex) + "way";
                words[j] = afterVowel + beforeVowel;

            }
            else
            {
                //Move Consonant to end and then add "way"
                String afterConsonant = words[j].substring(1, words[j].length());
                words[j] = afterConsonant + words[j].charAt(0);
                words[j] += "ay";
            }
            //add to returnstring
            pigLatin += words[j];

            if(j < words.length -1)
            {
                //add space if not final word
                pigLatin += " ";

            }
        }



		return pigLatin;
		
		
	}

}
