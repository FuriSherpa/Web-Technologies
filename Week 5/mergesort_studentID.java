import java.util.ArrayList;
import java.util.Scanner;

public class mergesort_studentID {

    ArrayList<Integer> getInput() {
        // Read input ArrayList from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the ArrayList:");
        int n = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Enter the elements of the ArrayList:");
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        sc.close();
        return al;
    }

    void getOutput(ArrayList<Integer> al) {
        // Print sorted ArrayList to the console
        System.out.println("Sorted ArrayList:");
        for (int i : al) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void merge(ArrayList<Integer> al, int beg, int mid, int end) {
        // Merge the two halves of the ArrayList delimited by the middle index
        int i = beg;
        int j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= end) {
            if (al.get(i) < al.get(j)) {
                temp.add(al.get(i));
                i++;
            } else {
                temp.add(al.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(al.get(i));
            i++;
        }

        while (j <= end) {
            temp.add(al.get(j));
            j++;
        }

        for (int k = beg; k <= end; k++) {
            al.set(k, temp.get(k - beg));
        }
    }

    void sort(ArrayList<Integer> al, int beg, int end) {
        // Sort the portion of the ArrayList delimited by the beginning and end indices
        if (beg < end) {
            int mid = (beg + end) / 2;
            sort(al, beg, mid);
            sort(al, mid + 1, end);
            merge(al, beg, mid, end);
        }
    }

    public static void main(String[] args) {
        Mergesort ms = new Mergesort();
        ArrayList<Integer> al = ms.getInput();
        ms.sort(al, 0, al.size() - 1);
        ms.getOutput(al);
    }
}