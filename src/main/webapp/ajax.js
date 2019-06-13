

/* global b */

function ajaxFunction($el){
    var ajaxRequest;   
    
    try {        
               ajaxRequest = new XMLHttpRequest();
            } catch (e) {
               
               
               try {
                  ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
               } catch (e) {
                  
                  try {
                     ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                  } catch (e) {
                     
                     alert("Your browser broke!");
                     return false;
                  }
               }
            }
            
            
            ajaxRequest.onreadystatechange = function() {
            
               if(ajaxRequest.readyState === 4) {
                  var ajaxDisplay = document.getElementById('ajaxDiv');
                  ajaxDisplay.innerHTML = ajaxRequest.responseText;
                 
               }
            };
           
            var callno = $el.innerHTML;
            
            var url ="IssuedBooks?callno="+callno;
            ajaxRequest.open("GET",url,true);
            ajaxRequest.send();
}