import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class programmerTest01 {
    public static void main(String[] args) {
        String[][] clothed = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        HashMap<String, ArrayList<String>> has = new HashMap<>();

        for (int i = 0 ;i< clothed.length;i++) {
            String category = clothed[i][1];
            String clothName = clothed[i][0];
            ArrayList<String> clothList = has.getOrDefault(category,new ArrayList<>());
            clothList.add(clothName);
            has.put(category,clothList);
        }

        int count = 1;

        has.forEach((key,value)->{
            System.out.printf("key : %s , vale : %s\n",key,value);
        });

        Iterator<String> keys = has.keySet().iterator();

        while (keys.hasNext()){
            String cate = keys.next();
            ArrayList<String> list = has.get(cate);

            count = count * (list.size() + 1);
        }

        count = count - 1;

        System.out.printf("");
    }
}
