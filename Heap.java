import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

    private ArrayList<Integer> heap;

    private int heapSize;

    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<Integer> heap) {
        this.heap = heap;
        this.setHeapSize(heap.size());
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}

class MaximunHeap{
    int leftOf(int i){return i * 2 + 1;}
    int rightOf(int i){return i * 2 + 2;}
    int parentOf(int i){return (i - 1) / 2;}

    public void MaxHeapify(Heap heap, int toHeapify){
        int left = leftOf(toHeapify);
        int right = rightOf(toHeapify);
        int largest = toHeapify;

        //找出当前元素、左右两元素中最大的一个
        if(left < heap.getHeapSize() &&
                heap.getHeap().get(left) > heap.getHeap().get(largest)){
            largest = left;
        }
        if(right < heap.getHeapSize() &&
                heap.getHeap().get(right) > heap.getHeap().get(largest)){
            largest = right;
        }
        //如果当前元素不是最大的，和最大的交换
        if(largest != toHeapify){
            int temp = heap.getHeap().get(toHeapify);
            heap.getHeap().set(toHeapify, heap.getHeap().get(largest));
            heap.getHeap().set(largest, temp);
        }else return;
        MaxHeapify(heap, largest);//此时largest已经是交换后的位置了
    }

    public void MaxHeapifyNoneRecursive(Heap heap, int toHeapify){
        while (true){
            int left = leftOf(toHeapify);
            int right = rightOf(toHeapify);
            int heapSize = heap.getHeapSize();
            ArrayList<Integer> arrayList = heap.getHeap();
            int largest = toHeapify;
            if(left < heapSize && arrayList.get(left) > arrayList.get(toHeapify)){
                largest = left;
            }
            if(right < heapSize && arrayList.get(right) > arrayList.get(largest)){
                largest = right;
            }
            if(largest != toHeapify){
                int temp = arrayList.get(toHeapify);
                arrayList.set(toHeapify, arrayList.get(largest));
                arrayList.set(largest, temp);
            }else return;
            toHeapify = largest;
        }
    }

    public void buildMaxHeap(Heap heap){
        int heapsize = heap.getHeapSize();
        for(int i = (heapsize - 1) / 2; i >= 0; --i){
            this.MaxHeapify(heap, i);
        }
    }

    public void heapSort(Heap heap){
        buildMaxHeap(heap);
        int listLength = heap.getHeap().size();
        int heapSize = heap.getHeapSize();
        for(int i = listLength - 1; i >= 0; --i){
            int temp = heap.getHeap().get(i);
            heap.getHeap().set(i, heap.getHeap().get(0));
            heap.getHeap().set(0, temp);
            heap.setHeapSize(--heapSize);
            MaxHeapify(heap, 0);
        }

    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1003,2003,9,90,200,3,5,2,7));
        Heap heap = new Heap();
        heap.setHeap(list);
        new MaximunHeap().heapSort(heap);
        for(Integer i : heap.getHeap()){
            System.out.print(i + " ");
        }
    }
}