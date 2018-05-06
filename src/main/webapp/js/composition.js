import 'bootstrap';
import abcjs from "abcjs/midi";

window.$ = require('jquery');

import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/composition.css';
// https://configurator.abcjs.net/visual

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
let abc = "T: Cooley's\n" +
    "M: 4/4\n" +
    "L: 1/8\n" +
    "R: reel\n" +
    "K: Emin\n" +
    "|:D2|EB{c}BA B2 EB|~B2 AB dBAG|FDAD BDAD|FDAD dAFD|\n" +
    "EBBA B2 EB|B2 AB defg|afe^c dBAF|DEFD E2:|\n" +
    "|:gf|eB B2 efge|eB B2 gedB|A2 FA DAFA|A2 FA defg|\n" +
    "eB B2 eBgB|eB B2 defg|afe^c|    |";
// "eB B2 eBgB|eB B2 defg|afe^c dBAF|DEFD E2:|";


function load() {
    return abcjs.renderAbc(
        "compAbcjs",
        abc,
        {
            add_classes: true,
            clickListener: function alertOnClick(abcElem) {
                alert("Type " + abcElem.el_type+ "\n" +
                "Pitch: " + abcElem.pitches[0].pitch + "\n" +
                "Duration: " + abcElem.duration + "\n" +
                    "Note Index: " + abcElem.measureNum
            );
                console.log(abcElem);
            },
            responsive: "resize",
        });
}

$('document').ready(function(){
    let tuneObjectArray = load();
});