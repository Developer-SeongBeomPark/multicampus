// class UserStorage {
//     loginUser(id, password) {
//       return new Promise((resolve, reject) => {
//         setTimeout(() => {
//           if (
//             (id === 'study' && password === 'aistudy') ||
//             (id === 'coder' && password === 'academy')
//           ) {
//             resolve(id);
//           } else {
//             reject(new Error('not found'));
//           }
//         }, 2000);
//       });
//     }
  
//     getRoles(user) {
//       return new Promise((resolve, reject) => {
//         setTimeout(() => {
//           if (user === 'study') {
//             resolve({ name: 'study', role: 'admin' });
//           } else {
//             reject(new Error('no access'));
//           }
//         }, 1000);
//       });
//     }
  
//     // 추가된 곳 ?
//     async getUserWithRole(user, password) {
//       const id = await this.loginUser(user, password);
//       const role = await this.getRoles(id);
//       return role;
//     }
//   }
  
//   const userStorage = new UserStorage();
//   const id = prompt('enter your id');
//   const password = prompt('enter your passrod');
 
// //변경된곳
//   userStorage
//   .getUserWithRole(id, password) //
//   .then(user => alert(`Hello ${user.name}, you have a ${user.role} role`))
//   .catch(console.log)