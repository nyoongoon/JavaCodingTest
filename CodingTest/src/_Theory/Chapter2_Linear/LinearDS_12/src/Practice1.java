package _Theory.Chapter2_Linear.LinearDS_12.src;// Practice1
// 해시 테이블 배열로 직접 구현

class MyHashTable {
   Integer[] table;
   int eleCnt;
    MyHashTable(){}
   MyHashTable(int size){
       this.table = new Integer[size];
       this.eleCnt  = 0;
   }

   public int getHash(int key){
        return key % this.table.length;
   }

   public void setValue(int key, int value){
        table[getHash(key)] = value;
        eleCnt++;
   }

   public int getValue(int key){
        return table[getHash(key)];
   }

   public void removeValue(int key){
        table[getHash(key)] = null;
        eleCnt--;
   }

   public void printHashTable(){
       System.out.println("=== Hash Table ===");
       for (int i = 0; i < this.table.length; i++) {
           System.out.println(i + " : " + this.table[i]);
       }
   }
}

public class Practice1 {

    public static void main(String[] args) {
        // Test code
        MyHashTable ht = new MyHashTable(7);
        ht.setValue(1, 1);
        ht.setValue(2, 2);
        ht.setValue(3, 3);
        ht.setValue(4, 4);
        ht.setValue(5, 5);
        ht.printHashTable();
        ht.setValue(8, 6);
        ht.printHashTable();
    }
}
