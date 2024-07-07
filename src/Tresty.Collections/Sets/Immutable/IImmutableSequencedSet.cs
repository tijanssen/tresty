using Tresty.Collections.Collection.Immutable;

namespace Tresty.Collections.Sets.Immutable;

public interface IImmutableSequencedSet<T> : IImmutableSet<T>, ISequencedSet<T>, IImmutableSequencedCollection<T>
{
    new IImmutableSequencedSet<T> Add(in T t);
    new IImmutableSequencedSet<T> AddFirst(in T t);
    new IImmutableSequencedSet<T> AddLast(in T t);
    new IImmutableSequencedSet<T> RemoveFirst();
    new IImmutableSequencedSet<T> RemoveLast();
    new IImmutableSequencedSet<T> Reverse();
}
