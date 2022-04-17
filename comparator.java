import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class comparator {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>(); // 해시맵 선언

        hm.put("key1", 1);
        hm.put("key2", 2);
        hm.put("key3", 2);

        if (hm.containsKey("key1") && hm.containsValue(1)) System.out.println("YES"); // 해시맵 중에 키 값이 key1 밸류가 1이 있다면 예스 프린트

        hm.put("key1", hm.getOrDefault("key1", 0) * 10); // key1에 key1값이 있다면 * 10 아니라면 0을 해서 푸시
        // 해시맵은 키값 중복을 허용하지 않으니 덮어씀

        List<String> keyList = new ArrayList<>(hm.keySet()); // 키셋으로 이루어진 리스트 선언

        // 오름 차순으로 키 정렬
        Collections.sort(keyList , new Comparator<String>() { // 키 리스트를 키 정렬 하기 위해 밸류값들을 비교
            public int compare(String s1 , String s2){
                int v1 = hm.get(s1);
                int v2 = hm.get(s2);

                return Integer.compare(v1, v2);
            }
        });

        Collections.reverse(keyList);

        // 출력
        for (String s : keyList) {
            System.out.println(s + " = " + hm.get(s));
        }

        System.out.println(hm.size());
    }
}