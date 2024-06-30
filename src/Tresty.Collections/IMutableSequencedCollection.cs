namespace Tresty.Collections;

public interface IMutableSequencedCollection<T> : ISequencedCollection<T>
{
    void AddFirst(in T t);
    void AddLast(in T t);
    void RemoveFirst();
    void RemoveLast();
    new IMutableSequencedCollection<T> Reverse();
}
