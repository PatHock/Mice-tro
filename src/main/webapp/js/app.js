let MonoSynth = require("Tone").MonoSynth;
let synth = new MonoSynth();

while(true) {
    setTimeout(function () {
        synth.triggerAttack("C4");
    }, 3000);
}