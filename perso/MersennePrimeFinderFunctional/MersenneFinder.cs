using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MersennePrimeFinderFunctional
{
	public class MersenneFinder
	{
		private static Func<int, bool> IsPrime = number => number > 1 && Enumerable.Range(2, number - 2).Where(n => number % n == 0).Count() == 0;
		private static Func<int, int> CalculateMersennePrime = index => Enumerable.Range(1, 15).Where(x => IsPrime((int)Math.Pow(2, x) - 1)).Skip(index - 1).First();
		protected static void Main() 
		{
			Console.WriteLine("Mersenne index: ");
			string input = Console.ReadLine();
			Console.WriteLine("Result: " + CalculateMersennePrime(Convert.ToInt32(input)));
		}
	}
}
