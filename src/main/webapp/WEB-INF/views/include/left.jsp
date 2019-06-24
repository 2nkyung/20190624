<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
난 왼쪽
<select id="pageController" onchange="changeValue(this)">
<option value="r1"> r1</option>
<option value="r2"> r2</option>
<option value="r3"> r3</option>
</select>
<script>
	
	document.querySelector('#pageController').value="${param.path}";
	function changeValue(f){
		if(f.value){
			location.href = "/views/include/select?path=" + f.value;
		}
	}
</script>

<%-- /* document.querySelector('#pageController').value="${param.page}";
	function changeValue(f){
		location.href = "/views/include/select?path=" + f.value;
	} */ --%>