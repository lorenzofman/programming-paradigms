using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MersennePrimeFinderFunctional
{
	public class MersenneFinder
	{
		private static Func<int, bool> IsPrime = number =>
		{
			return number > 1 && Enumerable.Range(2, number - 2).Where(n => number % n == 0).Count() == 0;
		};
		private static Func<int, int> CalculateMersennePrime = index =>
		{
			return 0;
		};
		protected static void Main() 
		{
			Console.WriteLine("Mersenne index: ");
			string input = Console.ReadLine();
			Console.WriteLine("Result: " + CalculateMersennePrime(Convert.ToInt32(input)));
		}
	}
}
