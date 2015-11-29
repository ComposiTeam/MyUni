$( document ).ready(function() {
    $(".campus-link").click(function(){
        var id = $(this).attr("value");
        var url = "/gradPlanner/institutes/" + id;
        $.get(url, {}, function(result){
            $("#institutes").html(result);
        });
        }
    )
});
