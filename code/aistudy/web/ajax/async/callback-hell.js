// //Callback Hell example;가독성이 떨어진다. 체인이길어지면 디버깅이 어렵다.
// class UserStorage {
//     loginUser(id,password, onSuccess, onError){ //로그인 확인
//         setTimeout(()=>{ //서버역할, 어느정도 시간을 걸리게한다.
//             if (
//                 (id === 'study' && password === 'aistudy') ||
//                 (id === 'coder' && password === 'academy')
//             ) {
//                 onSuccess(id);
//             } else {
//                 onError(new Error('not found'))
//             }
//         }, 2000)
//     }
//     getRoles(user, onSuccess, onError){ //사용자 역할 받아오기
//         setTimeout(() => { //서버역할, 어느정도 시간을 걸리게한다.
//             if(user === 'study' ){
//                 onSuccess({ name : 'study', role : 'admin'});
//             } else {
//                 onError(new Error('no access'))
//             }
//         },1000)
 
//     }
// }
 
// const userStorage = new UserStorage();
// const id = prompt('enter your id');
// const password = prompt('enter your password');
// userStorage.loginUser(
//     id, 
//     password, 
//     user => {
//         userStorage.getRoles(
//             user,
//             userWithRole => {
//                 alert(`hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
//             },
//             error => {
//                 console.log(error);
//             }
//         );
//     }, 
//     error => { console.log(error)}
// );