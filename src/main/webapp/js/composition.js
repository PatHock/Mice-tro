import 'bootstrap';
import abcjs from "abcjs/midi";

window.$ = require('jquery');

import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/composition.css';

let abc = "T: Cooley's\n" +
    "M: 4/4\n" +
    "L: 1/8\n" +
    "R: reel\n" +
    "K: Emin\n" +
    "|:D2|EB{c}BA B2 EB|~B2 AB dBAG|FDAD BDAD|FDAD dAFD|\n" +
    "EBBA B2 EB|B2 AB defg|afe^c dBAF|DEFD E2:|\n" +
    "|:gf|eB B2 efge|eB B2 gedB|A2 FA DAFA|A2 FA defg|\n" +
    "eB B2 eBgB|eB B2 defg|afe^c dBAF|DEFD E2:|";

function load() {
    abcjs.renderAbc("compAbcjs", abc);
    abcjs.renderMidi("midi", abc);
    abcjs.renderMidi("midi-download", abc, { generateDownload: true, generateInline: false });
}

$('document').ready(function(){
    load();
});