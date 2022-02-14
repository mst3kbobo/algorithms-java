package com.joemerrill.datastructures;

import java.util.Arrays;

/**
 * This program demonstrates a Hash Map
 */
public class HashMap {

    private String[] hashMap;

    public HashMap(int size) {
        this.hashMap = new String[size];
    }

    /**
     * Hash method for a String key
     * @param key String key to hash
     * @return integer representing the index of the array to store the key-value pair
     */
    private int hash(String key) {

        int hashCode = 0;

        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }

        // Compress hashCode so it fits in within the index range of the hash map.
        hashCode = hashCode % hashMap.length;

        return hashCode;
    }

    public void assign(String key, String value) {
        int arrayIndex = hash(key);
        hashMap[arrayIndex] = value;
    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);
        return hashMap[arrayIndex];
    }

    public static void main(String[] args) {

        HashMap myMap = new HashMap(3);

        //
        // Hash Test
        //
        System.out.println(myMap.hash("c"));
        System.out.println(myMap.hash("ca"));
        System.out.println(myMap.hash("car"));

        //
        // Assign Test
        //
        System.out.println(myMap.hash("1F012345678901234"));
        myMap.assign("1F012345678901234", "Ford Bronco");
        System.out.println(Arrays.toString(myMap.hashMap));

        //
        // Retrieve Test
        //
        System.out.println(myMap.retrieve("1F012345678901234"));
    }

}
