<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/calendarJs/moment.min.js"></script>

<script type="text/javascript" src="/resources/js/calendarJs/pignose-calendar.js"></script>


<div id="date_module" class="container">
	<div class="row">
		<div class="col-sm calendar" style="border:none; position:absolute; padding:0; line-height: unset;     width: 90%;">
			 
			</div>
	</div>
</div>
<script type="text/javascript">
	$('.calendar').pignoseCalendar({
		lang: 'ko',
		});


</script>