$(document).ready(function () {

    $("#searchItem").submit(function () {
        $("#loader").show();
        $("#loader").html("<img src = 'loading.gif' id ='loadImg'>");
        $.ajax({
            url: 'mainServlet',
            type: 'POST',
            dataType: 'json',
            data: $("#searchItem").serialize(),
            success: function (data) {
                var $dispResult = $("#displayResult");
                $dispResult.html("");
                var result = data.result;
                var singleResult = result.split("||");
                $("#loader").hide();
                $.each( singleResult, function( index, value ){
                     $dispResult.append(index+1 + " ::  " + value + "<br><br>");
                });
                $("#displayResult").slideDown(500);
                //$dispResult.remove();
            }
        });
        return false;
    });
});


