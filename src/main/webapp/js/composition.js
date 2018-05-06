import 'bootstrap';
import abcjs from "abcjs/midi";

window.$ = require('jquery');

import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/composition.css';
// https://configurator.abcjs.net/visual

// window.onload = function () {
//     new abcjs.Editor("abc", {
//         canvas_id: "canvas",
//         generate_midi: true,
//         midi_id: "midi",
//         warnings_id: "warnings",
//         abcjsParams: {
//             generateInline: true,
//             generateDownload: false
//         }
//     })};


let abc = "T: Cooley's\n" +
    "M: 4/4\n" +
    "L: 1/8\n" +
    "R: reel\n" +
    "K: Emin\n" +
    "|:D2|EB{c}BA B2 EB|~B2 AB dBAG|FDAD BDAD|FDAD dAFD|\n" +
    "EBBA B2 EB|B2 AB defg|afe^c dBAF|DEFD E2:|\n" +
    "|:gf|eB B2 efge|eB B2 gedB|A2 FA DAFA|A2 FA defg|\n" +
    "eB B2 eBgB|eB B2 defg|afe^c dBAF|DEFD E2:|";

var tuneObjectArray;

function load() {
    return abcjs.renderAbc(
        "compAbcjs",
        abc,
        {
            add_classes: true,
            clickListener:
                function(abcElem, tuneNumber, classes) {
                   let note = getNoteFromClasses(classes);
                    console.log(note);

                    alert("Type " + abcElem.el_type+ "\n" +
                        "Pitch: " + abcElem.pitches[0].pitch + "\n" +
                        "Duration: " + abcElem.duration + "\n" +
                        "Measure Number: " + note.measureNum + "\n" +
                        "Measure Index: " + note.measureIndex
                    );
                },
            responsive: "resize",
        });
}

$('document').ready(function(){
    tuneObjectArray = load();
    console.log(tuneObjectArray);
    // console.log(getAbsoluteMeasureNumber(2, 1));
});

function getNoteFromClasses(classes) {
    var note = {};
    var noteElemList;
    let regClass = RegExp("((?<=abcjs-)[\\w]*)", "g"); //Regex to find individual class components

    for (var i in classes) {
        if (/note/.test(classes[0])) {
            noteElemList = classes[0].match(regClass);
        }
    }
    if(noteElemList !== undefined) {
        for (let i = 1; i<noteElemList.length; i++) {
            let noteElem = noteElemList[i];
            if (/l/.test(noteElem)) {
                note.line = parseInt(/(\d+)/.exec(noteElem)[0]);
            } else if (/m/.test(noteElem)) {
                note.measureNum = parseInt(/(\d+)/.exec(noteElem)[0]);
            } else if (/n/.test(noteElem)) {
                note.measureIndex = parseInt(/(\d+)/.exec(noteElem)[0]);
            }
        }
    }
    note.measureNum = getAbsoluteMeasureNumber(note.line, note.measureNum);
    return note;
}

function getAbsoluteMeasureNumber(lineNumber, measureNumber) {
    let lines = tuneObjectArray[0].lines;
    let numMeasures = 0;
    let absMeasNumber;

    for (let i = 0; i < lineNumber; i++) {
        for (let j=0; j<lines[i].staff[0].voices[0].length; j++) {
            if (lines[i].staff[0].voices[0][j].type === "bar_thin") {
                numMeasures++;
            }
        }
    }

    absMeasNumber = numMeasures + measureNumber;

    return  absMeasNumber;
}