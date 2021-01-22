import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start; // 왼쪽 배열의 시작
        int j = mid + 1; // 오른쪽 배열의 시작
        int k = 0; // 병합된 배열의 시작

        int[] temp = new int[end - start + 1];
        System.out.println("size : " + (end - start + 1));
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 남은 값 복사
        if (i > mid) { // 왼쪽 배열 값 다 사용함 , 오른쪽 다 복사
            for (int idx = j; idx <= end; idx++, k++) {
                temp[k] = arr[idx];
            }
        } else { // 오른쪽 배열 값 다 사용함, 왼쪽 다 복사
            for (int idx = i; idx <= mid; idx++, k++) {
                temp[k] = arr[idx];
            }
        }
        System.out.println(Arrays.toString(temp));

        // 임시 배열 -> 원래 배열
        for (int num : temp) {
            arr[start++] = num;
        }

    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, 7);
    }
}
