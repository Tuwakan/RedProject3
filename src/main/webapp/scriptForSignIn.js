function onButtonSignInClick() {
    let data = document.getElementsByTagName('input');
    let login = encodeURIComponent(data[0].value);
    let password = encodeURIComponent(data[1].value);
    /*let confirmationPassword = encodeURIComponent(data[2].value);
    let my_div;
    if (password !== confirmationPassword) {
        let newDiv = document.createElement("div");
        newDiv.innerHTML = "<font color=#8b0000>Passwords matchless</font>";

        my_div = document.getElementById("org_div1");
        document.body.insertBefore(newDiv, my_div);
    }*/
    let xhr = new XMLHttpRequest();
    let body = login + ':' + password;
    xhr.open("POST", 'http://localhost:8080/registration', true);
    xhr.send(body);
}

fetch('http://localhost:8080/registration')
    .then(response => {
        async function f1() {
            let x = await response.text();
            /*console.log(x);
            if (x === 'true') {
                let newDiv = document.createElement("div");
                newDiv.innerHTML = "<font color=#8b0000>Such user already registered</font>";

                let my_div = document.getElementById("org_div1");
                document.body.insertBefore(newDiv, my_div);
            }
            else {
                redirect('http://localhost:8080/registration');
            }*/
        }
        f1();
    })

function redirect(url) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
}