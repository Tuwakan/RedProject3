$(document).ready(function(){
    $("button").click(function(){
        let xhr = new XMLHttpRequest();
        xhr.open("GET", 'http://localhost:8080/deleteCookies', true);
        xhr.send();
        doFetch();
    });
});

$(document).ready(function() {
    document.addEventListener('keypress', (event) => {
        const keyName = event.key;

        if (keyName === "Enter") {
            let data = document.getElementsByTagName('input');
            let message = encodeURIComponent(data[0].value);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", 'http://localhost:8080/writerMessages', true);
            xhr.send(message);
        }
    });
});

function doFetch() {
    fetch('http://localhost:8080/deleteCookies')
        .then(response => {
            async function f1() {
                let x = await response.text();
                console.log(x);
                if (x === 'true') {
                    window.location.replace("http://localhost:8080/sessionInitialisation");
                }
            }

            f1();
        })
}

while (true) {
    setTimeout(myFunction, 3000)
}

function myFunction() {
    alert('Hello');
}