package io.github.tresty.collections.collection;

import java.util.Collection;

import io.github.tresty.collections.iterator.MutableSequencedIterator;

public final class LinkedList<E> implements MutableSequencedCollection<E> {

    @Override
    public void add(E e) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public MutableSequencedIterator<E> iterator() {
        return null;
    }

    @Override
    public void addFirst(E e) {
    }

    @Override
    public void addLast(E e) {
    }

    @Override
    public void add(Collection<? extends E> c) {
    }

    @Override
    public void add(io.github.tresty.collections.collection.Collection<? extends E> c) {
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public void removeLast() {
    }
}
