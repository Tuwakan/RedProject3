function onButtonSignInClick() {
    let data = document.getElementsByTagName('input');
    let login = encodeURIComponent(data[0].value);
    let password = encodeURIComponent(data[1].value);
    let confirmationPassword = encodeURIComponent(data[2].value);
    if (password !== confirmationPassword) {
        let newDiv = document.createElement("div");
        newDiv.innerHTML = "<font color=#8b0000>Passwords matchless</font>";

        let my_div = document.getElementById("org_div1");
        document.body.insertBefore(newDiv, my_div);
    } else {
        let xhr = new XMLHttpRequest();
        let body = login + ':' + password;
        xhr.open("POST", 'http://localhost:8080/registration', true);
        xhr.send(body);
        doFetch()
    }


}

function doFetch() {
    fetch('http://localhost:8080/registration')
        .then(response => {
            async function f1() {
                let x = await response.text();
                console.log(x);
                if (x === 'true') {
                    let newDiv = document.createElement("div");
                    newDiv.innerHTML = "<font color=#8b0000>Such user already registered</font>";

                    let my_div = document.getElementById("org_div1");
                    document.body.insertBefore(newDiv, my_div);
                } else if (x === 'false') {
                    $(document).ready(function () {
                        window.location.replace("http://localhost:8080/LogInPage.html");
                    });
                }
            }
            f1();
        })
}