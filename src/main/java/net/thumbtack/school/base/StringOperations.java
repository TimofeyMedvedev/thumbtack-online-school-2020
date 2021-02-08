package net.thumbtack.school.base;

import java.text.DecimalFormat;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int length = 0;
        for(String string : strings)
            length += string.length();
        return length;
    }

    public static String getFirstAndLastLetterString(String string) {
        return "" + string.charAt(0) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        String str = "";
        for(int i = 0; i < string1.length() && i < string2.length(); i++) {
            if(string1.charAt(i) == string2.charAt(i)) {
                str += string1.charAt(i);
            }
            else break;
        }
        return str;
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString().equals(string);
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return isPalindrome(string.toLowerCase());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String result = "";

        for(String string : strings) {
            if (isPalindromeIgnoreCase(string) && string.length() > result.length())
                    result = string;
        }
        return result;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return string1.regionMatches(index, string2, index, length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1)
                .equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replaceAll(replaceInStr1, replaceByInStr1)
                .equals(string2.replaceAll(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.strip().equals(string2.strip());
    }

    public static String makeCsvStringFromInts(int[] array) {
       return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder result= new StringBuilder();
        if(array.length == 0){
            return result;
        }
        for(int number : array) {
            result.append(number).append(',');
        }
        return result.delete(result.length() - 1, result.length());
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder result = new StringBuilder();
        if(array.length == 0) {
            return result;
        }
        for(double number : array) {
            result.append(new DecimalFormat("#0.00").format(number)).append(",");
        }
        return result.delete(result.length() - 1, result.length());
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
       StringBuilder result= new StringBuilder(string);
       for(int i = positions.length - 1; i >= 0; i--) {
           result.deleteCharAt(positions[i]);
       }
       return result;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder result = new StringBuilder(string);
        for(int i = positions.length - 1; i >= 0; i--) {
            result.insert(positions[i], characters[i]);
        }
        return result;
    }
}
