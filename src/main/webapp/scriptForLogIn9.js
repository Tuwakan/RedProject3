function onButtonLogInClick() {
    let data = document.getElementsByTagName('input');
    let login = encodeURIComponent(data[0].value);
    let password = encodeURIComponent(data[1].value);

    let xhr = new XMLHttpRequest();
    let body = login + ':' + password;

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
            else if (x === 'true') {
                //window.location.href = 'http://localhost:8080/signInPage'
                console.log("fff");
                $(document).ready(function(){
                    location.replace("http://localhost:8080/signInPage");
                });
            }
            // infinity
        }
        f1();
    })
