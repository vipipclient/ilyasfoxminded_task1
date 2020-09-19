import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * This class generates anagrams
 *
 * @version 1.0 19 Sep 2020
 * @author ILyas Berdibekov
 */
public class Anagram {
    String makeAnagrams(String textToReverse){
        StringTokenizer wordTokenizer = new StringTokenizer(textToReverse);
        StringBuffer anagramsBuf = new StringBuffer();

        while (wordTokenizer.hasMoreTokens()){
            String reversedWord = reverseWord(wordTokenizer.nextToken());
            anagramsBuf.append(reversedWord + " ");

        }
        return anagramsBuf.toString();
    }

    private String reverseWord(String word) {

        List<Character> originalSequenceList;       /*In this list numbers will be on their places*/
        LinkedList<Character> onlyLetters;          /*this list will be reversed*/

        originalSequenceList= new ArrayList<Character>();
        onlyLetters = new LinkedList<Character>();

        /*Fill characterList and onlyLetters lists*/
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            originalSequenceList.add(c);
            if (isNotDigit(c)){
                onlyLetters.add(c);
            }
        }
        return BuildOnlyLettersReversedSequence(originalSequenceList,onlyLetters);
    }

    private String BuildOnlyLettersReversedSequence(List<Character> originalSequenceList,
                                                           LinkedList<Character> onlyLetters) {
        List<Character> characterList = new ArrayList<Character>();
        characterList.addAll(originalSequenceList);
        char c;
        for (int i = 0; i < characterList.size(); i++) {
            c = characterList.get(i);
            if (isNotDigit(c)){
                characterList.set(i,onlyLetters.removeLast());
            }
        }
        String reversedWord = getStringRepresentation(characterList);
        return reversedWord;
    }

    private String getStringRepresentation(List<Character> characterList) {
        StringBuilder stringBuilder = new StringBuilder(characterList.size());
        for (Character ch:characterList) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static boolean isNotDigit(char symbol) {
        return !Character.isDigit(symbol);
    }
}
