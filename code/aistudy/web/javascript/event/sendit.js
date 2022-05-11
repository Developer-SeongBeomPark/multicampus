function sendit(){
    let str = document.getElementById('url').value; //id 로 검색
    //let str = document.regiform.url.value; --> name속성으로 검색
    console.log(`str: ${str}`);

    if(str == ''){
        alert('주소를 입력하세요');
        document.regiform.url.focus(); //name속성으로 검색
    }else{
        if(str.indexOf("https://") < 0){
            str = "https://" + str;
        }
        location.href = str; //주소 요청
    }
}

function direct_sendit(str){
    location.href = str;
}