import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class setExample {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        ts.add("apple");
        ts.add("core");
        ts.add("banana");
        ts.add("apple");

        // 정렬된 순서로 출력
        for(String s : ts) System.out.println(s);

        System.out.println("");

        HashSet<String> hs = new HashSet<>(ts);

        for(String s : hs) System.out.println(s);

        System.out.println("");

        // for 문내에서 요소 삭제
        Iterator<String> interator = hs.iterator();
        while(interator.hasNext()) {
            String element = interator.next();
            if (element.length() % 2 == 0) {
                interator.remove();
            }
        }

        // 삭제 결과 출력
        for(String s : hs) System.out.println(s);
    }
}
