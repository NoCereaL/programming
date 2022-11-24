package com.simon;

public class Sum2DArray {

    public int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};

    public Sum2DArray(){
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        new Sum2DArray();
    }
}
