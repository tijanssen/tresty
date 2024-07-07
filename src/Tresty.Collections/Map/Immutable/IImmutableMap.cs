using Tresty.Collections.Collection.Immutable;

namespace Tresty.Collections.Map.Immutable;

public interface IImmutableMap<TKey, TValue> : IMap<TKey, TValue>, IImmutableCollection<(TKey, TValue)>
{
    new IImmutableMap<TKey, TValue> Add(in (TKey, TValue) pair);
    IImmutableMap<TKey, TValue> Add(in TKey key, in TValue value);
}
