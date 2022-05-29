package nhnTest;
import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        String[] maze = {"AAAAA", "AABBB", "CAEFG", "AAEFF"};
        String[] queries = {"1 1 1 5 AF", "1 1 4 5 AF", "2 1 4 5 FAE", "1 5 4 5 ABF", "1 1 4 1 A"};
        Character[][] fullMaze = new Character[maze.length][maze[0].split("").length];

        for(int i = 0;i<maze.length;i++){
            int cnt = 0;
            for(Character x:maze[i].toCharArray()){
                fullMaze[i][cnt] = x;
                cnt++;
            }
        }

        for(String s: queries){
            String[] strList = s.split(" ");
            char[] charList = strList[4].toCharArray();

            int startX = Integer.parseInt(strList[0]) ;
            int startY = Integer.parseInt(strList[1]);
            int endX = Integer.parseInt(strList[2]);
            int endY = Integer.parseInt(strList[3]);



        }

        System.out.println("체크");
    }
}
