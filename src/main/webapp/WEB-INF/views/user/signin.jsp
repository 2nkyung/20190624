<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function checkValue(f){
	if(f.id.value.length < 5){
	alert('아이디는 5글자 이상이어야 합니다.');
		return false;
	}
	if(f.pwd.value.length < 8){
		alert('비밀번호는 8글자 이상이어야 합니다.');
		return false;
	}
	if(f.pwd.value != f.pwdChk.value){
		alert('비밀번호가 일치 하지 않습니다.');
		return false;
	}
	if(f.age.value<1 and f.age.value>130){
		alert('나이는 0 이상 130이하로 입력바랍니다.');
		return false;
	}
	if(f.email.value == '' || f.email.value.indexOf('.') == -1 
			|| f.email.value.indexOf('@') == -1){
		alert('이메일 주소를 적지 않았거나, 올바른 E-mail형식이 아닙니다.');
		return false;
	}
	alert('정상 가입 되었습니다.');
	return false;
}
</script>
<form onsubmit="return checkValue(this)">
	아이디 : <input type="text" name="id" id="id" required><br>
	비밀번호 : <input type="password" name="pwd" id="pwd"><br>
	비밀번호 확인 : <input type="password" name="pwdChk" id="pwdChk"><br>
	나이 : <input type="number" name="age" id="age" ><br>
	email : <input type="email" name="email" id="email" required><br>
	<button>회원가입</button>
</form>
</body>
</html>
