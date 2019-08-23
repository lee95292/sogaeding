<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h5>과제방</h5>
<br>
<div class="alert" style="
					    padding: 0;
					   
					    height: 100%;
					    margin: 0 auto;
					">
								   			<div class="upload" style="
								   			border-radius:20px;
								   			margin-bottom: 20px;
								   			height: 30%;
								   			border: 1px solid #e4e9a4;
								   			width: 100%;
								   			background-color: #f8f9fa!important;
					">
						<textarea name="textarea" id="textarea" col="8" row="10" style="
    border-radius: 10px;
    position: relative;
    height: 80%;
    width: 80%;
    top: 20px;
    left: 20px;
    /* margin: 4.5% auto 4.5% 3%; */
    float: left;
">    
</textarea>
<div class="area_btn" style="
    background: orangered;
    line-height: 140px;
    border-radius: 10px;
    text-align: center;
    float: right;
    border: 1px solid gray;
    color: #fff;
    width: 10%;
    height: 80%;
    /* float: right; */
    right: 0;
    top: 20px;
    position: relative;
    right: 20px;
   
" onclick="uploadText4();">올리기</div>

</div>
			   			<div id="homework_views" class="views">
			   				
			   				<!-- 뷰 -->
			   			</div>
			    	</div>
			    	<!--  ========   -->
<script>
$(document).ready(()=>{
	getText4();
});
function uploadText4(){
	var content = $('#textarea').val();
	$.ajax({
		  url : "/keyadd/homework/"+content,
		    type : "GET",
		    success : function(){
		    			console.log("success upload");
		    			getText4();
		    	 },
		    	 error : function() {
		    			console.log("failed");
		    			alert("올리는데 실패하였습니다. 잠시후 다시 시도해주세요");
		    	 }
	    	});
	
}
function getText4(){
	$('#homework_views').html("");
	$.ajax({
		  url : "/class/homework",
		  contentType : "application/json",
		    type : "GET",
		    success : function(jsonData){
		    			console.log("success upload");
		    			//location.reload();
		    			for (var i = 0; i < jsonData.length; i++) {
							var Text = jsonData[i].content;
							let item = document.querySelector("#view_item").innerHTML;
							var resultitem = item.replace("{1}",Text);
							$('#homework_views').append(resultitem);
		    			}
		    	 }
	    	});
}
</script>