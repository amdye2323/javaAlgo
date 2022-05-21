package hacker;

import java.util.*;

public class prac01 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(
                new ArrayList<Integer>() {{
                    add(3);
                }}
        );

        arr.add(
                new ArrayList<Integer>() {{
                    add(11);
                    add(2);
                    add(4);
                }}
        );

        arr.add(
                new ArrayList<Integer>() {{
                    add(4);
                    add(5);
                    add(6);
                }}
        );

        arr.add(
                new ArrayList<Integer>() {{
                    add(10);
                    add(8);
                    add(-12);
                }}
        );

        int size = arr.get(0).get(0);

        int leftOne = 0;
        int rightOne = 0;

        arr.remove(0);

        for (int i =0, j=size-1;i<size;i++,j--) {
            leftOne = leftOne + arr.get(i).get(i);
            rightOne = rightOne + arr.get(j).get(i);
        }


        int answer = (leftOne - rightOne) <0?(leftOne - rightOne)*-1:(leftOne - rightOne);

        System.out.println(answer);

    }


}
