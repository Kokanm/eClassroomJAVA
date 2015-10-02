/**
 * Created by Kokanm on 11/11/2014.
 */
var tabe = document.getElementsByTagName("th");

for(t in tabe) {
    if(tabe.hasOwnProperty(t)) {
        tabe[t].addEventListener("mouseover", tab, false);
        tabe[t].addEventListener("mouseout", tab2, false);
    }
}

