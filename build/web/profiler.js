/**
 * Created by Kokanm on 11/11/2014.
 */


var lastName = document.getElementById("surname");
lastName.addEventListener("change", chkSurName, false);

var firstName = document.getElementById("firstname");
firstName.addEventListener("change", chkNam, false);

var phone = document.getElementById("telephone");
phone.addEventListener("change", chkPhone, false);

var email = document.getElementById("email");
email.addEventListener("change", chkEmail, false);

var bday = document.getElementById("datepicker");
bday.addEventListener("change", chkBirthday, false);

var submit = document.getElementById("prof");
submit.addEventListener("submit", chkSubmit, false);
