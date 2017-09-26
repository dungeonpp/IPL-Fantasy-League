<!DOCTYPE html>

<html>
	<head>
		<title>Upload</title>
		<link rel="stylesheet" href="styles.css">
		<style>
		   body{
		     background: url("Cricket.jpg");
			 background-repeat: no-repeat;
			 background-size: 100% 200%;
		      }
			  
		</style>
	
	</head>

	<body>
	   
		<div class="container" float=center>
			<header>
				<div id="header">	
					<h1>Admin Dashboard</a></h1>
					<div class="clr"></div>
				</div>
			</header>
			
			<div class="feature">
				<div class="feature-inner">
				<h1>Upload Files</h1>
				</div>
			</div>
	
			<div id="content">				
			<div id ="content-inner">
			
			<br>
			
            <form method="post" action="uploadFile" enctype="multipart/form-data">
                Select file to upload:
                <input type="file" id="excel" name="uploadFile" />
                <br/><br/>

				<div>
				<button onclick="myFunction()" value="Upload" id="upload">UPLOAD</button>
				</div>
		</div>
<script>
function myFunction() {
	var y=document.getElementById("excel").value;
	var result = y.substring(12);
    var x = "C:/Users/Administrator/Desktop/"+result;
	if(x.endsWith(".xls")||x.endsWith(".xlsx"))
	{
	document.write(x);
	}
	else 
	{
	document.write("invalid file")
	}
}
</script>
				<br><br><br>
            </form>
       
			
			
			
			
			
			
			</div>
		</div>
	</body>
</html>
