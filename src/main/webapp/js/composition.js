import 'bootstrap';
import abcjs from "abcjs/midi";

window.$ = require('jquery');

import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/composition.css';

window.onload = function () {
    new abcjs.Editor("abc", {
        canvas_id: "canvas",
        generate_midi: true,
        midi_id: "midi",
        warnings_id: "warnings",
        abcjsParams: {
            generateInline: true,
            generateDownload: false
        }
    });
}

$('document').ready(function(){
});