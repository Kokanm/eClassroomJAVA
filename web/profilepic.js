/**
 * Created by Kokanm on 11/11/2014.
 */
var topp = "pic3";

function toTop(event) {

    var domTop = document.getElementById(topp).style;
    var domNew = event.currentTarget.style;

    domTop.zIndex = "0";
    domNew.zIndex = "10";
    topp = this.id;
}

function fonT(event) {

    var fo = event.currentTarget;

    fo.style.color = "#80C885";
    fo.style.fontWeight = "bolder";
}

function fonT2(event) {

    var fo = event.currentTarget;

    fo.style.color = "#000000";
    fo.style.fontStyle = "normal";
}