namespace Tresty.Collections;

public interface ISequencedCollection<out T> : ICollection<T>
{
    T First();
    T Last();
    ISequencedCollection<T> Reverse();
}
