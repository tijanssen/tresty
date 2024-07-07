using Tresty.Collections.Collection;

namespace Tresty.Collections.Collection.Mutable;

public interface IMutableSequencedCollection<T> : ISequencedCollection<T>, IMutableCollection<T>
{
    void AddFirst(in T t);
    void AddLast(in T t);
    void RemoveFirst();
    void RemoveLast();
    new IMutableSequencedCollection<T> Reverse();
}
