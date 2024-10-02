//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Divide and Conquer
    // merge short  // depth first search the take more space costly

    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        // kam
        int mid = si + (ei - si)/2;   //(si + ei) /2
        mergeSort(arr, si, mid);      // left
        mergeSort(arr, mid+1, ei); // right
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i=si; // left
        int j=mid+1;  // right
        int k =0; // iterator of tem arr

        while (i<= mid &&  j<=ei){
            if(arr[i]< arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // left
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // right part
        while (j <= ei){
            temp[k++] = arr[j++];
        }
        // copy temp to original
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

   public static void  printArr(int arr[]){
        for(int i=0; i<= arr.length-1; i++){
            System.out.print(arr[i]+ " ");
        }

   }

 //   Quick sort less space  tc nlogn
//     space 0(1)
//     use pivot and partition work

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        // last element

        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);  // left
        quickSort(arr, pIdx+1, ei); // right

    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;  // to make place for els smaller than pivot

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;

                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];  // array pass by refrence so not use pivot that not change
        arr[i] = temp;
        return  i;

    }

    // worst case in quick sort
    // when pivot is always smallest or the largest element

    // Que.  Search in Rotated Sorted Array

    // use modified  binary search to optimal

    public static int searchTarget(int arr[], int tar, int si, int ei){
        if(si > ei){
            return -1;
        }
        // kam
        int mid = si + (ei - si)/2;

        // case found mid
        if(arr[mid] == tar){
            return mid;
        }

        // mid on L1
        if(arr[si] <= arr[mid]){
            // case a: left
            if(arr[si] <= tar && tar <= arr[mid]){
                return searchTarget(arr, tar, si, mid);
            }else{
                // case b : right
                return searchTarget(arr, tar, mid+1, ei);
            }
        }else{
        // mid on L2
        // case c : right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return searchTarget(arr, tar, mid+1, ei);
            }else{
                // case d : left
                return searchTarget(arr, tar, si, mid-1);
            }

        }
    }

    // solve using iteration H.W.


    public static void main(String[] args) {



//    int arr[] = {4, 5, 6, 7, 8, 0, 1, 2, 3};
//    int target = 0;
//    int tarIdx = searchTarget(arr, target, 0 , arr.length-1);
//        System.out.println(tarIdx);
//


//     int arr[] = {12, 78, 90, 76};
//     quickSort(arr, 0, arr.length-1);
//     printArr(arr);




//      int arr[] = {12, 67, 85, 23, 89};
//      mergeSort(arr, 0, arr.length-1);
//      printArr(arr);
    }
}