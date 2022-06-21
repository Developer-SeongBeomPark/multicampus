$(function(){
    if(grade != "A"){
        $("#createbtn").hide();
    }
    
    $("#createbtn").click(function(){
        location.href = "/admin/notice/create";
    });
});


