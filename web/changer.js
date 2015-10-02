
var usr = document.getElementById("username");
usr.addEventListener("change", chkUser, false);

var password = document.getElementById("passwd");
password.addEventListener("blur", chkPassword, false);

var passwordA = document.getElementById("passwd2");
passwordA.addEventListener("change", chkPassword2, false);

var submits = document.getElementById("registration");
submits.addEventListener("submit", chkSubmit1, false);