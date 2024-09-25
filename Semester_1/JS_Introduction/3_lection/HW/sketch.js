let sound;
let img;
let isInitialised;
let isLoaded = false;
let amplitude;
let amplitudes = [];

let fft;

function preload() {
    soundFormats("mp3", "wav");
    sound = loadSound("assets/Sound1.mp3", () => {
        console.log("sound is loaded!");
        isLoaded = true;
    });
    isInitialised = false;
    sound.setVolume(0.2);

    img = loadImage("assets/photo_2024-09-23_13-59-41.jpg");
}

function setup() {
    createCanvas(1024, 1024);
    textAlign(CENTER);
    isInitialised = false;

    amplitude = new p5.Amplitude();

    for (let i = 0; i < 512; i++) {
        amplitudes.push(0);
    }
    fft = new p5.FFT();
    img.filter(THRESHOLD);
    img.filter(INVERT);
    img.filter(GRAY);
}

function draw() {
    image(img, 0, 0);
    fill(255);
    noStroke();

    let energy = fft.getEnergy("bass");
    let energySize = map(energy, 0, 255, 250, 300);
    fill(255, 255 - energy, energy);
    ellipse(width / 2, height / 2, energySize);

    let hightEnergy = fft.getEnergy("highMid");
    let hightEnergySize = map(hightEnergy, 0, 255, 200, 250);
    fill(255 - energy / 2, energy, 0);
    ellipse(width / 2, height / 2, hightEnergySize);

    let level = amplitude.getLevel();
    amplitudes.push(level);
    amplitudes.shift();

    let freqs = fft.analyze();

    let size = map(level, 0, 0.2, 100, 200);
    let red = map(level, 0, 0.2, 0, 255);
    let green = 200;
    let blue = map(level, 0, 0.2, 255, 0);

    fill(red, green, blue);
    ellipse(width / 2, height / 2, size, size);

    if (isInitialised && !sound.isPlaying()) {
        fill("brown");
        textSize(50);

        text("Press any key for play soud", width / 2, height / 4);
    } else if (sound.isPlaying()) {
        strokeWeight(6);
        for (let i = 0; i < freqs.length; i += 4) {
            let cord = { x: i / 1.9, y: height - freqs[i] * 1.95 };

            line(512 - cord.x, cord.y, 512 - cord.x, cord.y);
            line(512 + cord.x, cord.y, 512 + cord.x, cord.y);
            stroke(i / 3, 200, 256 - i);
        }
    }
}

function keyPressed() {
    if (!isInitialised) {
        isInitialised = true;
        sound.setVolume(0.2);

        let r = map(mouseX, 0, width, 0.5, 4.0);
        if (isLoaded) {
            sound.loop(0, r);
        }
    } else {
        if (key == " ") {
            if (sound.isPaused()) sound.play();
            else sound.pause();
        }
    }
}
