/*Реализовать алгоритм пирамидальной сортировки (HeapSort)
*/

public class HW5_3 {

    public static void main(String args[])
    {
        int arr[] = {2, 14, 85, -7, 0, 2, 12, 4};
        System.out.println("Входной массив");
        printArray(arr);
    
        sort(arr);

        System.out.println("\nОтсортированный массив");
        printArray(arr);
    }


    public static void sort(int arr[]) {
        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        for (int i=size-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }


    public static void heapify(int arr[], int size, int index) {
        int indexMax = index;
        int index1 = 2*index + 1;
        int index2 = 2*index + 2;

        if (index1 < size && arr[index1] > arr[indexMax])
            indexMax = index1;

        else if (index2 < size && arr[index2] > arr[indexMax])
            indexMax = index2;

        if (indexMax != index)
        {
            int swap = arr[index];
            arr[index] = arr[indexMax];
            arr[indexMax] = swap;

            heapify(arr, size, indexMax);
        }
    }


    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}