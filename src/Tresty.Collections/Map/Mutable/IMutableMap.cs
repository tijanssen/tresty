using Tresty.Collections.Map;

namespace Tresty.Collections.Map.Mutable;

public interface IMutableMap<TKey, TValue> : IMap<TKey, TValue>
{
    void Add(in TKey key, in TValue value);
}
