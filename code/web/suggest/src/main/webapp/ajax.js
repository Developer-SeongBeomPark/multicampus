function sendKeyword(params) {
     return fetch(new Request('suggest.jsp', {
     method: 'post',
     headers: {
       "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
     },
     body: params 
       }))
       .then(response => response.text());
}
// post방식일 때만 header와 body를 사용한다.
// get방식의 ?keyword = 자 처럼 params를 옮기지 않고
// header를 통해서 params를 옮긴다. 그렇기 때문에 headers에서 content-type 명시가 필요하다.

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