package collections;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elementData;
    private int index;

    public MyArrayList() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = (E[]) new Object[capacity];
    }

    public void add(E value) {
        if (index >= elementData.length) {
            growCapacity();
        }
        elementData[index] = value;
        index++;
    }

    public int indexOf(E value) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return result;
    }

    public int getSize() {
        return index;
    }

    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(elementData, index + 1,
                elementData, index, this.index - index);
        this.index--;

        return true;
    }

    public boolean add(int index, E value) {
        checkIndex(index);
        if (index == elementData.length) {
            growCapacity();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1, this.index - index);
        elementData[index] = value;
        this.index++;

        return true;
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(elementData[i]);
        }
    }

    private void growCapacity() {
        E[] newArr = (E[]) new Object[elementData.length * 2];
        System.arraycopy(elementData, 0,
                newArr, 0, index - 1);
        elementData = newArr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index) {
            throw new IllegalArgumentException();
        }
    }
}
