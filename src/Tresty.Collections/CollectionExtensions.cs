namespace Tresty.Collections;
public static class CollectionExtensions
{
    public static bool Contains<T>(this ICollection<T> c, T value)
    {
        foreach (var item in c)
        {
            if (item.Equals(value))
                return true;
        }

        return false;
    }
}
