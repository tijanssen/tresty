package io.github.tresty.collectionsmap;

public interface MutableMapEntry<K, V> extends MapEntry<K, V> {

    V setValue(V v);
}
