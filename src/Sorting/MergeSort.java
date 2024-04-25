package Sorting;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }

    }

    public static void mergeSort(int[] input, int start, int end){

        if (end - start < 2){
            return;
        }

        int mid = (start + end)/2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end){

        if(input[mid -1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while ( i< mid && j < end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // { 32, 34 } , { 33, 36 }
        // when doing the merge compare 32 to 33 --
        // { 32
        // then compare 34 to 33
        // { 32, 33
        // compare 34 to 36
        // { 32, 33, 34, then copy 36 in } - everything left over on the right will be greater
        // than everything in the left array

        // Optimization is that if the greater values are already on the right hand side we just copy them over to the final array
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}