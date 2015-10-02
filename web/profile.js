/**
 * Created by Kokanm on 11/11/2014.
 */
var nam = true;
var surname = true;
var email = true;
var phone = true;
var bday = true;



function chkNam(event) {

    var myNam = event.currentTarget;
    var pos = myNam.value.search(/^[A-Z][a-z]+$/);

    if (pos !== 0) {
        myNam.style.backgroundColor="#EE7777";
        myNam.focus();
        nam = false;
    } else {
        myNam.style.backgroundColor="#FFFFFF";
        nam =  true;
    }

}

function chkSurName(event) {

    var myName = event.currentTarget;
    var pos = myName.value.search(/^[A-Z][a-z]+$/);
    myName.style.backgroundColor="#C0FFC4";

    if (pos !== 0) {
        myName.style.backgroundColor="#EE7777";
        myName.focus();
        surname = false;
    } else {
        myName.style.backgroundColor="#FFFFFF";
        surname =  true;
    }

}

function chkPhone(event) {

    var myPhone = event.currentTarget;
    var pos = myPhone.value.search(/^\d{3}-\d{3}-\d{3}$/);

    if (pos !== 0) {
        myPhone.style.backgroundColor="#EE7777";
        myPhone.focus();
        phone = false;
    } else {
        myPhone.style.backgroundColor="#FFFFFF";
        phone =  true;
    }
}

function chkEmail(event){
    var myEmail = event.currentTarget;
    var pos = myEmail.value.search(/^\S+@\S+\.\S+$/);

    if (pos !== 0) {
        myEmail.style.backgroundColor="#EE7777";
        myEmail.focus();
        email = false;
    } else {
        myEmail.style.backgroundColor="#FFFFFF";
        email = true;
    }
}

function chkBirthday(event){

    var myBday = event.currentTarget;
    var pos = myBday.value.search(/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/);
    var year = (new Date()).getFullYear();

    if(pos !== 0) {
        myBday.style.backgroundColor="#EE7777";
        myBday.focus();
        bday = false;
    } else {
        if((myBday.value[0]+myBday.value[1]) < 1 || (myBday.value[0]+myBday.value[1]) > 31) {
            alert("Invalid value for day: " + myBday.value[0]+myBday.value[1]);
            myBday.style.backgroundColor="#EE7777";
            myBday.focus();
            bday = false;
        } else if((myBday.value[3]+myBday.value[4]) < 1 || (myBday.value[3]+myBday.value[4]) > 12) {
            alert("Invalid value for month: " + myBday.value[3]+myBday.value[4]);
            myBday.style.backgroundColor="#EE7777";
            myBday.focus();
            bday = false;
        } else if((myBday.value[6]+myBday.value[7]+myBday.value[8]+myBday.value[9]) < 1900 || (myBday.value[6]+myBday.value[7]+myBday.value[8]+myBday.value[9]) > year) {
            alert("Invalid value for year: " + myBday.value[6]+myBday.value[7]+myBday.value[8]+myBday.value[9] + " - must be between " + 1900 + " and " + year);
            myBday.style.backgroundColor="#EE7777";
            myBday.focus();
            bday = false;
        }else{
            myBday.style.backgroundColor="#FFFFFF";
            bday = true;
        }
    }
}

function chkSubmit(){
    if(nam && surname && phone && email && bday){
        alert("ALOOOO");
        return true;
    }else{
        alert("You filled the form incorrectly!");
        return false;
    }
}