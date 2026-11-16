import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> answer = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int letters = 0;

            // Find words that can fit in the line
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int spaces = maxWidth - letters;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Handle last line or single word
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            else {

                int space = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int count = space;

                        if (extra > 0) {
                            count++;
                            extra--;
                        }

                        for (int x = 0; x < count; x++) {
                            line.append(" ");
                        }
                    }
                }
            }

            answer.add(line.toString());

            i = j;
        }

        return answer;
    }
}