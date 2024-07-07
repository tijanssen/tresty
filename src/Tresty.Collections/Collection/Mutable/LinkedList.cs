using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using Tresty.Collections.Collection;

namespace Tresty.Collections.Collection.Mutable;

public sealed class LinkedList<T> : IMutableSequencedCollection<T>
{
    public int Count => throw new System.NotImplementedException();

    public void Add(in T t) => throw new System.NotImplementedException();
    public void AddFirst(in T t) => throw new System.NotImplementedException();
    public void AddLast(in T t) => throw new System.NotImplementedException();
    public IEnumerator<T> GetEnumerator() => throw new System.NotImplementedException();
    public void RemoveFirst() => throw new System.NotImplementedException();
    public void RemoveLast() => throw new System.NotImplementedException();
    public IMutableSequencedCollection<T> Reverse() => throw new System.NotImplementedException();
    IEnumerator IEnumerable.GetEnumerator() => throw new System.NotImplementedException();
    ISequencedCollection<T> ISequencedCollection<T>.Reverse() => throw new System.NotImplementedException();
}
