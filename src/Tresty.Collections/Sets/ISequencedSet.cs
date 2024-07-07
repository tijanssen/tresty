using Tresty.Collections.Collection;

namespace Tresty.Collections.Sets;

public interface ISequencedSet<T> : ISet<T>, ISequencedCollection<T>
{
    new ISequencedSet<T> Reverse();
}
