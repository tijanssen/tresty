using System.Collections.Generic;

namespace Tresty.Collections;

public interface ICollection<out T> : IEnumerable<T>
{
    int Count { get; }
}
