<%-- 
    Document   : newjsp
    Created on : 15.jan.2014, 12:19:27
    Author     : Zilca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function startRead()
{
  // obtain input element through DOM 
  
  var file = document.getElementById('file').files[0];
  if(file)
	{
    getAsText(file);
  }
}

function getAsText(readFile)
{
	var reader;
	try
	{
    reader = new FileReader();
	}catch(e)
	{
		document.getElementById('output').innerHTML = 
			"Error: seems File API is not supported on your browser";
	  return;
  }
  
  // Read file into memory as UTF-8      
  reader.readAsText(readFile, "UTF-8");
  
  // Handle progress, success, and errors
  reader.onprogress = updateProgress;
  reader.onload = loaded;
  reader.onerror = errorHandler;
}

function updateProgress(evt)
{
  if (evt.lengthComputable)
	{
    // evt.loaded and evt.total are ProgressEvent properties
    var loaded = (evt.loaded / evt.total);
    if (loaded < 1)
		{
      // Increase the prog bar length
      // style.width = (loaded * 200) + "px";
			document.getElementById("bar").style.width = (loaded*100) + "%";
    }
  }
}

function loaded(evt)
{
  // Obtain the read file data    
  var fileString = evt.target.result;
  document.getElementById('output').innerHTML = fileString;
  document.getElementById('output2').innerHTML = fileString;
		document.getElementById("bar").style.width = 100 + "%";
}

function errorHandler(evt)
{
  if(evt.target.error.code == evt.target.error.NOT_READABLE_ERR)
	{
    // The file could not be read
		document.getElementById('output').innerHTML = "Error reading file..."
  }
}
		</script>

<form accept-charset="utf-8" action="<c:url value="/access/fileread" />" method="POST"> 
		<input id="file" type="file" name="file" multiple onchange="startRead()">
		<h3>Progress:</h3>
		<div style="width:100%;height:20px;border:1px solid black;">
		<div id="bar" style="background-color:#45F;width:0px;height:20px;"></div>
		</div>
		<h3>File contents:</h3>
              <textarea style="display:none" id="output" name="output">${fileString}</textarea>
		<pre>
			<code id="output2">
			</code>
		</pre> 
            <label></label>
            <input class="button" type="submit" value="OK"/>

        </form>