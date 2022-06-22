$(function(){
    if(grade != "A"){
        $("#create").hide();
        $("#update").hide();
        $("#delete").hide();
    }
    else{
        $("#create").click(function(){
            location.href = "/admin/notice/create";
        });
    }
    
});


