package _0_Theory.Chapter2_Linear._11_해시.src;// Practice2
// 해시 충돌 해결 - 개방 주소법 (선형 탐사법)

class MyHashTable2 extends MyHashTable {
    MyHashTable2(int size) {
        super(size);
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
            while (true) {
                newIdx = (newIdx + 1) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
            }
            this.table[newIdx] = value;
        }
        eleCnt++;
    }

}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyHashTable2 ht = new MyHashTable2(5);
//        ht.setValue(1, 1);
//        ht.setValue(3, 3);
//        ht.printHashTable();
//
//        ht.setValue(1, 10);
//        ht.printHashTable();
//
//        ht.setValue(1, 20);
//        ht.setValue(1, 30);
//        ht.setValue(1, 40);
//        ht.printHashTable();
    }
}
