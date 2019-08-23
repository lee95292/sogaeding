<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h5>가정통신문</h5>
<br>
<div class="alert" style="
					    padding: 0;
					   
					    height: 100%;
					    margin: 0 auto;
					">
								   			<div class="upload" >
						<textarea name="textarea" id="textarea" col="8" row="10" >    
</textarea>
<div class="area_btn" onclick="uploadText1();">올리기</div>

</div>
			   			<div id="schoolnotice_views" class="views">
			   				
			   				<!-- 뷰 -->
			   			</div>
			    	</div>
			    	<!--  ========   -->
<script>
$(document).ready(()=>{
	getText1();
});
function uploadText1(){
	var content = $('#textarea').val();
	$.ajax({
		  url : "/keyadd/schoolnotice/"+content,
		    type : "GET",
		    success : function(){
		    			console.log("success upload");
		    			getText1();
		    	 },
		    	 error : function() {
		    			console.log("failed");
		    			alert("올리는데 실패하였습니다. 잠시후 다시 시도해주세요");
		    	 }
	    	});
	
}
function getText1(){
	$('#schoolnotice_views').html("");
	$.ajax({
		  url : "/class/schoolnotice",
		  contentType : "application/json",
		    type : "GET",
		    success : function(jsonData){
		    			console.log("success upload");
		    			//location.reload();
		    			for (var i = 0; i < jsonData.length; i++) {
							var Text = jsonData[i].content;
							let item = document.querySelector("#view_item").innerHTML;
							var resultitem = item.replace("{1}",Text);
							$('#schoolnotice_views').append(resultitem);
		    			}
		    	 }
	    	});
}
</script>