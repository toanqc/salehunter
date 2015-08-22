$(document).ready(
		function() {
			// Flex Silder
			$('.flexslider').flexslider(
					{
						animation : "fade",
						controlNav : true,
						directionNav : false,
						start : function(slider) {

							if ($("body").css('background-image') == 'none') {
								if (($("#column-left")[0])
										|| ($("#column-right")[0])) {
									// nothing
								} else {
									$("#slivalignder-bg").hide().css("height",
											slider.css("height"))
											.fadeIn("slow");
								}
							}

						}
					});

			// Image animation
			$(".fade-image, .box-category .menuopen, .box-category .menuclose")
					.on({
						mouseenter : function() {
							$(this).stop().fadeTo(300, 0.6);
						},
						mouseleave : function() {
							$(this).stop().fadeTo(300, 1);
						}
					});

			// Using default configuration
			$(".caruofredsel-featured").carouFredSel({
				infinite : false,
				auto : false,
				width : "100%",
				prev : {
					button : ".navigate-featured .prev",
					key : "left"
				},
				next : {
					button : ".navigate-featured .next",
					key : "right"
				},
				swipe : {
					onTouch : true,
					onMouse : false
				},
				onCreate : function(data) {
					$(this).css("height", "auto");
				}
			})

		});