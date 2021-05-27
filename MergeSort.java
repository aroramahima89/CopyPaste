import java.util.*;
import java.lang.*;
public class MergeSort{
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void merge_sort(int[] A,int lb,int ub){
        int mid;
        if (lb < ub) {
            mid = (lb+ub) / 2;
            merge_sort(A, lb, mid);
            merge_sort(A, mid+1, ub);
            merge(A, lb, mid, ub);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no elements in array");
        int n=sc.nextInt();
        int[] A=new int[n];
        System.out.println("enter array");
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        merge_sort(A,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(A[i]+" ");
        }
    }
}