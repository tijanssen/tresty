namespace Tresty.Collections.Map.Mutable;

public interface IMutableSequencedMap<TKey, TValue> : ISequencedMap<TKey, TValue>, IMutableMap<TKey, TValue>
{
    void AddFirst(in TKey key, in TValue value);
    void AddLast(in TKey key, in TValue value);
    new IMutableSequencedMap<TKey, TValue> Reverse();
}
