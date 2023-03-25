import CITS2200.Sort;


/**
 * A class to give a comparative view of common sorting algorithms.
 * The maintains a private static variable that counts the number
 * of aay assignments that are performed (as an approximate measure)
 * of the complexity of the algorithm.
 * @author Tim French.
 **/

public class Sorter implements Sort
{

    public int count;

    /**
     * Returns the number of aay assignment operations
     * performed by this class since the count variable was rest.
     * @return the number of assignments
     **/
    public int getCount(){
        return count;
    }

    /**
     *Resets the counter variable to 0
     **/
    public void reset(){
        count = 0;
    }

    /**
     * Executes the insertion sort algorithm sorting the argument aay.
     * There is no return as the parameter is to be mutated.
     * @param a the aay of long integers to be sorted
     **/


    public void insertionSort(long[] a)
    {
        reset();
        int l = a.length;
        for(int i = 1; i < l; i++){
            int key = (int) a[i];
            int j = i-1;

            while (j>=0 && a[j]>key){
                a[j+1] = a[j];
                count++;
                j--;
            }
            a[j+1] = key;

        }
    }


    /**
     * Executes the quick sort algorithm sorting the argument aay.
     * There is no return as the parameter is to be mutated.
     * param the aay of long integers to be sorted
     **/


    private int partition(long[] a, int low, int high) {
        long pivot = a[high];
        count++;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private void swap(long[] a, int i, int j) {
        count++;
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void quickSortHelper(long[] a, int low, int high) {
        if (low < high){
            int q = partition(a, low, high);
            quickSortHelper(a, low, q - 1);
            quickSortHelper(a, q + 1, high);
        }
    }
    public void quickSort(long[] a){
        reset();
        quickSortHelper(a, 0, a.length - 1);

    }

    /**
     * Executes the merge sort algorithm sorting the argument aay.
     * There is no return as the parameter is to be mutated.
     * @param a the aay of long integers to be sorted
     **/
    public void mergeSort(long[] a){
        mergeSort(a, 0, a.length-1);
    }

    /**
     *A private method to merge the elements in the aay between p and r.
     *the aay a, between the indices p and r, inclusive.
     *Given the aay is sorted between p and q and q+1 and r
     *sorts the aay between p and r.
     *@param a the aay to be sorted, which is mutated by the method
     *@param p the lower index of the range to be partitioned
     *@param q the midpoint of the two sorted sections.
     *@param r the upper index of the range to be partitioned
     *return the index of the point of partition
     **/
    @SuppressWarnings("IfStatementWithIdenticalBranches")
    private void merge(long[] a, int p, int q, int r)
    {
        reset();
        int nOne = q-p+1;
        int nTwo = r-q;

        int[] L = new int[nOne];
        int[] R = new int[nTwo];

        for (int i = 0; i < nOne; i++){
            count++;
            L[i] = (int) a[p+i];
        }
        for (int j = 0; j < nTwo; j++){
            count++;
            R[j] = (int) a[q+j+1];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < nOne && j < nTwo) {
            if (L[i] <= R[j]) {
                count++;
                a[k++] = L[i++];

            }
            else {
                count++;
                a[k++] = R[j++];

            }
        }

        while (i < nOne) {
            count++;
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < nTwo) {
            count++;
            a[k] = R[j];
            j++;
            k++;
        }

    }

    /**
     *Overloads the mergeSort method with parameters to set the
     *range to be sorted.
     **/
    private void mergeSort(long[] a, int p, int r)
    {
        if(p<r){
            int q =p + ((r-p)/2);
            mergeSort(a, p , q);
            mergeSort(a, q+1, r);
            merge(a, p, q, r);
        }

    }




}