<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="youtubeList">
	<div class="recomend-btn-list">
		<!-- 추천키워드 제공 -->
		<%
			ArrayList<String> list = new ArrayList<String>();
			list.add("국어");
			list.add("진로");
			list.add("가정");
			list.add("대학교");
			list.add("중학수학");
			list.add("지리");
			list.add("언어");
			for(String x : list){
		%>
			 	<div class="re-btn" onclick="check_re_btn(this);" id="re-btn-<%= x %>"><%= x %></div>
	
		<%} %>
	</div>
	<h5 class="head-title">추천채널</h5>
	<div class="list">
			<div class="list-contents reco">
				
			</div>
	</div>
	<h5 class="head-title">지식채널 e</h5>
	<div class="list">
			<div class="list-contents ko">
				
			</div>
	</div>

	<h5 class="head-title">역사채널 e</h5>
	<div class="list">
		<div class="list-contents his">
				
			</div>
	</div>
</div>

<script id="j_item" type="text/template">
			<div class="item">
		            <a id="item-url" href="{1}" target="_blank">
						<img id="item-img" src="{2}">
		            </a>
				    <h5 id="item-title">
				    	{3}
					</h5>
          	  </div>
</script>
<script>
function check_re_btn(obj) {

	console.log($(obj));
	var current = $(obj).attr('class');
	console.log(current);
	if(current.includes('on')==true){
		$(obj).removeClass('on');
		recommend = recommend.replace($(obj).text(),"");
		transYT(recommend);
	} else {
		$(obj).addClass('on');
		recommend = $(obj).text()+" "+recommend;
		transYT(recommend);
	}
}
function transYT(t){
	console.log("========= yt start ========");
	$('.reco').empty();
	var y = t;
	let allData = { "key":k_ap_i,"channelId":EBS, "part":"snippet","q":y, "maxResult":"5"};

	$.ajax({
		  url : "https://www.googleapis.com/youtube/v3/search",
		    type : "GET",
		    contentType : "application/json",
		    data: allData,
		    success : function(jsonData){
		    	for (var i = 0; i < jsonData.items.length; i++) {
		    	     var items = jsonData.items[i];
		    	     var title = items.snippet.title+"";
		    	     var url = "https://youtu.be/"+items.id.videoId;
		    	     var img = items.snippet.thumbnails.high.url+"";
		    	     makeItem('reco',title,url,img);
		    	 	}
		    	 },
		    	 complete : function(jsonData) {
		    	 },
		    	 error : function(xhr, status, error) {
		    	 console.log("유튜브 요청 에러: "+error);
		    	 }
	

	    	});
 	}
</script>
<script>
let recommend="";
const k_ap_i=*****;
const EBS = "UCl_tB4AqPkkxuYcJQHz6dMw";

var type = {"ko":"지식채널e","his":"역사채널e","reco":recommend};

// 영상 위치 찾아가기
function makeItem(locate,title,id,img){
	var lo = "#youtubeList ."+locate;
	var list_content = $(lo);
	var item = document.querySelector("#j_item").innerHTML;
	var resultitem = item.replace("{1}",id).replace('{2}',img).replace('{3}',title);
	list_content.append(resultitem);
}

// 로드 될 때,
$(document).ready(()=> {
	for(let key in type){
		
		let allData = { "key":
			       
			       
			       
			       _i,"channelId":EBS, "part":"snippet","q":type[key], "maxResult":"20"};
		
		$.ajax({
			  url : "https://www.googleapis.com/youtube/v3/search",
			    type : "GET",
			    contentType : "application/json",
			    data: allData,
			    success : function(jsonData){
			    	for (var i = 0; i < jsonData.items.length; i++) {
			    	     var items = jsonData.items[i];
			    	     var title = items.snippet.title+"";
			    	     var url = "https://youtu.be/"+items.id.videoId;
			    	     var img = items.snippet.thumbnails.high.url+"";
			    	     makeItem(key,title,url,img);
			    	 	}
			    	 },
			    	 complete : function(jsonData) {
			    	 },
			    	 error : function(xhr, status, error) {
			    	 console.log("유튜브 요청 에러: "+error);
			    	 }
		
	
		    });
	    }
});
</script>
