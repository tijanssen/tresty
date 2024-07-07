using Tresty.Collections.Collection;

namespace Tresty.Collections.Map;

public interface ISequencedMap<TKey, TValue> : IMap<TKey, TValue>, ISequencedCollection<(TKey, TValue)>
{
    new ISequencedMap<TKey, TValue> Reverse();
}
