using Cake.Common.IO;
using Cake.Common.Tools.DotNet.Build;
using Cake.Common.Tools.DotNet;
using Cake.Core.Diagnostics;
using Cake.Core.Scripting;
using Cake.Core;
using Cake.Frosting;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Intrinsics.X86;
using System.Security.AccessControl;
using System.Threading.Tasks;
using System;
namespace Build;
[TaskName("Build")]
[IsDependentOn(typeof(CleanTask))]
public sealed class BuildTask : FrostingTask<BuildContext>
{
    public override void Run(BuildContext context)
        => context.DotNetBuild("../Tresty.sln", new DotNetBuildSettings
        {
            Configuration = context.MsBuildConfiguration,
        });
}