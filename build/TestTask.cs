using Cake.Common.Tools.DotNet.Test;
using Cake.Common.Tools.DotNet;
using Cake.Frosting;

namespace Build;

    [TaskName("Test")]
[IsDependentOn(typeof(BuildTask))]
public sealed class TestTask : FrostingTask<BuildContext>
{
    public override void Run(BuildContext context)
        => context.DotNetTest("../Tresty.sln", new DotNetTestSettings
        {
            Configuration = context.MsBuildConfiguration,
            NoBuild = true,
        });
}