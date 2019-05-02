using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CPFValidationFunctional
{
	public class CPFValidation
	{
		public static Func<IEnumerable<int>, IEnumerable<int>, int, (int,bool)> isDigitOkay = (list1, list2, expectedResult) =>
		   {
			   var digits = list1.Take(list2.Count());
			   var firstExpression = digits.Zip(list2, (x, y) => x * y);
			   var firstEvaluation = firstExpression.Sum() % 11;
			   var verificationDigit1 = (firstEvaluation < 2) ? 0 : 11 - firstEvaluation;
			   return (verificationDigit1,verificationDigit1 == expectedResult);
		   };
		public static Func<IEnumerable<int>, bool> isCPFOkay = (CPF) =>
		{
			var firstDigit = isDigitOkay(CPF, Enumerable.Range(2, 9).Reverse(), CPF.ToArray()[9]);
			var secondDigit = isDigitOkay(CPF.Append(firstDigit.Item1), Enumerable.Range(2, 10).Reverse(), CPF.ToArray()[10]);
			return firstDigit.Item2 && secondDigit.Item2;
		};
		public static void Main()
		{
			Console.WriteLine("Please, input your CPF: ");
			string output = Console.ReadLine();
			List<int> digits = new List<int>();
			foreach (char c in output)
				digits.Add(c - '0');
			Console.WriteLine("CPF OK: " + isCPFOkay(digits));
		}
	}
}
