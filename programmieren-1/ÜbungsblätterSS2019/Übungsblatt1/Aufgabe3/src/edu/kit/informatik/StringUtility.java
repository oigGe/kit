package edu.kit.informatik;

public final class StringUtility {

    private StringUtility() {
    }

    public static String reverse(String word) {
        String[] strings = getStringArray(word);
        String reversedWord = "";

        for (int i = word.length(); i > 0; i--) {
            reversedWord += strings[i - 1];
        }
        return reversedWord;
    }

    public static boolean isPalindrome(String word) {
        word = capitalize(word);
        String reversedWord = reverse(word);
        if (reversedWord.equals(word)) {
            return true;
        }
        return false;
    }

    public static String removeCharacter(String word, int index) {
        return word.substring(0, index) + word.substring(index + 1);
    }

    public static boolean isAnagram(String word1, String word2) {
        String sortedWord1 = sortString(word1);
        String sortedWord2 = sortString(word2);
        if (sortedWord1.equals(sortedWord2)) {
            return true;
        }
        return false;
    }

    public static String capitalize(String word) {
        return word.toUpperCase();
    }

    public static int countCharacter(String word, char character) {
        int count = 0;
        String[] strings = getStringArray(word);
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(String.valueOf(character))) {
                count++;
            }
        }
        return count;
    }

    private static String[] getStringArray(String word) {
        String[] stringArray = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            stringArray[i] = String.valueOf(word.charAt(i));
        }
        return stringArray;
    }

    private static String sortString(String word) {
        String[] strings = getStringArray(word);
        int minValue;
        int minValueIndex = 0;
        int count = strings.length;
        String sortedString = "";
        String tempWord = word;

        while (count > 0) {
            minValue = strings[0].charAt(0);
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].codePointAt(0) <= minValue) {
                    minValue = strings[i].codePointAt(0);
                    minValueIndex = i;
                }
            }
            sortedString += strings[minValueIndex];
            tempWord = removeCharacter(tempWord, minValueIndex);
            strings = getStringArray(tempWord);
            count--;
        }
        return sortedString;
    }
}


