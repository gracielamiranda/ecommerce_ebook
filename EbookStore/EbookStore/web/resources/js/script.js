$(function (){
    $("#myModal").modal('hide');   // initialized with no keyboard
    $(".detalhes-produtos").click(function (){
        var livro = JSON.parse($(this).attr("data-item"));
        $('#myModalLabel').text(livro.titulo);
        $('.modal-body').text(livro.descricao);
        $('#imgModal').attr("src",livro.capa);
        $("#myModal").modal('show');
        return false;
    });
});

function validatePdf(arquivo) {
      var file = arquivo.value;
      if(file == null || file == "")
          return true;
      if(file.toLowerCase().indexOf(".pdf") == -1 ) 
      {
          alert("Formato Inválido!!  O arquivo precisar ter a extensão pdf " );
          arquivo.value = "";
          return false;
      }
      return true;
  }
    function validateFoto(img)
    {
        var file = img.value;
        if(file == null || file == "")
            return true;
        if(file.toLowerCase().indexOf(".jpg") == -1 && file.toLowerCase().indexOf(".png") == -1   && file.toLowerCase().indexOf(".bmp") == -1 &&file.toLowerCase().indexOf(".jpeg") == -1) 
        {
            alert("Formato Inválido!! O arquivo precisar ter a extensão jpg/bmp/png");
            img.value = "";
            return false;
        }
        return true;
    } 
    
    function abrirModal(){
        $('#myModal').modal('show');
        return false;
    }