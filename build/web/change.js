/**
 * Created by Kokanm on 10/11/2014.
 */
var password = true;
var usr = true;

var users = ["student", "profesor", "administrator"];

function chkUser(event){
    var myUser = event.currentTarget;
    if(!(users.indexOf(myUser.value) > -1)) {

        usr = false;
    } else {
        usr = true;
    }
}

function chkPassword(event){
    var myPassword = event.currentTarget;
    var pos = myPassword.value.search(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/);

    if (pos !== 0) {
        myPassword.style.backgroundColor="#EE7777";
        password = false;
    } else {
        myPassword.style.backgroundColor="#FFFFFF";
        password = true;
    }
}

function chkPassword2(event){
    var myPassword = event.currentTarget;
    var myPassword2 = document.getElementById("passwd");

    if (myPassword.value !== myPassword2.value) {
        alert("The passwords don't match!");
        password = false;
    } else {
        password = true;
    }
}


function chkSubmit1(){
    if(password){
        if(!usr)
            alert("User does not exist!");
        return true;
    }else{
        alert("You filled the form incorrectly!"+password);
        return false;
    }
}

