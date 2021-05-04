package sem2.help;

public class Riza {
}

class Main {
    static void ganprim(int arr[]){
        int cekPrima = 0;

        //for indexing
        for (int arrMember : arr) {
            //for checking prime
            cekPrima = 0;
            if (arrMember == 2 || arrMember == 1) {
                cekPrima++;
            } else {
                for (int primeNumber = 2; primeNumber < arrMember; primeNumber++) {
                    if (arrMember % primeNumber == 0) {
                        cekPrima++;
                    }
                }
            }

            if (cekPrima == 0) {
                System.out.println(arrMember + " ");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int arr[] = {30,87,90,3,1,50,23,4,25,23,40,35,47,2,33};
        //maxmin(arr);
        ganprim(arr);
    }
}
