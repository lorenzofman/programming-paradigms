using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MersennePrimeFinderFunctional
{
	public class MersenneFinder
	{

		private static Func<UInt64, UInt64> CalculateMersennePrime = index =>
		{
			return 0;
		};
		protected static void Main() 
		{
			Console.WriteLine("Mersenne index: ");
			string input = Console.ReadLine();
			Console.WriteLine("Result: " + CalculateMersennePrime(Convert.ToUInt64(input)));
		}
	}
}
