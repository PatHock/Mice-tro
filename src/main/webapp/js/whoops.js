import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/whoops.css';

window.$ = require('jquery');

document.body.addEventListener("click", redirect);

function redirect() {
    window.location.href = "/micetr0/index";
}