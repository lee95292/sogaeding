<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="youtubeList">

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
let recommend="";
const apiKey="AIzaSyBhkeu38xXMwrK7W0feKPCaTj7KjTHM7fg";
const EBS = "UCl_tB4AqPkkxuYcJQHz6dMw";

var type = {"ko":"지식채널e","his":"역사채널e","reco":recommend};

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
		
		let allData = { "key":apiKey,"channelId":EBS, "part":"snippet","q":type[key], "maxResult":"20"};
		
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

function RunYoutubeApi() {
	var allData = { "key":"AIzaSyBhkeu38xXMwrK7W0feKPCaTj7KjTHM7fg","channelId":"UCl_tB4AqPkkxuYcJQHz6dMw", "part":"snippet","q":"역사채널e" , "maxResult":"20"};
	
		};
</script>