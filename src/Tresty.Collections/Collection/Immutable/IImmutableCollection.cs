namespace Tresty.Collections.Collection.Immutable;

public interface IImmutableCollection<T> : ICollection<T>
{
    IImmutableCollection<T> Add(in T t);
}
