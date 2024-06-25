import org.jspecify.annotations.NullMarked;

@NullMarked module io.github.tresty.collections {
    requires org.jspecify;

    requires io.github.tresty.common;

    exports io.github.tresty.collections.collection;
    exports io.github.tresty.collections.iterable;
    exports io.github.tresty.collections.iterator;
    exports io.github.tresty.collections.list;
}
