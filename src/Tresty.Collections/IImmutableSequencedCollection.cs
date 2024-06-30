namespace Tresty.Collections;

public interface IImmutableSequencedCollection<T> : ISequencedCollection<T>
{
    IImmutableSequencedCollection<T> AddFirst(in T t);
    IImmutableSequencedCollection<T> AddLast(in T t);
    IImmutableSequencedCollection<T> RemoveFirst();
    IImmutableSequencedCollection<T> RemoveLast();
    new IImmutableSequencedCollection<T> Reverse();
}
