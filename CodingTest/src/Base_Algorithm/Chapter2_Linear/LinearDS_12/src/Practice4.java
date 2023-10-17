package Base_Algorithm.Chapter2_Linear.LinearDS_12.src;// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c; // c는 size보다 작은 최대 소수
    int eleCnt;

    MyHashTable4(int size) {
        super(size);
        eleCnt = 0;

        if (size <= 2) {
            c = size;
        } else {

            for (int i = size - 1; i > 2; i--) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    c = i;
                    System.out.println(c);
                    break;
                }
            }
        }
        System.out.println("c == " + c);
    }

    public int getHash2(int key) {
        System.out.println(c);
        return 1 + key % c;
    }

    public void setValue(int key, int value) {
        int idx = this.getHash(key);
        if (this.eleCnt == this.table.length) {
            System.out.println("table is full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = value;
        } else {
            int newIdx = idx;
            int cnt = 1;

            while (true) {
                newIdx = (newIdx + getHash2(key) * cnt) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = value;
        }
        this.eleCnt++;
    }


}

public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
