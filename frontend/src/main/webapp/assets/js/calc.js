define(["jquery", "lib/jquery.filter_input", "calc/parser"], function ($, filterInput, Parser) {
			var parser = new Parser();

			/**
			 * Stringify the expression
			 */
			function stringify(object, key, depth) {
				var indent = '',
						str = '',
						value = object[key],
						i;

				while (indent.length < depth * 2) {
					indent += ' ';
				}

				switch (typeof value) {
					case 'string':
						str = value;
						break;
					case 'number':
					case 'boolean':
					case 'null':
						str = String(value);
						break;
					case 'object':
						for (i in value) {
							if (value.hasOwnProperty(i)) {
								str += ('<br>' + stringify(value, i, depth + 1));
							}
						}
						break;
				}

				return indent + ' ' + key + ': ' + str;
			}

			return {
				init: function () {
					// Init calc button
					$('#calc-button').click(function () {
						try {
							var res = parser.parse($('#expression').val());
							console.log(res);
							$('#parse-result').html($('<pre class="syntaxtree">' + stringify(res, 'Expression', 0) + '</pre>'));
						} catch (e) {
							$('#parse-result').html($('<div class="alert"><strong>ERROR</strong> ' + e + '</div>'));
						}
						return false;
					});

					// Filtering input (preventing the undesirable characters)
					$('#expression').filter_input({regex: '[\\s0-9\\-\\+\\*\\/\\(\\)\\.]'});

					// Calculator buttons
					$('#calculator .numbers a.btn, #calculator .operators a.btn').click(function (idx, btn) {
						var value = $('#expression').val();
						$('#expression').val(value + $(this).prop('innerText'));
						return false;
					});
				}
			};
		}
);