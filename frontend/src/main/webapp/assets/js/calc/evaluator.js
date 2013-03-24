define(["calc/tokens", "calc/parser"], function (tokens, Parser) {

			var parser = new Parser();

			function exec(node) {
				var left, right, expr;

				if (node.hasOwnProperty('Expression')) {
					return exec(node.Expression);
				}

				if (node.hasOwnProperty('Number')) {
					return parseFloat(node.Number);
				}

				if (node.hasOwnProperty('Binary')) {
					node = node.Binary;
					left = exec(node.left);
					right = exec(node.right);
					switch (node.operator) {
						case '+':
							return left + right;
						case '-':
							return left - right;
						case '*':
							return left * right;
						case '/':
							return left / right;
						default:
							throw new SyntaxError('Unknown operator ' + node.operator);
					}
				}

				if (node.hasOwnProperty('Unary')) {
					node = node.Unary;
					expr = exec(node.expression);
					switch (node.operator) {
						case '+':
							return expr;
						case '-':
							return -expr;
						default:
							throw new SyntaxError('Unknown operator ' + node.operator);
					}
				}

				throw new SyntaxError('Unknown syntax node');
			}

			function evaluate(expr) {
				var tree = parser.parse(expr);
				return exec(tree);
			}

			return function () {
				return {
					evaluate: evaluate
				};
			};
		}
);
