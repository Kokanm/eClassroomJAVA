var idcount = 0;

function start(){

    document.getElementById( "newS" ).addEventListener("click", appendNode, false );
    document.getElementById( "replaceS").addEventListener("click", replaceNode, false);
    document.getElementById( "removeS" ).addEventListener( "click", removeC, false );
    document.getElementById( "prev" ).addEventListener("click", prev, false);
    document.getElementById( "next" ).addEventListener("click", next, false);
}

window.addEventListener( "load", start, false );

function appendNode()
{
    var para = document.createElement("p");
    var node = document.createTextNode(document.getElementById("newT").value);

    nodeId = "new" + idcount;
    ++idcount;
    para.setAttribute( "id", nodeId );
    para.appendChild(node);
    var curr = document.getElementById("para1");
    curr.appendChild(para);
    curr.setAttribute( "class", "" );
    para.setAttribute( "class", "highlighted" );
}

function replaceNode()
{
    var para = document.createElement("p");
    var node = document.createTextNode(document.getElementById("replaceT").value);

    nodeId = "new" + idcount;
    ++idcount;
    para.setAttribute( "id", nodeId );
    para.appendChild(node);

    var curr = document.getElementById("para1");
    curr.replaceChild(para, curr.firstChild);
    curr.setAttribute( "class", "" );
    para.setAttribute( "class", "highlighted" );
}

function removeC()
{
    var curr = document.getElementById("para1");
    curr.removeChild(curr.firstChild);
}

function next(){
    var curr = document.getElementById("para1");
    var s = curr.firstChild;
    s = s.nextSibling;
    s.setAttribute("class", "highlighted2");
}

function prev(){
    var target = currentNode.previousSibling;

    if ( target != document.body ){}
}
