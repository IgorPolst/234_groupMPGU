let currentTool = 'pen';
    let brushThickness = 5;
    let brushColor = '#000000';
    let startX, startY;

    function setup() {
      const canvas = createCanvas(windowWidth, windowHeight - 100);
      background(255);

      const toolSelect = document.getElementById('toolSelect');
      const thicknessSlider = document.getElementById('thicknessSlider');
      const colorPicker = document.getElementById('colorPicker');
      const clearButton = document.getElementById('clearCanvas');
      const saveButton = document.getElementById('saveDrawing');

      toolSelect.addEventListener('change', () => {
        currentTool = toolSelect.value;
      });
      thicknessSlider.addEventListener('input', () => {
        brushThickness = parseInt(thicknessSlider.value);
      });
      colorPicker.addEventListener('input', () => {
        brushColor = colorPicker.value;
      });
      clearButton.addEventListener('click', () => {
        background(255);
      });
      saveButton.addEventListener('click', () => {
        saveCanvas('myDrawing', 'png');
      });
    }

    function draw() {
      if (currentTool === 'pen' && mouseIsPressed) {
        stroke(brushColor);
        strokeWeight(brushThickness);
        line(mouseX, mouseY, pmouseX, pmouseY);
      }
      // line(50, 50, 100, 100);
      // saveCanvas("test2.2", "png");
      
      // const boundingBox = canvas.boundingBox();
      // const startX = boundingBox.x + 50;
      // const startY = boundingBox.y + 50;

      // line(startX, startY, startX+100, startY+100);

    }

    function mousePressed() {
      startX = mouseX;
      startY = mouseY;
    }

    function mouseReleased() {
      if (currentTool !== 'pen') {
        stroke(brushColor);
        strokeWeight(brushThickness);
        noFill();

        switch (currentTool) {
          case 'line':
            line(startX, startY, mouseX, mouseY);
            break;
          case 'rectangle':
            rectMode(CORNERS);
            rect(startX, startY, mouseX, mouseY);
            break;
          case 'circle':
            const diameter = dist(startX, startY, mouseX, mouseY);
            ellipseMode(CENTER);
            ellipse(startX, startY, diameter);
            break;
        }
      }
    }

    function windowResized() {
      resizeCanvas(windowWidth, windowHeight - 100);
      background(255);
    }