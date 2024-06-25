package io.github.tresty.collections.list;

import java.util.Collection;

import io.github.tresty.collections.iterator.MutableListIterator;
import io.github.tresty.common.Guard;

public final class MutableArrayList<E> implements MutableList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    private E[] elementData;

    private int size;

    public MutableArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MutableArrayList(final int initialCapacity) {
        if (initialCapacity < DEFAULT_INITIAL_CAPACITY) {
            elementData = (E[]) new Object[initialCapacity];
        } else {
            elementData = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }
    }

    @SafeVarargs
    public MutableArrayList(final E... args) {
        this(args.length < DEFAULT_INITIAL_CAPACITY ? DEFAULT_INITIAL_CAPACITY : args.length);
        Guard.againstContainsNull(args);
        System.arraycopy(args, 0, elementData, 0, args.length);
        size = args.length;
    }

    @Override
    public void addFirst(E e) {
    }

    @Override
    public void addLast(E e) {
    }

    @Override
    public void add(E e) {
    }

    @Override
    public int size() {
        return size;
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
    public E get(int index) {
        return null;
    }

    @Override
    public MutableListIterator<E> iterator() {
        return null;
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
