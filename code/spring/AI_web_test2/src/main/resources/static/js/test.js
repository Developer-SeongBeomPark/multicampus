$(function(){
	$("#login_btn").click(function(){
		let id = document.getElementById("id").value;
		let pw = document.getElementById("pw").value;
		// alert(id + pw);
		return fetch(`/login/${id}/${pw}`)
			   .then(res => res.json())
			   .then(res =>{
					alert(res.name + "님 login ok Status Success");
				})
			   .catch(console.log);
			
	});
});


