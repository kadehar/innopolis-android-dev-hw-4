package collections;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public boolean add(E value) {
        link(value);
        return true;
    }

    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (e.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public boolean remove(E e) {
        if (e == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (e.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        for (Node<E> x = head; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private void link(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, e, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private Node<E> node(int index) {
        if (index < size) {
            Node<E> h = head;
            for (int i = 0; i < index; i++) {
                h = h.next;
            }
            return h;
        } else {
            Node<E> t = tail;
            for (int i = size - 1; i > index; i--)
                t = t.prev;
            return t;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Incorrect index " + index);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
