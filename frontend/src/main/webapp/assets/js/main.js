requirejs.config({
	baseUrl: 'assets/js',
	paths: {
		jquery: 'lib/jquery.min',
		bootstrap: '../bootstrap/js/bootstrap.min'
	},
	shim: {
		'bootstrap':{deps: ['jquery']}
	}
});

define(["app", "calc"], function (app, calc) {
			app.init();
			calc.init();
			return {};
		}
);