using System;

namespace Tresty.Collections.Exceptions;

public sealed class CollectionEmptyException : Exception
{
    public CollectionEmptyException()
        : base("The collection is empty.")
    {
    }
}
