import java.util.*;

public class Sort{

    public static void input(int arr[]){
        Random random = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = random.nextInt();
        }
    }
    public static void bubbleSort(int arr[]){
        long startTime = System.currentTimeMillis();
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]<arr[j+1]){
                   int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Bubble Sort: "+timeElapsed);
    }
    public static void insertionSort(int arr[]){
        long startTime = System.currentTimeMillis();
		for (int i=1; i<arr.length;i++){
			int j = i;
			int temp = arr[i];
			while (j>0 && temp<arr[j - 1]) {
				arr[j] = arr[j-1];
				j = j-1;			
			}
			arr[j] = temp;
		}
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
		System.out.println("Insertion Sort: "+timeElapsed);
	}
    public static void selectSort(int arr[]){
		long startTime = System.currentTimeMillis();
		for (int i = 0; i <arr.length-1; i++){
			int min = i;
			for (int j = i+1; j<arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
        long endTime   = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Select Sort: " + timeElapsed);
	}
    public static void interchangeSort(int arr[]){
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		long endTime   = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		
		System.out.println("Interchange Sort  : " + timeElapsed);
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
    public static void main(String[] args){
        int n = 90000 ;
        int A[] = new int[n];
        input(A);
         bubbleSort(A);
         insertionSort(A);
         selectSort(A);
         interchangeSort(A);
        long startTime = System.currentTimeMillis();
        mergeSort(A, 0, A.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Merge Sort: "+ (endTime - startTime)); 
    }
}