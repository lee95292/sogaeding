
function menu(obj){
		$('#student_menu .on, #teacher_menu .on').removeClass('on');
		obj.setAttribute('class','on');
		
		var now = obj.id;
		
		// 메뉴 데이터 받아오기 
		if(now!=''){
			$.ajax({ 
				type: 'GET' , 
				url: '/class/v/'+now , 
				dataType : 'html' , 
				success: function(data) { 
						$("#main_content_html").html(data);
					} ,
				error: function (error) {
					window.alert('데이터를 받아오는데 실패하였습니다. 잠시후 다시 시도해주세요.');
					console.log(error);
				}
			
			});	
		}
	}

