package sem2.asd.praktikum.search;

public class LinearSearch {
    static int search(int[] arr, int cari){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == cari)return i;
        }
        return -1;
    }
}
