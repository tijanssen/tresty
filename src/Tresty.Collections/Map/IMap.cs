using Tresty.Collections.Collection;

namespace Tresty.Collections.Map;
public interface IMap<TKey, TValue> : ICollection<(TKey, TValue)>
{
}
