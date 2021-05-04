package sem2.asd.praktikum;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String word = "kkkaliii";
        String singleChar = "";
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            wordSet.add(String.valueOf(word.charAt(i)));
        }

        char[] listWord = new char[wordSet.size()];

        for (int index = 0; index < word.length(); index++) {
            for (int index2 = 0; index2 < listWord.length; index2++) {
                int indexListWord = 0;
                if (word.charAt(index) != listWord[index2]) {
                    listWord[indexListWord] = word.charAt(index);
                    indexListWord++;
                    break;
                }
            }
        }

        System.out.println(listWord);
    }
}
