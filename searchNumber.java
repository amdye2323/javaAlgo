public class searchNumber {

    public static class Solution {
        public int solution() {
            int[] numbers = new int[]{1, 1, 1, 1, 1};
            int target = 3;
            int answer = 0;
            Node node = new Node(0);  // 초기 값 0부터 시작

            for(int i=0; i<numbers.length; i++)
            {
                node.setNode(node, numbers[i]);
            }

            answer = node.countValue(node, target);

            return answer;
        }

        class Node
        {
            private int value;
            private Node rightNode ;   //+ 노드
            private Node leftNode ;    //- 노드

            public Node(int value)
            {
                this.value =value;
                this.rightNode = null;
                this.leftNode = null;
            }
            /*
             * 다음 depth의 노드를 셋팅 한다.
             * 현재 노드가 leaf 노드면 다음 노드를 셋팅 한다.
             */
            public void setNode(Node node,int val)
            {
                if(!node.isTerminal()) // 왼쪽 오른쪽 중 하나라도 데이터가 존재한다면.
                {
                    setNode(node.leftNode,val);
                    setNode(node.rightNode,val);
                }
                else
                {
                    node.rightNode = new Node(node.getValue() + val);
                    node.leftNode = new Node(node.getValue() - val);
                }
            }

            public boolean isTerminal() // leaf 노드인지 확인
            {
                return this.rightNode==null && this.leftNode==null ? true : false;
            }
            public int countValue(Node node,int value)
            {
                int cnt =0;

                if(!node.isTerminal())
                {
                    return countValue(node.leftNode,value) +countValue(node.rightNode,value);
                }
                else
                {
                    if(node.getValue() == value)
                    {
                        return 1;
                    }
                }

                return 0;

            }

            public void searchNode(Node node)
            {

            }
            public int getValue()
            {
                return this.value;
            }

        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ss = sol.solution();
        System.out.println(ss);
    }
}
