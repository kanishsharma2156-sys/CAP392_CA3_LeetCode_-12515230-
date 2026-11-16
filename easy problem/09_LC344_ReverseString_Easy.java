class Solution {
    public void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start < end) {

            // Store the first character
            char temp = s[start];

            // Swap first and last characters
            s[start] = s[end];
            s[end] = temp;

            // Move towards the middle
            start++;
            end--;
        }
    }
}