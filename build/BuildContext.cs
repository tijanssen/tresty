using Cake.Common;
using Cake.Core;
using Cake.Frosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Build;

public sealed class BuildContext : FrostingContext
{
    public string MsBuildConfiguration { get; set; }

    public BuildContext(ICakeContext context)
    : base(context)
        => MsBuildConfiguration = context.Argument("configuration", "Release");
}