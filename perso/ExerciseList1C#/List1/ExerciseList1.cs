using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/// <summary>
/// If you use Visual Studio you can use C# Interactive to have a ghci C# version, access it in View -> Other Windows -> C# Interactive
/// References: 
///		https://blog.submain.com/csharp-functional-programming/
///		https://www.tabsoverspaces.com/233633-head-and-tail-like-methods-on-list-in-csharp-and-fsharp-and-python-and-haskell
///		
/// </summary>
namespace List1
{
	class ExerciseList1
	{
		/// <summary>
		/// Encapsulates a method that has n parameters and returns a value of the type specified by the TResult parameter. Works like functions in Haskell
		/// We can take advantage of c# lambda expression which have a very similar syntax to Haskell
		/// The c# compiler can infer that x and y are integers because we specify that we have a Func<int,int,T>
		/// The syntax of a func in very similar to the way we do in Haskell, we get an integer and another one and transform in a 
		/// </summary>
		private static Func<int, int, int> SumSquares = (x, y) => x * x + y * y;

		private static Func<List<int>, List<int>, bool> HasEqualHeads = (x, y) => x.First() == y.First();

		private static Func<List<string>, List<string>> SuperList = (xs) => xs.Select(x => "Super" + x).ToList();

		private static Func<string, int> SpaceCount = (str) => str.Where(x => x == ' ').Count();

	}
}
