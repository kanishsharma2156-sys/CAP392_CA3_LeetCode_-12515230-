class Solution {
    public boolean isNumber(String s) {

        boolean hasDigit = false;
        boolean hasDot = false;
        boolean hasE = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            }

            else if (ch == '+' || ch == '-') {

                if (i != 0 && s.charAt(i - 1) != 'e'
                        && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else if (ch == '.') {

                if (hasDot || hasE) {
                    return false;
                }

                hasDot = true;
            }

            else if (ch == 'e' || ch == 'E') {

                if (hasE || !hasDigit) {
                    return false;
                }

                hasE = true;
                hasDigit = false;
            }

            else {
                return false;
            }
        }

        return hasDigit;
    }
}