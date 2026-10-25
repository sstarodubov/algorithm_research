package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SplitterList<T> implements Iterable<List<T>> {
    final List<T> original;
    final int batchSize;

    public SplitterList(List<T> original, final int batchSize) {
        this.original = original;
        this.batchSize = batchSize;
    }

    @NotNull
    @Override
    public Iterator<List<T>> iterator() {
        return new BatchIterator<>(original, batchSize);
    }


    static void main() {
        var xxs = new SplitterList<>(List.of(1, 2,3,4,5,6,7,8,9, 10), 100);

        for (final var xs : xxs) {
            System.out.println(xs);
        }
    }

    private final static class BatchIterator<T> implements Iterator<List<T>> {
        int offset = 0;
        final List<T> original;
        final int batchSize;

        public BatchIterator(final List<T> original, final int batchSize) {
            this.original = original;
            this.batchSize = batchSize;
        }

        @Override
        public boolean hasNext() {
            return offset < original.size();
        }

        @Override
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            final int t = offset + batchSize;
            final int n = Math.min(original.size(), t);
            final var view = original.subList(offset, n);
            offset = t;
            return view;
        }
    }
}
