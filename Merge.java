public class Merge {
    public static  int[] sort(int[] arr,int low,int high){
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            arr = complex(arr, low, mid, high);
        }
        return arr;
    }

    public static int[] complex(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int[] temp = new int[high - low + 1];
        int t = 0;
        while(i <= mid && j <= high){
            if(arr[i]<arr[j]){
                temp[t]=arr[i];
                i++;t++;
            }
            else {
                temp[t]=arr[j];
                j++;t++;
            }
        }
        while(i <= mid){
            temp[t]=arr[i];
            i++;t++;
        }
        while(j <= high){
            temp[t]=arr[j];
            j++;t++;
        }
        for(int k=0;k<high-low+1;k++){
            arr[low+k]=temp[k];
        }
        return arr;
    }

    public static int[] Sort(int arr[]){;
        arr = sort(arr,0,arr.length-1);
        return arr;
    }
    public static void Prt(int arr[]){
        for(int i=0;i<arr.length;i++){
            StdOut.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 43, 67, 45, 99, 123, 435, 3, 54, 33};
        int[] arr2 = {2,1,34,22,44,355,33};
        int[] arr3 = Sort(arr1);
        Prt(arr3);
    }
}
