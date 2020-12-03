<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 테스트 입니다.</title>
    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
				$("#btn_action").click(function() {
					goAction();
					}
				)
            });
            
            function goAction() {
                //alert("gggggg");
            	$.getJSON( "http://localhost:8080/ajax.abc", function( data ) {
                    $("#gname").html(data["name"]);
                    $(data["members"]).each(function(i, member) {
                        if (i != 0) { $("#members").append(", "); }
                        $("#members").append(member);
                    });
                    $.each(data["albums"], function(key, value) {
                        $("#albums").append("<li>" + key + ": " + value + "</li>\n");
                    });
                });            	
            }
            
        </script>
        <title>JSON Sample with jQuery</title>
    </head>
</head>
<body>
    
    <h2 id="gname"></h2>
    <p>멤버 구성: <span id="members"></span></p>
    <h3>앨범 목록</h3>
    <ul id="albums"></ul>
    <br>
    
    <input type="button"  value="GoAction" name="btn_action" id="btn_action">
    
</body>
</html>
