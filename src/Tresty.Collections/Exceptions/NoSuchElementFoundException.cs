using System;

namespace Tresty.Collections.Exceptions;

public sealed class NoSuchElementFoundException : Exception
{
    public NoSuchElementFoundException()
        : base("No such element found.")
    {
    }
}
