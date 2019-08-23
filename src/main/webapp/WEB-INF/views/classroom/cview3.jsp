<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h5>학급 공지사항</h5>
<br>
<div class="alert" style="
					    padding: 0;
					   
					    height: 100%;
					    margin: 0 auto;
					">
								   			<div class="upload" >
						<textarea name="textarea" id="textarea" col="8" row="10" >    
</textarea>
<div class="area_btn" onclick="uploadText3();">올리기</div>

</div>
			   			<div id="classnotice_views" class="views">
			   				
			   				<!-- 뷰 -->
			   			</div>
			    	</div>
			    	<!--  ========   -->
<script>
$(document).ready(()=>{
	getText3();
});
function uploadText3(){
	var content = $('#textarea').val();
	$.ajax({
		  url : "/keyadd/classnotice/"+content,
		    type : "GET",
		    success : function(){
		    			console.log("success upload");
		    			getText3();
		    	 },
		    	 error : function() {
		    			console.log("failed");
		    			alert("올리는데 실패하였습니다. 잠시후 다시 시도해주세요");
		    	 }
	    	});
	
}
function getText3(){
	$('#classnotice_views').html("");
	$.ajax({
		  url : "/class/classnotice",
		  contentType : "application/json",
		    type : "GET",
		    success : function(jsonData){
		    			console.log("success upload");
		    			//location.reload();
		    			for (var i = 0; i < jsonData.length; i++) {
							var Text = jsonData[i].content;
							let item = document.querySelector("#view_item").innerHTML;
							var resultitem = item.replace("{1}",Text);
							$('#classnotice_views').append(resultitem);
		    			}
		    	 }
	    	});
}
</script>