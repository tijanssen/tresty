namespace Tresty.Collections.Map;

public static class MapExtensions
{
    public static bool ContainsKey<TKey, TValue>(this IMap<TKey, TValue> map, in TKey key)
    {
        foreach (var pair in map)
            if (pair.Item1.Equals(key))
                return true;

        return false;
    }

    public static bool ContainsValue<TKey, TValue>(this IMap<TKey, TValue> map, in TValue value)
    {
        foreach (var pair in map)
            if (pair.Item2.Equals(value))
                return true;

        return false;
    }
}
