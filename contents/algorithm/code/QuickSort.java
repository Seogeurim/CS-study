import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) { // 배열의 크기가 충분히 작아 질 때 까지 나눔
            int p = partition(arr, start, end); // 파티션을 적용 했을 때 피봇의 인덱스를 구함

            quickSort(arr, start, p - 1); // 처음 부터 피봇 전,
            quickSort(arr, p + 1, end); // 피봇 후 부터 마지막 까지 다시 퀵소트를 함
        }
    }

    static int partition(int[] arr, int start, int end) {
        int low = start + 1; // pivot을 맨 왼쪽 값으로 할것이기 때문에 그 다음 값부터 확인
        int high = end;
        int pivot = arr[start]; // 가장 왼쪽 값을 pivot으로 설정

        while (low <= high) { // 양쪽에서 탐색하면서 둘이 겹쳐져 지나칠때 까지 한다.
            while (low <= end && arr[low] < pivot) { // 앞에서 부터 비교중 pivot 보다 크면 stop
                low++;
            }
            while (high >= start && arr[high] > pivot) { // 뒤에서 부터 비교중 pivot 보다 작으면 stop
                high--;
            }
            if (low < high) { // low , high 가 겹쳐져 지나친게 아니면 둘을 바꿔줌
                swap(arr, low, high);
            }
        }
        swap(arr, start, high); // 마지막으로 pivot과 high index의 값을 바꾸면 high index 가 pivot의 index가 됨

        System.out.println(Arrays.toString(arr) + " pivot: " + pivot + " result index: " + high);

        return high; // pivot 위치 반환
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 7, 6, 5, 1, 4, 2 };
        System.out.println(Arrays.toString(arr) + " start");

        quickSort(arr, 0, 6);

        System.out.println(Arrays.toString(arr) + " finish");
    }
}
