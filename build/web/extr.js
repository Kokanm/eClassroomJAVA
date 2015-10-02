/**
 * Created by Kokanm on 11/11/2014.
 */
function chP(event){
    var myP = event.currentTarget;

    myP.style.cursor = "pointer";
    myP.style.color= "#841815";
    myP.style.textDecoration= "underline";
}

function chP2(event){
    var myP = event.currentTarget;

    myP.style.color= "#AC3A37";
    myP.style.textDecoration= "none";
}

function chP3(event){
    var myP = event.currentTarget;

    if(myP.innerHTML[0] = 'E') {
        myP.innerHTML = "Unenrol me from this course.";
        return true;
    }

    if(myP.innerHTML[0] = 'U'){
        myP.innerHTML = "Enrol me in this course.";
        return true;
    }
}
