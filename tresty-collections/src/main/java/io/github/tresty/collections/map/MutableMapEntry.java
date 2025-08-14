package io.github.tresty.collections.map;

public interface MutableMapEntry<K, V> extends MapEntry<K, V> {

    V setValue(V v);
}
