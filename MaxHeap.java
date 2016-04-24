import java.util.ArrayList;

/**
 * This class implements the binary min heap data structure for use
 * as a priority queue.
 *
 * @author Nauman Ahmad
 */
public class BinaryMaxHeap <T extends Comparable<T>> {
    private ArrayList<T> array = new ArrayList<>();
    private int size;

    /**
     * Remove the max value from the heap ie the root.
     * @return The value removed
     */
    public T remove() {
        T value = array.get(0);
        array.set(0, array.get(size - 1));
        array.remove(size - 1);
        size--;
        rearrangeRemoval(0);
        return value;
    }

    /**
     * Rearrange the heap after the root has been removed
     * @param n The index of the root
     */
    private void rearrangeRemoval(int n) {
        int min = maxChildIndex(n);

        while (min != -1 && (array.get(n).compareTo(array.get(min)) < 0)) {
            swap(n, min);
            n = min;
            min = maxChildIndex(n);
        }
    }

    /**
     * Find the max child of a node
     * @param index The index of the node
     * @return Index of the child
     */
    public int maxChildIndex(int index) {
        if (left(index) >= size) return -1;
        if (right(index) >= size) return left(index);

        return array.get(left(index)).compareTo(array.get(right(index))) > 0 ? left(index): right(index);
    }

    /**
     * Push an item to the Heap
     * @param value The value to be added
     */
    public void add(T value) {
        array.add(size++, value);
        rearrangeInsertion();

    }

    /**
     * This method moves the newly inserted element to it's correct place.
     */
    private void rearrangeInsertion() {
        int index = size - 1; // Get index of last element

        while ((index > 0) && array.get(parent(index)).compareTo(array.get(index)) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * Get the max value in the heap ie the root
     */
    public T peek() {
        return array.get(0);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    private void swap(int indexOne, int indexTwo) {
        T tmp = array.get(indexOne);
        array.set(indexOne, array.get(indexTwo));
        array.set(indexTwo, tmp);
    }

    private boolean isEmpty() { return array.size() == 0; }

    @Override
    public String toString() { return array.toString(); }
}
