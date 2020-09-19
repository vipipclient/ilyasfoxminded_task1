import java.util.*;
/**
 * This is my first task on FoxMinded course.
 *
 * @version 1.0 19 Sep 2020
 * @author ILyas Berdibekov
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("This is my first task on FoxMinded course");
        Scanner in = new Scanner(System.in);
        System.out.print("Input text: ");
        String inputText = in.nextLine();
        Anagram anagram = new Anagram();
        System.out.println("Anagram: ");
        System.out.print(anagram.makeAnagrams(inputText));
    }
}
