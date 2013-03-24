define(["jquery", "calc/tokens", "calc/lexer"], function ($, tokens, lexer) {

			var lexer = new lexer();

			function matchOp(token, op) {
				return (typeof token !== 'undefined') &&
						token.type === tokens.Operator &&
						token.value === op;
			}

			// Primary ::= Identifier |
			//             Number |
			//             '(' Assignment ')' |
			//             FunctionCall
			function parsePrimary() {
				var token, expr;

				token = lexer.peek();

				if (typeof token === 'undefined') {
					throw new SyntaxError('Unexpected termination of expression');
				}

				if (token.type === tokens.Number) {
					token = lexer.next();
					return {
						'Number': token.value
					};
				}

				if (matchOp(token, '(')) {
					lexer.next();
					expr = parseAdditive();
					token = lexer.next();
					if (!matchOp(token, ')')) {
						throw new SyntaxError('Expecting )');
					}
					return {
						'Expression': expr
					};
				}

				throw new SyntaxError('Parse error, can not process token ' + token.value);
			}

			// Unary ::= Primary |
			//           '-' Unary
			function parseUnary() {
				var token, expr;

				token = lexer.peek();
				if (matchOp(token, '-') || matchOp(token, '+')) {
					token = lexer.next();
					expr = parseUnary();
					return {
						'Unary': {
							operator: token.value,
							expression: expr
						}
					};
				}

				return parsePrimary();
			}

			// Multiplicative ::= Unary |
			//                    Multiplicative '*' Unary |
			//                    Multiplicative '/' Unary
			function parseMultiplicative() {
				var token, left, right;

				left = parseUnary();
				token = lexer.peek();
				if (matchOp(token, '*') || matchOp(token, '/')) {
					token = lexer.next();
					right = parseMultiplicative();
					return {
						'Binary': {
							operator: token.value,
							left: left,
							right: right
						}
					};
				}
				return left;
			}

			// Additive ::= Multiplicative |
			//              Additive '+' Multiplicative |
			//              Additive '-' Multiplicative
			function parseAdditive() {
				var token, left, right;

				left = parseMultiplicative();
				token = lexer.peek();
				if (matchOp(token, '+') || matchOp(token, '-')) {
					token = lexer.next();
					right = parseAdditive();
					return {
						'Binary': {
							operator: token.value,
							left: left,
							right: right
						}
					};
				}
				return left;
			}

			function parse(expression) {
				var expr, token;

				lexer.reset(expression);
				expr = parseAdditive();

				token = lexer.next();
				if (typeof token !== 'undefined') {
					throw new SyntaxError('Unexpected token ' + token.value);
				}

				return {
					'Expression': expr
				};
			}

			return function () {
				return{
					parse: parse
				}
			};
		}
);
