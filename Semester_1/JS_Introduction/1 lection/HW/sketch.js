let flying_nlo = {
    x: 600,
    y: 400,
    width: 250,
    height: 100,
    color_1: "red",
    color_2: "yellow",
    
    draw_signal: function(){
        fill(255);
        for(let i = 0; i < 10; i++)
            circle(this.x - this.width/2 + i * 27, this.y, 10);
    },

    change_pos: function(direction){
        this.x += direction;
    },

    draw_fly: function(){
        fill(this.color_1);
        arc(this.x, this.y - this.height/2, this.width/2, this.height, PI, TWO_PI);
        fill(this.color_2);
        arc(this.x, this.y, this.width, this.height + 10, PI, TWO_PI);
        fill(50);
        arc(this.x, this.y, this.width, this.height/2, 0, PI);
        this.draw_signal();  
    },

    beam: function(){
        fill(255,255,100,150);
        
        beginShape();
        vertex(this.x - this.width/8.7, this.y + 10);
        vertex(this.x + this.width/8.7, this.y + 10);
        vertex(this.x + this.width/2.5, height - 100);
        vertex(this.x - this.width/2.5, height - 100);
        endShape();
    },

    in_beam: function(cow){
        let right = this.x + this.width/2.5;
        let left = this.x - this.width/2.5;
        return cow.x < right && cow.x > left && cow.y > this.y;
    }, 

    body: function(cow){
        let left = this.x - this.width / 2;
        let right = this.x  + this.width / 2;
        let top = this.y - this.height / 2;
        let bottom = this.y + this.height / 2;

        return cow.x > left && cow.x < right && cow.y > top && cow.y < bottom;
    }
}

let cows = [];

function Cow(x, y, direction)
{
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.isFall = false;
    this.isSuck = false;

    this.walk = function()
    {
        this.x += this.direction;
        if (this.x > width){
            this.x = 0; 
        } else if (this.x < 0){
            this.x = width;
        }
    }

    this.draw = function()
    {
        push();
        translate(this.x, this.y);
        if (this.direction > 0)
        {
            scale(-1, 1);
        }

        fill(255, 250, 250);
        rect(0, -10, 10, 5);
        
        rect(0, -5, 2, 5);
        rect(8, -5, 2, 5);

        rect(-4, -12, 4, 4);
        
        fill(0);
        rect(4, -9, 3, 3);
        rect(6, -10, 2, 2);

        pop();
    }

    this.update = function(){

        if (this.isFall && this.y < height - 100){
            this.y += 7;
        }

        if(this.y >= height - 100){
            this.y = height - 100;
            this.isFall = false;
            this.isSuck = false;
        }

        if (!this.isSuck){
            this.walk();}
    } 
}

let caughtCows = 0;

function CowManager()
{
    let countCows = 10;

    this.update = function()
    {
        while(cows.length < countCows)
        {
            cows.push(new Cow(random(0, width) , height - 100, random(-2, 2)));
        }

        for (let i = 0; i < cows.length; i++)
        {
            if (flying_nlo.in_beam(cows[i])){
                cows[i].y -= 6;
                cows[i].isFall = false;
                cows[i].isSuck = false;
            } 
            else 
                {if (cows[i].y < height - 100){
                    cows[i].isFall = true;
                }
            }

            if (flying_nlo.body(cows[i])){
                cows.splice(i, 1);
                caughtCows++;
                countCows--;
                i--;
            }

            cows[i].update();
        }
    }

    this.draw = function()
    {
        for(let i = 0; i < cows.length; i++)
            cows[i].draw();

        fill("black");
        textSize(40);
        textAlign(RIGHT);
        text("Собрано коров: " + caughtCows, width - 30, 40);
    }

    return this;
}

function setup() {
    createCanvas(1000, 1000);
    frameRate(30);
    noStroke();
}

function draw(){
    background(50,100, 80);

    let cowManager = new CowManager();
    cowManager.update();
    cowManager.draw();

    fill(0,50,0);
    rect(0, height - 100, width, 100);

    flying_nlo.draw_fly();
    flying_nlo.beam();

    if (keyIsDown(LEFT_ARROW))
        flying_nlo.change_pos(-4);
    if (keyIsDown(RIGHT_ARROW))
        flying_nlo.change_pos(4);
}