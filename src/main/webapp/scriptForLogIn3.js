function onButtonLogInClick() {
    let data = document.getElementsByTagName('input');
    let login = encodeURIComponent(data[0].value);
    let password = encodeURIComponent(data[1].value);

    let xhr = new XMLHttpRequest();
    let body = login + ':' + password;

    xhr.onreadystatechange = function() {
        if(this.readyState === this.HEADERS_RECEIVED) {
            console.log(xhr.getResponseHeader("Location"));
        }
        if (xhr.readyState === 4) {
            console.log(xhr.response);
            console.log(xhr.status);
            console.log(this.HEADERS_RECEIVED);
        }
    }

    xhr.open("POST", 'http://localhost:8080/authorization', true);
    xhr.send(body);
}


fetch('http://localhost:8080/authorization')
    .then(response => {
        async function f1() {
            let x = await response.text();
            console.log(x);
            if (x === 'false') {
                let newDiv = document.createElement("div");
                newDiv.innerHTML = "<font color=#8b0000>Such user didn't register</font>";

                let my_div = document.getElementById("org_div1");
                document.body.insertBefore(newDiv, my_div);
            }
            else {
                redirect('http://localhost:8080/logInPage');
            }
        }
        f1();
    })

function redirect(url) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.send();
}
