$(function(){
	// $("#findId").click(function(){
    //     let mname = document.getElementById("mname").value;
	// 	let email = document.getElementById("email").value;
	// 	if(mname == "" || email == ""){
	// 		return;
	// 	}
		
	// 	return fetch(`/findId/${mname}/${email}`)
	// 		   .then(response => response.json())
	// 		   .then(response =>{
	// 				alert("아이디는 " + response.id + "입니다.");
	// 			})
	// 		   .catch(() => {
    //             alert("아이디가 존재하지 않습니다.");
    //            });
			
	// });

	$("#findId").click(function(){
        let mname = document.getElementById("mname").value;
		let email = document.getElementById("email").value;
		if(mname == "" || email == ""){
			return;
		}
		
		return fetch(`/mailid/${mname}/${email}`)
			   .then(response => response.text())
			   .then(text =>{
					alert(text);
				})
			   .catch(console.log);
			
	});

    $("#findPw").click(function(){
        let id = document.getElementById("id").value;
		let mname = document.getElementById("mname").value;
		if(mname == "" || id == ""){
			return;
		}
		return fetch(`/findPw/${id}/${mname}`)
			   .then(response => response.json())
			   .then(response =>{
					alert("비밀번호는 " + response.passwd + "입니다.");
				})
			   .catch(() => {
                alert("아이디가 존재하지 않습니다.")
               });
			
	});
});


