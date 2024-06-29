using Cake.Common.IO;
using Cake.Frosting;

namespace Build;

[TaskName("Clean")]
public sealed class CleanTask : FrostingTask<BuildContext>
{
    public override void Run(BuildContext context)
    {
        context.CleanDirectory($"../src/Tresty.Collections/bin/{context.MsBuildConfiguration}");
    }
}