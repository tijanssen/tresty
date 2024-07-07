namespace Tresty.Collections.Sets;

public static class SetExtensions
{
    public static bool Contains<T>(this ISet<T> s, in T value)
    {
        foreach (var item in s)
        {
            if (item.Equals(value))
                return true;
        }

        return false;
    }
}
