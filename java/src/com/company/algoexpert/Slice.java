package com.company.algoexpert;

import java.util.*;

public class Slice<E> implements List<E> {

    final List<E> list;
    final int begin;
    final int end;

    public Slice(List<E> list, int begin, int end) {
        if (begin > end || begin < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.list = list;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        if (size() == 1) {
            return "[" + getFirst() + "]";
        }
        var sb = new StringBuilder();
        int n = size();
        int last = n - 1;
        for (int i = 0; i < n; i++) {
            if (i == last) {
                sb.append(get(i).toString() + "]");
            } else if (i == 0) {
                sb.append("[" + get(i).toString() + ", ");
            } else {
                sb.append(get(i).toString() + ", ");
            }
        }

        return sb.toString();
    }

    private static class SliceIterator<E> implements Iterator<E> {
        final int end;
        int idx;
        final List<E> list;

        public SliceIterator(int begin, int end, List<E> list) {
            this.list = list;
            idx = begin;
            this.end = end;
        }

        @Override
        public boolean hasNext() {
            return idx < end;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Нет больше элементов");
            }
            return list.get(idx++);
        }
    }

    @Override
    public int size() {
        return end - begin;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (var el : this) {
            if (o == el || o.equals(el)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new SliceIterator<>(begin, end, list);
    }

    @Override
    public Object[] toArray() {
        int n = size();
        var arr = new Object[n];
        for (int i = 0; i < n; i++) {
           arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) toArray();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int i) {
        if (i >= size() || i < 0) throw new IndexOutOfBoundsException();
        return list.get(begin + i);
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (this.get(i) == o || this.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int i, int i1) {
        return new Slice<>(this, i, i1);
    }
}
