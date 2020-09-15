import java.util.*;
/**
 * This is my first task on FoxMinded course.
 *
 * @version 1.0 15 Sep 2020
 * @author ILyas Berdibekov
 */
public class AnagramsUtil {

    public static void main(String[] args) {
        System.out.println("This is my first task on FoxMinded course");
        Scanner in = new Scanner(System.in);
        System.out.print("Input text: ");
        String inputText = in.nextLine();

        System.out.println(makeAnagrams(inputText));
    }

    /**
     * Scans input string and parses it into words.
     * @return  parsed text.
     */
    static String makeAnagrams(String textToReverse){
        StringTokenizer wordTokenizer = new StringTokenizer(textToReverse);
        StringBuffer anagramsBuf = new StringBuffer();

        while (wordTokenizer.hasMoreTokens()){
            String reversedWord = reverseWord(wordTokenizer.nextToken());
            anagramsBuf.append(reversedWord + " ");

        }
        return anagramsBuf.toString();
    }

    /**
     * Returns reversed word
     */
    private static String reverseWord(String word) {

        List<Character> originalSequenceList;              /*In this List numbers will be on their places*/
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

    private static String BuildOnlyLettersReversedSequence(List<Character> originalSequenceList,
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



    private static String getStringRepresentation(List<Character> characterList) {
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
