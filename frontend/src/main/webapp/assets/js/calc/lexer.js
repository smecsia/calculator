define(["jquery", "calc/tokens"], function ($, tokens) {
			var expression = '', length = 0, index = 0, marker = 0;

			function peekNextChar() {
				var idx = index;
				return ((idx < length) ? expression.charAt(idx) : '\x00');
			}

			function getNextChar() {
				var ch = '\x00',
						idx = index;
				if (idx < length) {
					ch = expression.charAt(idx);
					index += 1;
				}
				return ch;
			}

			function isWhiteSpace(ch) {
				return (ch === '\u0009') || (ch === ' ') || (ch === '\u00A0');
			}

			function isDecimalDigit(ch) {
				return (ch >= '0') && (ch <= '9');
			}

			function createToken(type, value) {
				return {
					type: type,
					value: value,
					start: marker,
					end: index - 1
				};
			}

			function skipSpaces() {
				var ch;

				while (index < length) {
					ch = peekNextChar();
					if (!isWhiteSpace(ch)) {
						break;
					}
					getNextChar();
				}
			}

			function scanOperator() {
				var ch = peekNextChar();
				if ('+-*/()^%=;,'.indexOf(ch) >= 0) {
					return createToken(tokens.Operator, getNextChar());
				}
				return undefined;
			}

			function scanNumber() {
				var ch, number;

				ch = peekNextChar();
				if (!isDecimalDigit(ch) && (ch !== '.')) {
					return undefined;
				}

				number = '';
				if (ch !== '.') {
					number = getNextChar();
					while (true) {
						ch = peekNextChar();
						if (!isDecimalDigit(ch)) {
							break;
						}
						number += getNextChar();
					}
				}

				if (ch === '.') {
					number += getNextChar();
					while (true) {
						ch = peekNextChar();
						if (!isDecimalDigit(ch)) {
							break;
						}
						number += getNextChar();
					}
				}

				if (ch === 'e' || ch === 'E') {
					number += getNextChar();
					ch = peekNextChar();
					if (ch === '+' || ch === '-' || isDecimalDigit(ch)) {
						number += getNextChar();
						while (true) {
							ch = peekNextChar();
							if (!isDecimalDigit(ch)) {
								break;
							}
							number += getNextChar();
						}
					} else {
						ch = 'character ' + ch;
						if (index >= length) {
							ch = '<end>';
						}
						throw new SyntaxError('Unexpected ' + ch + ' after the exponent sign');
					}
				}

				if (number === '.') {
					throw new SyntaxError('Expecting decimal digits after the dot sign');
				}

				return createToken(tokens.Number, number);
			}

			function reset(str) {
				expression = str;
				length = str.length;
				index = 0;
			}

			function next() {
				var token;

				skipSpaces();
				if (index >= length) {
					return undefined;
				}

				marker = index;

				token = scanNumber();
				if (typeof token !== 'undefined') {
					return token;
				}

				token = scanOperator();
				if (typeof token !== 'undefined') {
					return token;
				}

				throw new SyntaxError('Unknown token from character ' + peekNextChar());
			}

			function peek() {
				var token, idx;

				idx = index;
				try {
					token = next();
					delete token.start;
					delete token.end;
				} catch (e) {
					token = undefined;
				}
				index = idx;

				return token;
			}

			return function () {
				return{
					reset: reset,
					next: next,
					peek: peek
				}
			};
		}
);
