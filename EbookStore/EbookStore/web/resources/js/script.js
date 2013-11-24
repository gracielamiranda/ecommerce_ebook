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

function validatePdf(arquivo) {
      var file = arquivo.value;
      if(file == null || file == "")
          return true;
      if(file.toLowerCase().indexOf(".pdf") == -1 ) 
      {
          alert(" O arquivo precisar ter a extensão pdf " );
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
            alert("Invalid File Format!! Please upload jpg/bmp/gif");
            img.value = "";
            return false;
        }
        return true;
    } 