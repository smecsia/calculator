({
	baseUrl: '${basedir}/src/main/webapp/assets/js',
	name: "lib/almond",
	include: ['main'],
	out: "${project.build.directory}/${project.build.finalName}/assets/js/all.js",
	wrap: true,
	insertRequire: ['main'],
	paths: {
		jquery: 'lib/jquery.min',
		bootstrap: '../bootstrap/js/bootstrap.min',
		main: 'main'
	}
})
