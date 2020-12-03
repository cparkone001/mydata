<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Test</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">

var fd = new FormData();
fd.append( "file", $("input[name=file]").files[0]);

 $.ajax({
                type: "POST",
                url: "/upload",
                data: fd,
                contentType: false,
                processData: false,
                cache: false,
                /*beforeSend: function(xhr, settings) {
                    xhr.setRequestHeader("Content-Type", "multipart/form-data;boundary=gc0p4Jq0M2Yt08jU534c0p");
                    settings.data = {name: "file", file: inputElement.files[0]};                    
                },*/
                success: function (result) {                        
                    if ( result.reseponseInfo == "SUCCESS" ) {

                    } else {

                    }
                },
                error: function (result) {
                    console.log(result.responseText);
                }
            });

</script>


</head>
<body>
<h3> Upload File Form <h3>
<br/>
<form action="upload" enctype="multipart/form-data" method="post" >
          Upload File: <INPUT type="file" name="user-file">
           <INPUT type="submit" value="Upload File">
</form>
</body>
</html>