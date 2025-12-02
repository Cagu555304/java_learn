public class BinarySearch {
    public static int find(int[] arr, int f) {
        int min = 0, max = arr.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (arr[mid] == f) return mid;
            else if (arr[mid] < f) min = mid + 1;
            else max = mid - 1;
        }
        return -1;
    }
    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
    int[] a = {1,32,54,765,34,5,45,47,57,77};
    a=sort2(a);
    for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
    }
}
