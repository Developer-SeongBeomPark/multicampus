function sendKeyword(params) {
     return fetch(new Request('suggest.jsp', {
     method: 'post',
     headers: {
       "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
     },
     body: params
       }))
       .then(response => response.text());   
}
function select(selectedKeyword) {
    document.search.keyword.value = selectedKeyword;
     
    hide('suggest');
}
function show(id){
    if(id) {
        document.getElementById(id).style.display='';
    }
}
function hide(id){
    if(id) {
        document.getElementById(id).style.display='none';
    }
}