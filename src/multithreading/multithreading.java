package multithreading;

public class multithreading {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, -1, 100, 10, 500, -1000, 34, 2, 1010, -100000};
        QuickSortUsingMultiThreading.quickSort(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static class QuickSortUsingMultiThreading {
        static class quickSortThread extends Thread {
            int[] arr;
            int l, r;

            quickSortThread(int[] arr, int l, int r) {
                this.arr = arr;
                this.l = l;
                this.r = r;
            }

            @Override
            public void run() {
                quickSort(arr, l, r);
            }
        }

        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
            int pi = partition(arr, l, r);
            quickSortThread thread1 = new quickSortThread(arr, l, pi - 1);
            quickSortThread thread2 = new quickSortThread(arr, pi + 1, r);
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException ex) {}
        }
        static int partition(int[] arr, int l, int r) {
            int j = l;
            for (int i = l; i < r; i++) {
                if (arr[i] < arr[r]) {
                    swap(arr, i, j++);
                }
            }
            swap(arr, j, r);
            return j;
        }

        static void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
