namespace Tresty.Collections.Collection.Mutable;

public interface IMutableCollection<T> : ICollection<T>
{
    void Add(in T t);
}
