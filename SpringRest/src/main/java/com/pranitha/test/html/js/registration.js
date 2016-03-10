function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
var repassword = document.getElementById("repassword").value;
if( username == "abc" && password == "123" && repassword == "123"){
//alert ("Registration successfully");
//window.location = "login.html"; // Redirecting to other page.
}

if(repassword != password){
    document.getElementById('errrepswd').innerHTML = " password's doesnt  match";
  document.getElementById('repassword').style.borderColor = "red";

}
else{
 //document.getElementById('errrepswd').innerHTML = " password's  match";
  document.getElementById('repassword').style.borderColor = "green";

}
}
function validate1(){
 var fn=document.getElementById('firstname').value;
    if(fn == ""){
        //alert('Please Enter First Name');
        document.getElementById('errfn').innerHTML = " please enter first name";
        document.getElementById('firstname').style.borderColor = "red";
        //return false;
    }else{
        document.getElementById('firstname').style.borderColor = "green";
        document.getElementById('errfn').innerHTML = "";

    }
    if (/^[0-9]+$/.test(document.getElementById("firstname").value)) {
        //alert("First Name Contains Numbers!");
        document.getElementById('firstname').style.borderColor = "red";
       // return false;
    }else{
        document.getElementById('firstname').style.borderColor = "green";
    }
    if(fn.length <=2){
       // alert('Your Name is To Short');
        document.getElementById('firstname').style.borderColor = "red";
        //return false;
    }else{
        document.getElementById('firstname').style.borderColor = "green";
    }
    var ln=document.getElementById('lastname').value;
    if(ln == ""){
            //alert('Please Enter Last Name');
            document.getElementById('errln').innerHTML = " please enter last name";
            document.getElementById('lastname').style.borderColor = "red";
            //return false;
        }else{
            document.getElementById('lastname').style.borderColor = "green";
            document.getElementById('errln').innerHTML = "";

        }

    var un=document.getElementById('username').value;
      if(un == ""){
              //alert('Please Enter Last Name');
              document.getElementById('errun').innerHTML = " please enter user name";
              document.getElementById('username').style.borderColor = "red";
          }else{
              document.getElementById('username').style.borderColor = "green";
              document.getElementById('errun').innerHTML = "";

          }
    var pwd=document.getElementById('password').value;
          if(pwd == ""){
                  //alert('Please Enter Last Name');
                  document.getElementById('errpswd').innerHTML = " please enter password";
                  document.getElementById('password').style.borderColor = "red";
              }else{
                  document.getElementById('password').style.borderColor = "green";
                  document.getElementById('errpswd').innerHTML = "";

              }
    var repwd=document.getElementById('repassword').value;
          if(repwd == ""){
                  //alert('Please Enter Last Name');
                  document.getElementById('errrepswd').innerHTML = " please enter password again";
                  document.getElementById('repassword').style.borderColor = "red";
              }else{
                  document.getElementById('repassword').style.borderColor = "green";
                   document.getElementById('errrepswd').innerHTML = "";

              }
    var un=document.getElementById('email').value;
          if(ln == ""){
                  //alert('Please Enter Last Name');
                  document.getElementById('erremail').innerHTML = " please enter email name";
                  document.getElementById('email').style.borderColor = "red";
              }else{
                  document.getElementById('email').style.borderColor = "green";
                  document.getElementById('erremail').innerHTML = "";

              }
}