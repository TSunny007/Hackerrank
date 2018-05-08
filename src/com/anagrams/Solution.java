package com.anagrams;

import java.util.*;
// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

public class Solution {
    // Using a "Island" approach to figure out the amount of characters that need
    // to be removed to make both the strings anagrams.
    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (char c: first.toCharArray()) {
            if (count.containsKey(c)) count.put(c, count.get(c)+1);
            else {
                count.put(c,1);
            }
        }
        for (char c: second.toCharArray()) {
            if (count.containsKey(c)) count.put(c, count.get(c)-1);
            else {
                count.put(c,-1);
            }
        }
        int sum = count.values().stream().mapToInt(Math::abs).sum();
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

