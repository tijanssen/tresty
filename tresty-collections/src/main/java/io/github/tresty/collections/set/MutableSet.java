package io.github.tresty.collections.set;

import io.github.tresty.collections.collection.MutableCollection;

public interface MutableSet<E> extends Set<E>, MutableCollection<E> {
    
    void difference(Set<? extends E> s);
    
    void intersection(Set<? extends E> s);
    
    void semetricDifference(Set<? extends E> s);

    void union(Set<? extends E> s);
}
