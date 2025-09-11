package com.recursion;

import java.util.List;

public class RecursiveFunctions {


    public static int recursiveIndexOf(List<String> list, String target) {
        if (list == null || list.isEmpty()) return -1;
        if (list.get(0).equals(target)) return 0;
        int subIndex = recursiveIndexOf(list.subList(1, list.size()), target);
        return (subIndex == -1) ? -1 : 1 + subIndex;
    }


    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        if (list == null || index >= list.size()) return -1;
        if (list.get(index).equals(target)) return index;
        return recursiveIndexOfByIndex(list, target, index + 1);
    }


    public static int recursiveIndexOfEmpty(List<String> list) {
        if (list == null || list.isEmpty()) return -1;
        if (list.get(0).equals("")) return 0;
        int subIndex = recursiveIndexOfEmpty(list.subList(1, list.size()));
        return (subIndex == -1) ? -1 : 1 + subIndex;
    }


    public static int recursivePut(String target, List<String> list) {
        return recursivePutHelper(target, list, 0);
    }

    private static int recursivePutHelper(String target, List<String> list, int index) {
        if (list == null || index >= list.size()) return -1;
        if (list.get(index).equals("")) {
            list.set(index, target);
            return index;
        }
        return recursivePutHelper(target, list, index + 1);
    }


    public static int recursiveRemove(List<String> list, String target) {
        return recursiveRemoveHelper(list, target, 0);
    }

    private static int recursiveRemoveHelper(List<String> list, String target, int index) {
        if (list == null || index >= list.size()) return 0;
        int count = 0;
        if (list.get(index).equals(target)) {
            list.remove(index);
            count = 1;
            return count + recursiveRemoveHelper(list, target, index); // mismo índice, lista se achicó
        }
        return count + recursiveRemoveHelper(list, target, index + 1);
    }



    public static int recursiveSum(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        int first = list.get(0);
        return first + recursiveSum(list.subList(1, list.size()));
    }


    public static int recursiveFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * recursiveFactorial(n - 1);
    }


    public static int recursivePow(int base, int exponent) {
        if (exponent == 0) return 1;
        return base * recursivePow(base, exponent - 1);
    }


    public static int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }


    public static boolean recursivePalindrome(String word) {
        if (word.length() <= 1) return true;
        if (word.charAt(0) != word.charAt(word.length() - 1)) return false;
        return recursivePalindrome(word.substring(1, word.length() - 1));
    }
}

