package org.example.Tasks;

/*

А роза упала на лапу азора - true
Madam, I'm Adam! - true
Аргентина манит негра - true
ttt 4t tt - true

*/

public class Palindrome {
    public static void main(String[] args)
    {
        System.out.print(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {
        int n = text.length();
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) != text.charAt(n-1-i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
