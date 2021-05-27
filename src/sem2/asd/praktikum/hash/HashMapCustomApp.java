package sem2.asd.praktikum.hash;

/**
 Perbedaan:
 * capacity
 * hash function
 nb: semua penjelasan akan berupa documentation comment sehingga mudah dibedakan
 */

class HashMapCustom<K, V> {

    private Entry<K,V>[] table;   //Array of Entry.
    /**
     Untuk variabel capacity disini yang merupakan representasi dari ukuran array table nya, saya tingkatkan menjadi 19
     **/
    private int capacity= 19;  //Initial capacity of HashMap

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMapCustom(){
        table = new Entry[capacity];
    }


    public void put(K newKey, V data){
        if(newKey == null)
            return;    //does not allow to store null.

        //calculate hash of key.
        int hash = hash(newKey);

        //create new entry.
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if(table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){ //we have reached last entry of bucket.
                if(current.key.equals(newKey)){
                    if(previous == null){  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    }
                    else{
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }


    public V get(K key) {
        int hash = hash(key);
        //returns null if key is not found.
        if (table[hash] != null) {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
        }
        return null;
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] != null) {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
        }
        return false;

    }


    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while(entry!=null) {
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry = entry.next;
                }
            }
        }

    }

    /**
     Untuk fungsi hash disini saya pisahkan menjadi 3 kemungkinan:
     1. ketika key merupakan instance dari String:
        ketika key berupa String maka akan dilakukan penambahan pada setiap char nya dimana setiap charnya dipresentasikan
        dalam decimal number in ASCII TABLE

     2. ketika key merupakan instance dari kelas Number beserta turunannya:
        ketika key berupa turunan dari kelas Number makan memiliki fungsi -> Math.floor(capacity * Math.log(key.hashCode()))
        yang dikonversi menjadi integer

     3. ketika key bukan keduanya:
        ketika key bukan berupa String maupun Number maka akan memiliki fungsi -> key.hashCode() + Math.log(capacity)
        yang dikonversi menjadi integer
     **/
    public int hash(K key) {
        int hashVal = 0;
        if (key instanceof String) {
            for (int i = 0; i < ((String) key).length(); i++)
                hashVal = hashVal + ((String) key).charAt(i);
        } else if (key instanceof Number) {
            hashVal = (int) Math.floor(capacity * Math.log(key.hashCode()));
        } else {
            hashVal = (int) (key.hashCode() + Math.log(capacity));
        }
        return hashVal % capacity;
    }

}

public class HashMapCustomApp {

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
                + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
                + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
        System.out.println();
    }
}
