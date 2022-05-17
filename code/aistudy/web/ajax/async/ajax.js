class UserStorage {
    constructor() {
      if (window.XMLHttpRequest) {
        this.xhr = new XMLHttpRequest();
      } else {
        // code for IE6, IE5
        this.xhr = ActiveXObject('Microsoft.XMLHTTP');
      }
      console.log(this.xhr);
    }
   
    loginUser(id, passwd) {
      return new Promise((resolve, reject) => {
        this.xhr.onload = () => {
          // alert(this.xhr.responseText);
          resolve(this.xhr.responseText);
        };
        this.xhr.onerror = () => {
          reject(new Error(this.xhr.status));
        };
        //alert(`pay.jsp?id=${id}&passwd=${passwd}`);
        this.xhr.open('GET', `pay.jsp?id=${id}&passwd=${passwd}`, true);
        this.xhr.send();
      });
    }
  }