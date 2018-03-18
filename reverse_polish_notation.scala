import scala.collection.mutable.{Stack, Set}

object ReversePolishNotation {
	def main(args: Array[String]): Unit = {
		var SpecialCharacters = Set("+", "-", "*", "/");

		// var arr = Array("2", "1", "+", "3", "*");
		var arr = Array("4", "13", "5", "/", "+");

		var stack = Stack[String]();

		for (c <- arr) {
			if (SpecialCharacters.contains(c)) {
				val rightVal = stack.pop();
				val leftVal = stack.pop();

				var newVal: String = "";

				if (c == "+") {
					newVal = (leftVal.toInt + rightVal.toInt).toString;
				} else if (c == "-") {
					newVal = (leftVal.toInt - rightVal.toInt).toString;
				} else if (c == "*") {
					newVal = (leftVal.toInt * rightVal.toInt).toString;
				} else if (c == "/") {
					newVal = (leftVal.toInt / rightVal.toInt).toString;
				}
				stack.push(newVal);
			} else {
				stack.push(c);
			}
			
		}
		println(stack.pop());
	}
}
// HelloWorld.main(Array())