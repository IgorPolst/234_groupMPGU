let flying_nlo = {};

/** This function sets up our sketch. */
export function setup() {
    createCanvas(500, 500);
    frameRate(60);
    flying_nlo = {
        x:400,
        y:200, 
        width: 250,
        height: 100,
        neg_y_move: -1,
        pos_y_move: 1,
        neg_x_move: -2,
        pos_x_move: 2,

        color1: "#AFF0F0",
        coolor2: "#969696",

        draw_signal: function(){
            fill(255);
            for(let i = 0; i < 10; i++)
            circle(this.x - this.width/2 + i*27, this.y, 20,20);
        },
    
        draw_fly: function(){
        
            fill(this.color1);
            arc(this.x,this.y - this.height/2, this.width/2, this.height, PI, TWO_PI);
            fill(this.color2);
            arc(this.x, this.y, this.width, this.height + 10, PI, TWO_PI);
            fill(50);
            arc(this.x, this.y, this.width, this.height/2 - 10, 0, PI);
            draw_signal();
            

        }, 

        change_pos: function(){
            this.x += random(neg_y_move, pos_y_move);
            this.y += random(neg_x_move,pos_x_move);
        },    
        
        beam: function(){
            fill(255,255,10,150);
            beginShape();
            vertex(this.x - this.width/2, this.y);
            vertex(this.x + this.width/2, this.y);
            vertex(this.x + this.width, height - 100);
            vertex(this.x - this.width, height - 100);
            endShape();
        }
    }
}

 /** This function redraws the sketch multiple times a second. */
export function draw() {
    background (50,100,80);

    //ground
    fill(0,50,0);
    rect(0, height - 100, width, 100);
    flying_nlo.draw_fly();
    flying_nlo.change_pos();

}
