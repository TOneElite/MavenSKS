<%-- 
    Document   : readfile
    Created on : 15.jan.2014, 12:19:27
    Author     : Zilca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<input type="file" id="files" name="file" /> Se innhold: 
<span class="readBytesButtons">
  <button onclick="show()" >Innhold</button>
</span>
<div id="byte_range"></div>
<div id="byte_content"></div>

<script>
  function readBlob(opt_startByte, opt_stopByte) {

    var files = document.getElementById('files').files;
    if (!files.length) {
      alert('Please select a file!');
      return;
    }

    var file = files[0];
    var start = parseInt(opt_startByte) || 0;
    var stop = parseInt(opt_stopByte) || file.size - 1;

    var reader = new FileReader();

    // If we use onloadend, we need to check the readyState.
    reader.onloadend = function(evt) {
      if (evt.target.readyState == FileReader.DONE) { // DONE == 2
          //replace section replaces linebreaks in file "\n" with linebreaks for html which
          //are usable with ".innerHTML" tag, "/xx/g" makes it a global occurence, meaning it happens every place with a \n linebreak
        document.getElementById('byte_content').innerHTML = evt.target.result.replace(/\n/g, "<br />");
        document.getElementById('output').textContent = evt.target.result;
      }
    };

    var blob = file.slice(start, stop + 1);
    reader.readAsBinaryString(blob);
  }
  
  document.querySelector('.readBytesButtons').addEventListener('click', function(evt) {
    if (evt.target.tagName.toLowerCase() == 'button') {
      var startByte = evt.target.getAttribute('data-startbyte');
      var endByte = evt.target.getAttribute('data-endbyte');
      readBlob(startByte, endByte);
    }
  }, false);
  
  function show(){
      document.getElementById('button').style.display="block";
  }
</script>

<form accept-charset="utf-8" action="<c:url value="/access/fileread${activeSubject}" />" method="POST"> 
    <textarea style="display:none" id="output" name="output">${fileString}</textarea>
    <input style="display: none" id="button" class="button" type="submit" value="OK"/>
</form>