using System.Threading.Tasks;
using Cake.Core;
using Cake.Core.Diagnostics;
using Cake.Frosting;

namespace Build;

public static class Program
{
    public static int Main(string[] args)
        => new CakeHost()
            .UseContext<BuildContext>()
            .Run(args);
}
