package _Theory.Chapter2_Linear._11_해시.src;// Practice3
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable {

    MyHashTable3(int size) {
        super(size);
    }

    @Override
    public void setValue(int key, int value) {
        int idx = this.getHash(key);
        if (this.eleCnt == this.table.length) {
            System.out.println("table is full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = value;
        } else {
            int i = 0;
            int newIdx = idx;
            while (true) {
                newIdx = (idx + (int) Math.pow(2, i++)) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = value;
        }

        this.eleCnt++;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
//        ht.setValue(1, 10);
//        ht.setValue(2, 20);
//        ht.setValue(4, 40);
//        ht.printHashTable();
//
//        ht.setValue(1, 100);
//        ht.printHashTable();
//
//        ht.setValue(1, 200);
//        ht.setValue(1, 300);
//        ht.setValue(1, 400);
//        ht.printHashTable();
    }
}
