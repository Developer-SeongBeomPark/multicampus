$(function(){
	$("#login_btn").click(function(){
		let id = document.getElementById("id").value;
		let pw = document.getElementById("pw").value;
		// alert(id + pw);
		get(id,pw)
		.then(member => {
			alert(member.name + "님 login ok Status Success");
		})
			
	});
});


// function loginchk() {
//     get({id : id, passwd : passwd})
// 	.then(read => {
// 		alert("ww");
// 	});
// }

function get(id, pw){
	let id = id;
	let passwd = pw;
	return fetch(`/login/${id}/${passwd}`,{method:'get'})
              .then(response => response.json())
              .catch(console.log);
}

