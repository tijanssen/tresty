using System;
using System.Globalization;
using System.Text;

namespace Tresty.Core.Builder;

public class ToStringBuilder
{
    private const char CONTENT_START = '[';
    private const char CONTENT_END = ']';
    private const char FIELD_NAME_VALUE_SEPARATOR = '=';
    private const char FIELD_SEPERATOR = ',';
    private const char ARRAY_START = '{';
    private const char ARRAY_SEPARATOR = ',';
    private const char ARRAY_END = '}';
    private const string NULL_TEXT = "<null>";

    private StringBuilder _builder;
    private readonly CultureInfo _cultureInfo;

    public ToStringBuilder()
    {
        _builder = new StringBuilder(512);
        _cultureInfo = CultureInfo.CurrentCulture;
    }

    public ToStringBuilder(in CultureInfo cultureInfo)
    {
        _builder = new StringBuilder(512);
        _cultureInfo = cultureInfo;
    }

    public ToStringBuilder Append(in string fieldName, in object? value)
    {
            _builder = _builder.Append(fieldName).Append(FIELD_NAME_VALUE_SEPARATOR);
            if (value == null)
                _builder = _builder.Append(NULL_TEXT).Append(FIELD_SEPERATOR);
            else
                _builder = _builder.Append(value).Append(FIELD_SEPERATOR);
        return this;
    }

    public ToStringBuilder Append<T>(in string fieldname, in T? value)
        where T: IConvertible
    {
        _builder = _builder.Append(fieldname).Append(FIELD_NAME_VALUE_SEPARATOR);
        if (value == null)
            _builder = _builder.Append(value).Append(FIELD_SEPERATOR);
        else
            _builder = _builder.Append(value.ToString(_cultureInfo)).Append(FIELD_SEPERATOR);
        return this;
    }

    public string Build()
        => _builder.ToString();

    public override bool Equals(object? obj)
        => throw new NotImplementedException();

    public override int GetHashCode()
        => throw new NotImplementedException();

    public override string ToString()
        => throw new NotImplementedException();
}
