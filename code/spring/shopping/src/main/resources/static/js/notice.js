$(function(){
    if(grade != "A"){
        $("#create").hide();
    }
    else{
        $("#create").click(function(){
            location.href = "/admin/notice/create";
        });
    }
    
});


