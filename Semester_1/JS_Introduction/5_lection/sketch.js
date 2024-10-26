let studentData;
let myPie;
let cityCount = {};


function preload() {
    studentData = loadTable("../4_lection/students.csv", "csv", "header");
    
}

function setup() {
    createCanvas(2000, 2000);
    const cities = studentData.getColumn("homeCity");
    myPie = new PieChart(500, 300, 400);
    countCities(cities);
    console.log(cityCount);
    
}

function draw() {
    noLoop();
    myPie.draw(Object.values(cityCount),Object.keys(cityCount),createColors(Object.values(cityCount).length),"Cities of residence" );
}

function createColors(numCol){
    let colors = [];
    for(let i = 0; i < numCol; i++){
        colors.push(generateColor());
    }

    function generateColor(){
        let letters = "0123456789ABCDEF"; 
  
        let color = '#'; 
        for (let i = 0; i < 6; i++) 
            color += letters[(Math.floor(Math.random() * 16))];
        return color;
    }
    return colors;
}

function countCities(allCities){
    for(let i = 0; i < allCities.length; i++){
        let city = allCities[i]; 
        if(!(city in cityCount)) cityCount[city] = 100;
        else cityCount[city]+= 100;
    }
}

function PieChart(x, y, diameter) {

  this.x = x;
  this.y = y;
  this.diameter = diameter;
  this.labelSpace = 30;

  this.get_radians = function(data) {
    let total = sum(data);
    let radians = [];

    for (let i = 0; i < data.length; i++) {
      radians.push((data[i] / total) * TWO_PI);
    }

    return radians;
  };

  this.draw = function(data, labels, colours, title) {

    // Test that data is not empty and that each input array is the
    // same length.
    if (data.length == 0) 
      alert('Data has length zero!'); 
    else if ([labels, colours].every((array) => {
      return array.length != data.length;
    })) {
      alert(`Data (length: ${data.length}) Labels (length: ${labels.length})` + 
            `Colours (length: ${colours.length}) Arrays must be the same length!`);
    }

    // https://p5js.org/examples/form-pie-chart.html

    var angles = this.get_radians(data);
    var lastAngle = 0;
    var colour;

    for (var i = 0; i < data.length; i++) {
      if (colours) {
        colour = colours[i];
      } else {
        colour = map(i, 0, data.length, 0, 255);
      }

      fill(colour);
      stroke(0);
      strokeWeight(1);

      arc(this.x, this.y,
          this.diameter, this.diameter,
          lastAngle, lastAngle + angles[i] + 0.001); // Hack for 0!

      if (labels) {
        this.makeLegendItem(labels[i], i, colour);
      }

      lastAngle += angles[i];
    }

    if (title) {
      noStroke();
      textAlign('center', 'center');
      textSize(24);
      text(title, this.x, this.y - this.diameter * 0.6);
    }
  };

  this.makeLegendItem = function(label, i, colour) {
    var x = this.x + 50 + this.diameter / 2;
    var y = this.y + (this.labelSpace * i) - this.diameter / 3;
    var boxWidth = this.labelSpace / 2;
    var boxHeight = this.labelSpace / 2;

    fill(colour);
    rect(x, y, boxWidth, boxHeight);

    fill('black');
    noStroke();
    textAlign('left', 'center');
    textSize(12);
    text(label, x + boxWidth + 10, y + boxWidth / 2);
  };
}

function sum(arr){
    let summ = 0;

    for (let i = 0; i < arr.length; i++) {
        summ += arr[i];
    }
    
    return summ;
}
