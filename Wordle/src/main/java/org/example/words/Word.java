package org.example.words;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Word {
    private static String filePath = "words.txt";
    private static HashSet<String> wordDic = new HashSet<>();
    private static Integer wordLen = 5;

    static {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        ClassLoader.getSystemResourceAsStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordDic.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkValidWord(String input){
        if(input.length() != wordLen){
            throw new RuntimeException("Invalid Lenght");
        }

        if(wordDic.contains(input)) return true;
        return false;
    }

    public static String getRandowWord() {
        Random random = new Random();
        Iterator<String> itr = wordDic.iterator();
        // generating a random number
        Integer num = random.nextInt(wordDic.size());

        String newRandom = itr.next();
        while (itr.hasNext()) {
            newRandom = itr.next();

            if (num == 0) {
                return newRandom;
            }
            num--;
        }

        return newRandom;
    }
}
