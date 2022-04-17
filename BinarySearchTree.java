class BST {
    public int data; //요소값
    public int left; // 왼쪽 요소의 연결 정보
    public int right; //오른쪽 요소의 연결 정보
}

// 이진 탐색 트리를 구성하는 클래스 정의
public class BinarySearchTree {
    // 이진 탐색 트리의 실체가 되는 배열(요소 수는 최대 10)
    public  static BST[] tree = new BST[10];

    // 루트 요소의 물리적 위치 인덱스(연결 리스트의 head)
    public static int rootIdx = 0;

    // 다음으로 추가할 요소의 물리적 위치 인덱스
    public static int newIdx = 0;

    // 이진 탐색 트리에 요소를 추가하는 메소드
    public static void addBST(int data) {
        int currentIdx; // 현재 요소의 물리적 위치 인덱스
        boolean addFlag; // 요소 추가가 완료되었는지 확인하는 플래그

        // 물리적 위치에 요소값과 연결 정보 추가
        tree[newIdx].data = data;
        tree[newIdx].left = -1;
        tree[newIdx].right = -1;

        // 루트 요소가 아니라면 논리적 순서에 따라 요수 위치 탐색 및 결졍
        if (newIdx != rootIdx) {
            currentIdx = rootIdx; // 루트부터 이진 탐색 트리를 내려감
            addFlag = false; // 요소 추가가 완료되지 않음

            do {
                // 루트 요솟값보다 더 작으면 왼쪽으로 내려감
                if (data < tree[currentIdx].data) {
                    // 왼쪽으로 내려갔을 대 긑이면 left에 요소의 물리적 위치 인덱스를 추가(연결 정보 설정)
                    if (tree[currentIdx].left == -1){
                        tree[currentIdx].left = newIdx;
                        addFlag = true;
                    }
                    //왼쪽으로 내려갔을 때 끝이 아니라면 왼족의 요소보다 더 내려감
                    else {
                        currentIdx = tree[currentIdx].left;
                    }
                }
                // 루트 요솟값 보다 더 크면 오른쪽으로 내려감(동일한 값은 없음)
                else {
                    // 으론쪽을 내려갔을 때 끝이면 right에 요소의 물리적 위치 인덱스를 추가(연결 정보 설정)
                    if (tree[currentIdx].right == -1) {
                        tree[currentIdx].right = newIdx;
                        addFlag = true;
                    }
                    // 오른쪽으로 내려갔을 때 끝이 아니라면 오른쪽 요소보다 더 내려감
                    else {
                        currentIdx = tree[currentIdx].right;
                    }
                }
            }
            while ( addFlag == false );
        }
        // 다음에 추가할 요소를 위해 물리적 위치의 인덱스를 1늘림
        newIdx++;
    }
    // 이진 검색 트리의 실체인 배열을 물리적 위치 순서를 표시하는 메소드
    public static void printPhysicalBST() {
        int i ;

        for (i = 0; i < newIdx;i++) {
            System.out.printf("tree[%d] : data = %d , left = %d, right = %d \n",
                    i , tree[i].data , tree[i].left , tree[i].right);
        }
    }

    // 이진 탐색 트리를 논리적인 순서(깊이 우선 탐색)로 표시되는 메소드
    public static void printLogicalBST(int currentIdx){
        if (currentIdx != -1) {
            System.out.printf("tree[%d] : data = %d , left = %d , right = %d\n",
                    currentIdx, tree[currentIdx].data,
                    tree[currentIdx].left, tree[currentIdx].right);

            // 재귀 호출 부분
            printLogicalBST(tree[currentIdx].left);
            printLogicalBST(tree[currentIdx].right);
        }
    }

    // 이진 탐색 트리를 탐색하는 메소드
    public static int searchBST(int x) {
        int idx;
        int currentIdx;

        idx = -1;
        currentIdx = rootIdx;

        while (currentIdx != -1){
            if (tree[currentIdx].data == x) {
                idx = currentIdx;
                break;
            } else if (tree[currentIdx].data > x) {
                currentIdx = tree[currentIdx].left;
            } else {
                currentIdx = tree[currentIdx].right;
            }
        }

        return idx;
    }

    public static int searchRecBST(int x, int currentIdx) {
        if (currentIdx == -1){
            return -1;
        } else {
            if (tree[currentIdx].data == x) {
                return currentIdx;
            } else if (tree[currentIdx].data > x) {
                // 재귀 호출 부분
                return searchRecBST(x , tree[currentIdx].left);
            } else {
                return searchRecBST(x , tree[currentIdx].right);
            }
        }
    }

    public static void main(String[] args) {
        // 자바는 인스턴스 생성이 필요(이 처리는 의사코드나 c에서는 불필요)
        for (int i =0;i< tree.length;i++) {
            tree[i] = new BST();
        }

        addBST(4);
        addBST(6);
        addBST(5);
        addBST(2);
        addBST(3);
        addBST(7);
        addBST(1);

        printPhysicalBST();

        // 이진 탐색 트리를 논리적인 순서로(깊이 우선 탐색)로 표시
        System.out.printf("---------------------------------------------\n");
        printLogicalBST(rootIdx);

        System.out.printf("---------------------------------------------\n");

        // 이탄 탐색 트리를 탐색
        System.out.printf("data 값이 '5'이 때의 물리적 위치 탐색 결과 = tree[%d]\n", searchBST(5));
        System.out.printf("data 값이 '8'이 때의 물리적 위치 탐색 결과 = tree[%d]\n", searchBST(8));

        // 재귀 호출로 이진 탐색 트리를 탐색
        System.out.printf("---------------------------------------------\n");
        System.out.printf("data 값이 '5'이 때의 물리적 위치 탐색 결과 = tree[%d]\n", searchRecBST(5,rootIdx));
        System.out.printf("data 값이 '8'이 때의 물리적 위치 탐색 결과 = tree[%d]\n", searchRecBST(8,rootIdx));
    }
}
