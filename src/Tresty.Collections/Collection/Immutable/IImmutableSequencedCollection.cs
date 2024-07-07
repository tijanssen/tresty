namespace Tresty.Collections.Collection.Immutable;

public interface IImmutableSequencedCollection<T> : ISequencedCollection<T>, IImmutableCollection<T>
{
    new IImmutableSequencedCollection<T> Add(in T t);
    IImmutableSequencedCollection<T> AddFirst(in T t);
    IImmutableSequencedCollection<T> AddLast(in T t);
    IImmutableSequencedCollection<T> RemoveFirst();
    IImmutableSequencedCollection<T> RemoveLast();
    new IImmutableSequencedCollection<T> Reverse();
}
