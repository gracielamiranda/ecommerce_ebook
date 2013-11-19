$(function (){
    $("#myModal").modal('hide');   // initialized with no keyboard
    $(".detalhes-produtos").click(function (){
        var livro = JSON.parse($(this).attr("data-item"));
        $('#myModalLabel').text(livro.titulo);
        $('.modal-body').text(livro.descricao);
        $("#myModal").modal('show');
        return false;
    });
});