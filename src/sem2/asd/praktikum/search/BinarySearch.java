package sem2.asd.praktikum.search;

public class BinarySearch {
    static int binarysearch(int[] arr,int cari){
        int l=0,r=arr.length;
        while(r>=l){
            int mid = l+(r-l)/2;
            if(arr[mid] == cari)
                return mid;
            else if(arr[mid]>cari)
                r=mid-1;
            else if(arr[mid]<cari)
                l=mid+1;
        }
        return -1;
    }
}
