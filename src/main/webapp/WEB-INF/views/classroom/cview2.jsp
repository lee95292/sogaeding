<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<h5>학교 일정</h5>
<br>
<iframe src="https://calendar.google.com/calendar/embed?height=500&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=Asia%2FSeoul&amp;src=a28uc291dGhfa29yZWEjaG9saWRheUBncm91cC52LmNhbGVuZGFyLmdvb2dsZS5jb20&amp;color=%230B8043&amp;showTitle=0&amp;title=%ED%95%99%EA%B5%90%20%EC%BA%98%EB%A6%B0%EB%8D%94&amp;showTz=0&amp;showCalendars=0&amp;showTabs=0&amp;showPrint=0&amp;showDate=0&amp;showNav=0" style="border-width:0" width="800" height="500" frameborder="0" scrolling="no"></iframe>
<script>
/* var calendar = $('#calendar'); 
calendar.tuiCalendar({
	  defaultView: 'month',
	  useCreationPopup: true,
      useDetailPopup: true,
	  taskView: true,
	  template: {
	    monthGridHeader: function(model) {
	      var date = new Date(model.date);
	      var template = '<span class="tui-full-calendar-weekday-grid-date">' + date.getDate() + '</span>';
	      return template;
	    }
	  }
	});
alendar.prototype.createSchedules = function(schedules, silent) {
    var calColor = this._calendarColor;

    util.forEach(schedules, function(obj) {
        var color = calColor[obj.calendarId];

        if (color) {
            obj.color = color.color;
            obj.bgColor = color.bgColor;
            obj.borderColor = color.borderColor;
        }
    });

    this._controller.createSchedules(schedules, silent);

    if (!silent) {
        this.render();
    }
}; */
</script>