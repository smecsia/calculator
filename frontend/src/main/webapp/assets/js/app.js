define(["jquery", "bootstrap"], function ($) {

			function changePage(id) {
				$('#pages > div').each(function (idx, div) {
					$(div).hide();
				});
				$('#' + id).show();
				$('.navbar .nav > li').removeClass('active');
				$('.navbar .nav > li > a[data-target="' + id + '"]').parent().addClass('active');
			};

			return {
				init: function () {
					$('.navbar .nav > li > a').click(function () {
						changePage($(this).attr('data-target'));
					});
				}
			};
		}
);