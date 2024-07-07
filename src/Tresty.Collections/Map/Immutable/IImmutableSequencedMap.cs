using Tresty.Collections.Collection.Immutable;

namespace Tresty.Collections.Map.Immutable;

public interface IImmutableSequencedMap<TKey, TValue> : IImmutableMap<TKey, TValue>, ISequencedMap<TKey, TValue>, IImmutableSequencedCollection<(TKey, TValue)>
{
    new IImmutableSequencedMap<TKey, TValue> Add(in (TKey, TValue) pair);
    new IImmutableSequencedMap<TKey, TValue> Add(in TKey key, in TValue value);
    new IImmutableSequencedMap<TKey, TValue> RemoveFirst();
    new IImmutableSequencedMap<TKey, TValue> RemoveLast();
    new IImmutableSequencedMap<TKey, TValue> Reverse();
}
