import java.util.*;

public class HighestPalindrome {

    public static String highestPalindrome(String str, int k) {
        if (str.isEmpty() || k < 0) return "-1";
        if (str.length() == 1) return "9";

        char[] arr = str.toCharArray();
        return highestPalindromeHelper(arr, k, 0, arr.length - 1);
    }

    private static String highestPalindromeHelper(char[] arr, int k, int left, int right) {
        if (left >= right) return new String(arr);

        if (arr[left] != arr[right]) {
            char maxChar = (char) Math.max(arr[left], arr[right]);
            arr[left] = maxChar;
            arr[right] = maxChar;
            k--;
        }

        return k < 0 ? "-1" : highestPalindromeHelper(arr, k, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String number = "3943";
        int k = 1;

        String highestPal = highestPalindrome(number, k); // Perubahan disini
        System.out.println("Highest Palindrome: " + highestPal);
    }
}

