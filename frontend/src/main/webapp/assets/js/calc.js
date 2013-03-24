define(["jquery", "lib/jquery.filter_input", "calc/parser"], function ($, filterInput, Parser) {
			var parser = new Parser();

			function exprToXml(object, key, depth) {
				var indent = '',
						str = '',
						value = object[key],
						i;

				while (indent.length < depth * 2) {
					indent += ' ';
				}

				var startTag = '\n' + indent + '<' + key + '>';
				var endTag = '</' + key + '>';
				if (depth == 0) {
					startTag = '\n' + indent + '<' + key + ' xmlns="http://calculator">';
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
						endTag = '\n' + indent + endTag;
						for (i in value) {
							if (value.hasOwnProperty(i)) {
								str += (exprToXml(value, i, depth + 1));
							}
						}
						break;
				}

				return startTag + str + endTag;
			}


			function sendToServer(url, data, cb) {
				$.ajax({
					type: 'POST',
					url: url,
					data: data,
					contentType: 'application/xml',
					dataType: "xml",
					success: function (xml) {
						$(xml).find('Result').each(function () {
							if (cb) {
								cb(
										$(this).find('Success').text(),
										$(this).find('Data').text(),
										$(this).find('Message').text()
								);
							}
						})
					}
				})
			}

			function showResult(msg) {
				$('#parse-result').html($('<div class="alert-info"><strong>RESULT:</strong> ' + msg + '</div>'));
			}

			function showError(msg) {
				$('#parse-result').html($('<div class="alert"><strong>ERROR</strong> ' + msg + '</div>'));
			}

			return {
				init: function () {
					// Init calc button
					$('#calc-button').click(function () {
						try {
							var res = parser.parse($('#expression').val());
							console.log(res);
							var xml = exprToXml(res, 'Expression', 0);
							console.log(xml);
							sendToServer('/rest/calc/perform?url=' + encodeURIComponent($('#service-url').val()), xml,
									function (succ, data, msg) {
										if (succ == "true") {
											showResult(data);
										} else {
											showError(msg);
										}
									});
						} catch (e) {
							showError(e);
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