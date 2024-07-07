using System.Collections.Generic;

namespace Tresty.Collections.Collection;

public interface ICollection<out T> : IEnumerable<T>
{
    int Count { get; }
}
