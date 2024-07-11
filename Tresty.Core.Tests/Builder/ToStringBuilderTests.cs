using System;
using System.Globalization;
using Tresty.Core.Builder;
using Xunit;

namespace Tresty.Core.Tests.Builder;

public class ToStringBuilderTests
{
    [Theory]
    [InlineData(false, "field=False,")]
    [InlineData(true, "field=True,")]
    [InlineData(byte.MinValue, "field=0,")]
    [InlineData(byte.MaxValue, "field=255,")]
    [InlineData(sbyte.MinValue, "field=-128,")]
    [InlineData(sbyte.MaxValue, "field=127,")]
    [InlineData(UInt16.MinValue, "field=0,")]
    [InlineData(UInt16.MaxValue, "field=65535,")]
    [InlineData(Int16.MinValue, "field=-32768,")]
    [InlineData(Int16.MaxValue, "field=32767,")]
    [InlineData(UInt32.MinValue, "field=0,")]
    [InlineData(UInt32.MaxValue, "field=4294967295,")]
    [InlineData(Int32.MinValue, "field=-2147483648,")]
    [InlineData(Int32.MaxValue, "field=2147483647,")]
    [InlineData(UInt64.MinValue, "field=0,")]
    [InlineData(UInt64.MaxValue, "field=18446744073709551615,")]
    [InlineData(Int64.MinValue, "field=-9223372036854775808,")]
    [InlineData(Int64.MaxValue, "field=9223372036854775807,")]
    public void AppendGeneric_IConvertableValue_ReturnsCorrectBuildString(in IConvertible value, in string expectedResult)
    {
        var actualResult = new ToStringBuilder(CultureInfo.InvariantCulture).Append("field", value).Build();
        Assert.Equal(expectedResult, actualResult);
    }
}