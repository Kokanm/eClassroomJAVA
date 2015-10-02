
var names= ["student@mail.com", "profesor@mail.com",
    "administrator@mail.com"];

var passwords = ["student", "profesor", "administrator"];



function chkSubmit(event){
    var username = document.getElementById("user").value;
    var pass = document.getElementById("pasvd").value;


    if(names.indexOf(username) > -1){
        if(names.indexOf(username) == passwords.indexOf(pass)){
            var user = document.getElementById("login");
            switch(username){
                case "student@mail.com":
                    user.innerHTML = "You are logged in as <a href='myprofile.html'>Student</a> (<a href='index.xhtml'>log out</a>) ";
                    break;
                case "profesor@mail.com":
                    user.innerHTML = "You are logged in as <a href='myprofile.html'>Profesor</a> (<a href='index.xhtml'>log out</a>) ";
                    break;
                case "administrator":
                    user.innerHTML = "You are logged in as <a href='myprofile.html'>Administrator</a> (<a href='index.xhtml'>log out</a>) ";
                    break;
            }
            return true;
        }else{
            alert("Incorrect password!");
            return false;
        }
    } else {
        alert("Invalid username.");
        return false;
    }
}