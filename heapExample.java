import java.util.Comparator;
import java.util.PriorityQueue;

public class heapExample {
    public static class Item {
        int val1 , val2;
        Item(int val1,int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    public static void main(String[] args) {
        // 생성 및 정렬
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item i1 , Item i2) {
                // TODO Auto-generated method stub
                if (i1.val1 == i2.val2) {
                    return Integer.compare(i1.val2, i2.val2);
                }else {
                    return Integer.compare(i1.val1, i2.val1);
                }
            }
        });

        queue.add(new Item(4, 3));
        queue.add(new Item(3, 6));
        queue.add(new Item(4, 8));
        queue.add(new Item(1, 1));

        // Poll & Peek
        if (queue.size() != 0) {
            queue.poll();
        }

        queue.add(new Item(7, 3));
        queue.add(new Item(2, 6));

        // 단순 출력(정렬되어 있어도, 단순 출력은 정렬형태가 아님)
        for (Item item : queue) {
            System.out.println(item.val1 + " : " + item.val2);
        }

        System.out.println("---------------------------------------");

        // Sort 확인
        while (queue.size() != 0) {
            Item item = queue.poll();
            System.out.println(item.val1 + " : " + item.val2);
        }
    }
}
