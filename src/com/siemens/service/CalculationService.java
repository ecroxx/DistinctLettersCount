package com.siemens.service;

import com.siemens.exception.LowerCaseCharException;
import com.siemens.exception.MaximumCharException;
import com.siemens.exception.MinimumCharException;
import java.util.HashSet;
import java.util.Set;

public class CalculationService {
    public static int minDeletionOfChars(String s) throws Exception {

        if(s.length()>300000){
            throw new MaximumCharException("The maximum character number of the input line should be 300000. ");
        }
        if(s.length()<1){
            throw new MinimumCharException("The minimum character number of the input line should be 1 ");
        }

        int charFrequency[] = new int[26];
        int result = 0;
        Set<Integer> charSet = new HashSet<>();

        for (char c : s.toCharArray()){
            if(!(c >= 'a' && c <= 'z')){
                throw new LowerCaseCharException("All characters should be lowercase character between a-z ");
            }
            charFrequency[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int frequency = charFrequency[i];
            while (frequency > 0 && !charSet.add(frequency)) {
                frequency--;
                result++;
            }
        }
        return result;
    }
}
