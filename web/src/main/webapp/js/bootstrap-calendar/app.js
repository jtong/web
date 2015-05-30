(function($) {

	"use strict";
	
	$.get('/web/api/v1/courses/').then(function(data){
	
		//console.log(JSON.stringify(data));
		var result = _.chain(data).map(function(item){
			return _.map(item.during.split(','), function(elem){
				return {
					id : item.id,
					title : item.name,
					"class": "event-important",
					start: Date.parse(elem),
					end: Date.parse(elem) + 45*60*1000
				}
			})
		}).flatten().value();
		console.log(JSON.stringify(result));

		var options = {
			events_source: function(){ return result},
			view: 'month',
			tmpl_path: 'views/tmpls/',
			tmpl_cache: false,
			day: '2012-02-29',
			onAfterEventsLoad: function(events) {
				if(!events) {
					return;
				}
				var list = $('#eventlist');
				list.html('');

				$.each(events, function(key, val) {
					$(document.createElement('li'))
						.html('<a href="' + val.url + '">' + val.title + '</a>')
						.appendTo(list);
				});
			},
			onAfterViewLoad: function(view) {
				$('.page-header h3').text(this.getTitle());
				$('.btn-group button').removeClass('active');
				$('button[data-calendar-view="' + view + '"]').addClass('active');
			},
			classes: {
				months: {
					general: 'label'
				}
			}
		};

		var calendar = $('#calendar').calendar(options);
		$('.btn-group button[data-calendar-nav]').each(function() {
			var $this = $(this);
			$this.click(function() {
				calendar.navigate($this.data('calendar-nav'));
			});
		});

		$('.btn-group button[data-calendar-view]').each(function() {
			var $this = $(this);
			$this.click(function() {
				calendar.view($this.data('calendar-view'));
			});
		});

		$('#first_day').change(function(){
			var value = $(this).val();
			value = value.length ? parseInt(value) : null;
			calendar.setOptions({first_day: value});
			calendar.view();
		});

		$('#language').change(function(){
			calendar.setLanguage($(this).val());
			calendar.view();
		});

		$('#events-in-modal').change(function(){
			var val = $(this).is(':checked') ? $(this).val() : null;
			calendar.setOptions({modal: val});
		});
		$('#events-modal .modal-header, #events-modal .modal-footer').click(function(e){
			//e.preventDefault();
			//e.stopPropagation();
		});
	});
	

	
}(jQuery));