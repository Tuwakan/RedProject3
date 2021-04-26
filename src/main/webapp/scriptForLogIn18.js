$(document).ready(function(){
    $("button").click(function(){
        let data = document.getElementsByTagName('input');
        let login = encodeURIComponent(data[0].value);
        let password = encodeURIComponent(data[1].value);

        let xhr = new XMLHttpRequest();
        let body = login + ':' + password;

        xhr.open("POST", 'http://localhost:8080/authorization', true);
        xhr.send(body);
        doFetch();
    });
});

let isWarned = false;

function doFetch() {
    fetch('http://localhost:8080/authorization')
        .then(response => {
            async function f1() {
                let x = await response.text();

                if (x === 'false') {
                    if (!isWarned) {
                        let newDiv = document.createElement("div");
                        newDiv.innerHTML = "<font color=#8b0000>Such user doesnt exist</font>";

                        let my_div = document.getElementById("org_div1");
                        document.body.insertBefore(newDiv, my_div);
                        isWarned = true;
                    }
                } else if (x === 'true') {
                    $(document).ready(function(){
                        window.location.replace("http://localhost:8080/sessionInitialisation");
                    });
                    isWarned = false;
                }
            }
            f1();
        })
}
