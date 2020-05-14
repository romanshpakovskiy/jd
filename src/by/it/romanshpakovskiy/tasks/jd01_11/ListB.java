package by.it.romanshpakovskiy.tasks.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private  T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        elements[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i > -1) remove(i);
        return (i > -1);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        T[] copyElements = (T[]) collection.toArray();
        if(copyElements.length == 0){
            return false;
        } else{
            if(size + copyElements.length >= elements.length){
                elements = Arrays.copyOf(elements, elements.length + copyElements.length);
            }
            System.arraycopy(copyElements, 0, elements, size, copyElements.length);
            size += copyElements.length;
            return true;
        }
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int i) {
        return elements[i];
    }

    @Override
    public T set(int i, T t) {
        if(i <= size){
            T oldEl = elements[i];
            elements[i] = t;
            return oldEl;
        }
        return null;
    }

    @Override
    public void add(int i, T t) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        System.arraycopy(elements, i, elements, i + 1, size - i);
        elements[i] = t;
        size++;
    }

    @Override
    public T remove(int i) {
        T el = elements[i];
        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
        elements[--size] = null;
        return el;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimiter = "";
        for(int i = 0; i < size; i++){
            stringBuilder.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
