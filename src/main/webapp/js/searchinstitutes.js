$( document ).ready(function() {
    $(".campus-link").click(function(){
        var id = $(this).attr("value");
        var url = "/gradPlanner/institutes/" + id;
        $.get(url, {}, function(result){
            $("#institutes").html(result);
            $("#disciplines").empty();
        });
        }
    );
    $(document.body).on("click",".institutes-link",function(){ 
        var id = $(this).attr("value"); 
        var url = "/gradPlanner/disciplines/" + id; 
        $.get(url,{},function(result){ 
            $("#disciplines").html(result); 
        } )  
    } );
});
