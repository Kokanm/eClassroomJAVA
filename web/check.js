/**
 * Created by Kokanm on 9/11/2014.
 */

var email = true;


function chkEmail(event) {
    var email1 = event.currentTarget;
    var email2 = document.getElementById("email");

    if (email1.value !== email2.value) {
        alert("The emails don't match!");
        email = false;
    } else {
        email = true;
    }
}
function chkSubmit(){
    if(email){
        return true;
    }else{
        alert("You filled the form incorrectly!");
        return false;
    }
}