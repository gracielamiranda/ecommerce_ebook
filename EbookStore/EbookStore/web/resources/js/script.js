$(function (){
    $("#myModal").modal('hide');   // initialized with no keyboard
    $(".detalhes-produtos").click(function (){
        $("#myModal").modal('show');
        return false;
    });
});