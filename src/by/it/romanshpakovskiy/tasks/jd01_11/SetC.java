package by.it.romanshpakovskiy.tasks.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private HashMap<T, Object> map = new HashMap<>();
    private Object mapV = new Object();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator<T> iterator = this.iterator();
        int count=0;
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (count < size() - 1){
                stringBuilder.append(", ");
            }
            count++;
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
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
        map.put(t, mapV);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == mapV;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            contains(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isAddAll = false;
        for (T element : collection) {
            isAddAll = add(element);
        }
        return isAddAll;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isRemoveAll = false;
        for (Object element : collection) {
            isRemoveAll = remove(element);
        }
        return isRemoveAll;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
