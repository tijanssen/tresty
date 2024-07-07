using Tresty.Collections.Collection.Immutable;

namespace Tresty.Collections.Sets.Immutable;

public interface IImmutableSet<T> : ISet<T>, IImmutableCollection<T>
{
    new IImmutableSet<T> Add(in T t);
}
