using Cake.Frosting;

namespace Build;

    [TaskName("Default")]
[IsDependentOn(typeof(TestTask))]
public sealed class DefaultTask : FrostingTask
{
}