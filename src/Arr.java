public class Arr {
    public static void main(String[] args) {
        //Scenario 1: Copy array using assignment
        int[] a = {1, 2, 3};
        int[] b = a;

        //test side effect
        b[0]++;

        System.out.println("Scenario 1: ");
        System.out.print("Array a: ");
        printArray(a);
        System.out.print("Array b: ");
        printArray(b);

        //Scenario 2: Copy array by iterating
        int[] c = {1, 2, 3};
        int[] d = new int[c.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = c[i];
        }

        //test side effect
        d[0]++;

        System.out.println("Scenario 2: ");
        System.out.print("Array c: ");
        printArray(c);
        System.out.print("Array d: ");
        printArray(d);

        //Scenario 3: Copy array using clone
        int[] e = {1, 2, 3};
        int[] f = e.clone();

        //test side effect
        f[0]++;

        System.out.println("Scenario 3: ");
        System.out.print("Array e: ");
        printArray(e);
        System.out.print("Array f: ");
        printArray(f);

        //Scenario 4: Copy array using arraycopy
        int[] g = {1, 2, 3};
        int[] h = new int[g.length];
        System.arraycopy(g, 0, h, 0, h.length);

        //test side effect
        h[0]++;

        System.out.println("Scenario 4: ");
        System.out.print("Array g: ");
        printArray(g);
        System.out.print("Array h: ");
        printArray(h);
    }

    public static void printArray(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
}
