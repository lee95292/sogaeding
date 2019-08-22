<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- header bar -->
        <header class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/class">
                    <img src="/resources/imgs/icon/ic_logo.png" width="50px" height="50px">
                    <span id="logoTitle">PlayMate</span>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                  <ul class="navbar-nav mr-auto">
                    <li class="nav-item active" id="e_class_li">
                      <a class="nav-link" id="e_class">e 교실</a>
                    </li>
                    <li class="nav-item" id="e_room_li">
                      <a class="nav-link" id="e_room">e 강의실</a>
                    </li>
                  </ul>
                  <span class="navbar-text">
                    <img src="/resources/imgs/icon/ic_man.png" width="40px" height="40px">
                    <div class="navbar-user-select">
                    	<ul class="navbar-nav mr-auto">
                    		<li class="nav-item">	
		                      <a class="nav-link" id="goUser">내정보 </a>
		                    </li>
		                    <li class="nav-item">
		                      <a class="nav-link" href="/member/logout">로그아웃</a>
		                    </li>
		                  </ul> 
                    </div>
                  </span>
                </div>
        </header>
        <script type="text/javascript">
     	   $('header a').click(()=> {
				$('#user-info').html('');
			});
		
			$('#goUser').click(()=>{
				$.ajax({ 
					type: 'GET' , 
					url: '/user' , 
					dataType : 'html' , 
					success: function(data) { 
							$('.container-fluid').addClass('nodisplay');
							$('#user-info').html(data);
							$('#user-info').removeClass('nodisplay');
						} ,
					error: function (error) {
						window.alert('데이터를 받아오는데 실패하였습니다. 잠시후 다시 시도해주세요.');
						console.log(error);
					}
				
				});
			});
        </script>