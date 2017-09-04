<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>회원가입 : Da Job</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/dajob/resources/images/sitelogo2_fix.png" />

<!-- CSS FILES -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" media="screen"
	data-name="skins">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/flexslider.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/font-awesome.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/animate.css'/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/switcher.css'/>" media="screen" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
font {
	font-size: 14pt;
}

table {
	margin-left: auto;
	margin-right: auto;
}

table tr td {
	size: 7px;
	padding-bottom: 5px;
	text-align: center;
}
table input{
	height: 34px;
}
</style>
</head>
<body>
	<!--Start Header-->
	<header>
		<c:import url="../header.jsp" />
		<div class="container page_head">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h2>Sign up</h2>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12">
					<nav id="breadcrumbs">
						<ul>
							<li>You are here:</li>
							<li><a href="index.do">Home</a></li>
							<li>Sign up</li>
						</ul>
					</nav>
				</div>
			</div>
			<!--./row-->
		</div>
		<!--./Container-->
	</header>

	<!--start wrapper-->
	<section class="wrapper">
		<section class="content contact">
			<div class="container">
				<div class="row sub_content mtype">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<p align="center">
							<img src="/dajob/resources/images/userEnroll/usermember.png"><br>
							<button class="btn btn-primary btn-lg user">일반 회원</button>
						</p>
						<font><b> 일반 회원</b> 은 사이트를 구직 목적으로 이용하고자 하는 회원을 말합니다. 내 능력
							분석 같은 전용 기능도 제공하니 가입하여 이용해보세요!!</font>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<p align="center">
							<img src="/dajob/resources/images/userEnroll/companymember.png"><br>
							<button class="btn btn-primary btn-lg company">기업 회원</button>
						</p>
						<font><b> 기업 회원</b> 은 사이트를 구인 목적으로 이용하고자 하는 회원을 말합니다. 여러
							구직을 원하는 능력자들이 많으니 어서 가입하셔서 데려가세요!!</font>
					</div>
				</div>

				<div class="row sub_content">
					<div class="col-lg-1 col-md-1 col-sm-1"></div>
					<div class="enrollUser col-lg-10 col-md-10 col-sm-10"
						style="display: none;">
						<div class="dividerHeading">
							<h4>
								<span>일반 회원 가입</span>
							</h4>
						</div>
						<form action="userEnroll.do" method="post">
							<table style="align-content: center; padding: 8px;">
								<tr><td>아이디 : </td>
									<td><input type="text" class="id" name="member_id"
										placeholder="아이디" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="idchk"></span>
									<!-- <button type="button" id="chkID">중복체크</button> --></td>
								</tr>
								<tr><td>비밀번호 : </td>
									<td><input type="password" name="member_password"
										placeholder="비밀번호" onkeyup="passcheck(this)" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="passcheckLayer"></span></td>
								</tr>
								<tr><td>비밀번호확인 : </td>
									<td><input type="password" name="member_password2"
										placeholder="비밀번호 확인" onkeyup="passcheck2(this)" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="passcheckLayer2"></span></td>
								</tr>
								<tr><td>회원이름 : </td>
									<td><input type="text" name="member_name"
										placeholder="가입자 이름" size="52%"></td>
								</tr>
								<tr><td>E-Mail : </td>
									<td><input type="text" name="email1" placeholder="가입자 이메일" size="15">&nbsp;
										@&nbsp; <input type="text" name="email2" value=""
										style="width: 120px" disabled>&nbsp; 
										<select	name="email" onchange="email_change(this)">
											<option value="0">선택하세요</option>
											<option value="9">직접입력</option>
											<option value="naver.com">naver.com</option>
											<option value="nate.com">nate.com</option>
											<option value="hanmail.net">hanmail.net</option>
											<option value="hotmail.com">hotmail.com</option>
											<option value="nate.com">nate.com</option>
											<option value="yahoo.co.kr">yahoo.co.kr</option>
											<option value="gmail.com">gmail.com</option>
									</select></td>
								</tr>
								<tr><td>연락처 : </td>
									<td><input type="text" name="member_phone"
										placeholder="연락처" size="52%"></td>
								</tr>
								<tr><td>우편번호 : </td>
									<td align="left"><input type="text" name="post_code"
										placeholder="우편번호">&nbsp;&nbsp;<button type="button" class="btn btn-default btn-xs" onclick="execDaumPostcode();">찾기</button></td>
								</tr>
								<tr><td>상세주소 : </td>
									<td><input type="text" name="addr1"
										placeholder="주소" size="22%" >&nbsp;<input type="text" name="addr2"
										placeholder="상세주소" size="22%" ></td>
								</tr>
								<tr><td>프로필<br>이미지 : </td>
									<td><p align="center"><input type="file" name="member_profile_img"></p></td>
								</tr>
								<tr>
									<td colspan="2"><button class="btn btn-success" type="submit">가입하기</button>&nbsp;&nbsp;
										<button class="btn btn-warning" type="reset">취소하기</button></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="enrollCompany col-lg-10 col-md-10 col-sm-10" style="display: none;">
						<div class="dividerHeading">
							<h4>
								<span>기업 회원 가입</span>
							</h4>
						</div>
						<form action="compEnroll.do" method="post">
							<table style="align-content: center; padding: 8px;">
								<tr><td>아이디 : </td>
									<td><input type="text" class="id" name="member_id"
										placeholder="아이디" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="idchk"></span>
									<!-- <button type="button" id="chkID">중복체크</button> --></td>
								</tr>
								<tr><td>비밀번호 : </td>
									<td><input type="password" name="member_password"
										placeholder="비밀번호" onkeyup="passcheck(this)" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="passcheckLayer"></span></td>
								</tr>
								<tr><td>비밀번호확인 : </td>
									<td><input type="password" name="member_password2"
										placeholder="비밀번호 확인" onkeyup="passcheck2(this)" size="52%"></td>
								</tr>
								<tr>
									<td colspan="2"><span class="passcheckLayer2"></span></td>
								</tr>
								<tr><td>회원이름 : </td>
									<td><input type="text" name="member_name"
										placeholder="가입자 이름" size="52%"></td>
								</tr>
								<tr><td>E-Mail : </td>
									<td><input type="text" name="email1" placeholder="가입자 이메일" size="15">&nbsp;
										@&nbsp; <input type="text" name="email2" value=""
										style="width: 120px" disabled>&nbsp; 
										<select	name="email" onchange="email_change(this)">
											<option value="0">선택하세요</option>
											<option value="9">직접입력</option>
											<option value="naver.com">naver.com</option>
											<option value="nate.com">nate.com</option>
											<option value="hanmail.net">hanmail.net</option>
											<option value="hotmail.com">hotmail.com</option>
											<option value="nate.com">nate.com</option>
											<option value="yahoo.co.kr">yahoo.co.kr</option>
											<option value="gmail.com">gmail.com</option>
									</select></td>
								</tr>
								<tr><td>연락처 : </td>
									<td><input type="text" name="member_phone"
										placeholder="연락처" size="52%"></td>
								</tr>
								<tr><td>우편번호 : </td>
									<td align="left"><input type="text" name="post_code"
										placeholder="우편번호">&nbsp;&nbsp;<button type="button" class="btn btn-default btn-xs" onclick="execDaumPostcode();">찾기</button></td>
								</tr>
								<tr><td>상세주소 : </td>
									<td><input type="text" name="addr1"
										placeholder="주소" size="22%" >&nbsp;<input type="text" name="addr2"
										placeholder="상세주소" size="22%" ></td>
								</tr>
								<tr><td>프로필<br>이미지 : </td>
									<td><p align="center"><input type="file" name="member_profile_img"></p></td>
								</tr>
								<tr>
									<td colspan="2"><button class="btn btn-success" type="submit">가입하기</button>&nbsp;&nbsp;
										<button class="btn btn-warning" type="reset">취소하기</button></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="col-lg-1 col-md-1 col-sm-1"></div>
				</div>
				<p align="center">
					<a href="javascript:history.back();"
						class="btn btn-default btn-lg back_home"> <i
						class="fa fa-arrow-circle-o-left"></i> Go to Back
					</a>
				</p>
			</div>
		</section>
	</section>
	<!--end wrapper-->

	<!--start footer-->
	<c:import url="../footer.jsp" />
	<!--end footer-->
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript">
	var s_default = {
		"border" : "1px solid #ccc",
		"background-color" : "#fff"
	}; //기본
	var s_fail = {
		"font-size" : "8pt",
		"color" : "red",
		"text-align" : "center"
	}; //실패
	var s_success = {
		"font-size" : "8pt",
		"color" : "green",
		"text-align" : "center"
	}; //성공
	$(function() {
		$('input[name=member_id]').keyup(function() {
			$.ajax({
				url : "dupid.do",
				type : "post",
				data : {
					userid : $('#member_id').val()
				},
				dataType : "text",
				success : function(value) {
					//alert("서블릿이 보낸 값 : " + data);
					var regex = /^[A-Za-z0-9]{5,14}$/;
					if ($('#member_id').val().length < 5) {
						var str = "아이디는 5자 이상이어야 합니다.";
						$('.idchk').html(str).css(s_fail);
					} else if (!regex.test($('#member_id').val())) {
						var str = "아이디는 영문자와 숫자만 가능합니다.";
						$('.idchk').html(str).css(s_fail);
					} else if (value === "ok") {
						var str = "사용 가능한 아이디입니다.";
						$('.idchk').html(str).css(s_success);
					} else {
						var str = "이미 존재하는 아이디입니다. 다른 아이디로 정하십시오.";
						$('.idchk').html(str).css(s_fail);
					}
				},
				error : function(value) {
					alert("에러 : " + value);
				}
			});
			return false;
		});
	});
	
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $('input[name=post_code]').val(data.zonecode); //5자리 새우편번호 사용
                $('input[name=addr1]').val(fullAddr);

                // 커서를 상세주소 필드로 이동한다.
                $('input[name=addr2]').focus();
            }
        }).open();
    }
	
	$(function() {
		$(".user").click(function() {
			reset();
			$(".enrollCompany").css('display', 'none');
			$(".enrollCompany .id").removeAttr('id', 'member_id');
			$(".enrollUser .id").attr('id', 'member_id');
			$(".enrollUser").show('slow');
		});
		$(".company").click(function() {
			reset();
			$(".enrollUser").css('display', 'none');
			$(".enrollUser .id").removeAttr('id', 'member_id');
			$(".enrollCompany .id").attr('id', 'member_id');
			$(".enrollCompany").show('slow');
		});
	});

	var reg_upw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{6,24}$/;//6~16자 영문대소문자, 숫자, 특수문자 혼합하여 사용

	function passcheck(e) {
		console.log($(e).val());
		if (reg_upw.test($(e).val())) {
			$('.passcheckLayer').text("안전한 비밀번호입니다.").css(s_success);
		} else {
			$('.passcheckLayer').text("6~16자 영문대소문자, 숫자, 특수문자 혼합하여 사용하세요").css(	s_fail);
		}

	}

	function passcheck2(e) {
		console.log($(e).parents());
		if ($(e).parent().parent().parent().find('input[name=member_password]')
				.val() != $(e).val()) {
			$('.passcheckLayer2').text("비밀번호가 일치하지 않습니다.").css(s_fail);
		} else {
			$('.passcheckLayer2').text("비밀번호 확인").css(s_success);
		}
	}

	function email_change(e) {
		//console.log($(e).val());
		var email2 = $(e).parent().find('input[name=email2]');
		if ($(e).val() == '0') {
			email2.attr('disabled', 'true');
			email2.val('');
		}
		else if ($(e).val() == '9') {
			email2.removeAttr('disabled');
			email2.val('');
			email2.focus();
		} else {
			email2.attr('disabled', 'true');
			email2.val($(e).val());
		}
	}
	
	function reset() {
		$(".enrollUser input").each(function() {
			$(this).val('');
		});
		$(".enrollCompany input").each(function() {
			$(this).val('');
		});
		$('.passcheckLayer').text('');
		$('.passcheckLayer2').text('');
		$('.idchk').html('');
	}
</script>
</html>