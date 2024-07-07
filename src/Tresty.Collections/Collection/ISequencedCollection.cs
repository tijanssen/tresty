namespace Tresty.Collections.Collection;

public interface ISequencedCollection<out T> : ICollection<T>
{
    ISequencedCollection<T> Reverse();
}
