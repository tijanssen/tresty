using System;

namespace Tresty.Collections.Exceptions;

public sealed class CollectionCapacityReachedException : Exception
{
    public CollectionCapacityReachedException()
        : base("The maximum capacity of this collection is already reached.")
    {
    }
}
