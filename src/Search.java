import java.util.*;
public class Search {
    static Random rd = new Random();
    public static void input(int arr[]) {
        for(int i=0; i<arr.length; i++){
            arr[i] = rd.nextInt(); 
        }
        int key = rd.nextInt();;
        long startTime = System.currentTimeMillis();
        linearSearch(arr, key);
        long endTime = System.currentTimeMillis();
        System.out.println("Time linear search: "+(endTime-startTime));
        mergeSort(arr, 0, arr.length-1);
        startTime = System.currentTimeMillis();
        int result = binarySearch(arr,0,arr.length-1,key);  
        if (result == -1)  
            System.out.println("Element is not found!");  
        else  
            System.out.println("Element is found at index: "+result);  
        endTime = System.currentTimeMillis();
        System.out.println("Time binary search: "+(endTime-startTime));
    }
    public static int binarySearch(int arr[], int first, int last, int key){  
        if (last>=first){  
            int mid = first + (last - first)/2;  
            if (arr[mid] == key){  
                return mid;  
            }  
            if (arr[mid] > key){  
                return binarySearch(arr, first, mid-1, key);//search in left subarray  
            }else{  
                return binarySearch(arr, mid+1, last, key);//search in right subarray  
            }  
        }  
        return -1;  
    }  
    
    public static void linearSearch(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                System.out.println("Element is found at index: "+i);
                break;
            }
            else if(i==arr.length-1){
                System.out.println("Element is not found!");
            }
        }
    }
    public static void mergeSort(int A[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }
    
    public static void merge(int A[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }

    }
    public static void main(String args[]){
        int n = 50000000;
        int A[] = new int[n];
        input(A);
 
    }  
} 