package Tasks;

public class Palindrome {
    public static void main(String[] args)
    {
        System.out.print(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {
        String result = text.replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder resultReverse = new StringBuilder(result);
        resultReverse.reverse();

        return result.equalsIgnoreCase(resultReverse.toString());
    }
}
