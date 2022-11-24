package com.simon;

public class TwoSum {
    public int array[] = {1,3,5,6,11,23};
    public int twoSum = 9;

    public int TheTwoSum(){
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum = array[i] + array[j];
                if(sum == twoSum){
                    System.out.println("Numbers: " + array[i] + "+" + array[j] + "=" + twoSum);
                }
            }
        }
        return sum;
    }


    public TwoSum(){
        TheTwoSum();
    }

    public static void main(String[] args) {
        new TwoSum();
    }
}
