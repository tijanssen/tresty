using System.Collections;
using System.Collections.Generic;
using Tresty.Collections.Collection;

namespace Tresty.Collections.Map.Mutable;

public sealed class ArrayMap<TKey, TValue> : ISequencedMap<TKey, TValue>
{
    public int Count => throw new System.NotImplementedException();

    public IEnumerator<(TKey, TValue)> GetEnumerator() => throw new System.NotImplementedException();
    public ISequencedMap<TKey, TValue> Reverse() => throw new System.NotImplementedException();
    IEnumerator IEnumerable.GetEnumerator() => throw new System.NotImplementedException();
    ISequencedCollection<(TKey, TValue)> ISequencedCollection<(TKey, TValue)>.Reverse() => throw new System.NotImplementedException();
}
