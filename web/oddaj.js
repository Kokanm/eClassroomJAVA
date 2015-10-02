/**
 * Created by Kokanm on 11/11/2014.
 */
$(function() {

    $("#effect").resizable({maxHeight: 400,
        maxWidth: 700,
        minHeight: 200,
        minWidth: 250});

    $( "#inside" ).droppable({
        drop: function( event, ui ) {
            $( this )
                .addClass( "ui-state-highlight" )
                .find( "p" )
                .html( "Dropped!" );
        }
    });

    $("#button").click(function() {
        $( "#effect" ).show("fold", {}, 500);
    });



});