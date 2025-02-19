// get button
const button = document.querySelector("#ul_li");
button.addEventListener("click", function(){
    const listLi = document.querySelectorAll("li");


    for (let i = 0; i < listLi.length; i++)
        //listLi[i].style("background", "green"); work on p5 with style
        listLi[i].style.background = "green"; // clear js
});

// get div element into another element

//const correctDiv = document.getElementById("currectDiv");
const correctDiv = document.querySelector("div > div > div");
correctDiv.addEventListener("mouseover", () => {
   correctDiv.style.background = "green"; 
});
correctDiv.addEventListener("mouseout", () => {
    correctDiv.style.background = "red";
});

//get all div from document
const allDiv = document.querySelectorAll("div");
for (let i = 0; i < allDiv.length; i++)
{
    let element = allDiv[i];
    element.addEventListener("mouseover", () => {
        element.style.border = "5px solid black";
    });
    element.addEventListener("mouseout", () => {
        element.style.border = "0px solid black";
    });
}

const h1_action = document.querySelector("h1");
h1_action.addEventListener("click", () => {
    h1_action.style.background = "red";
});

const h2_action = document.querySelector("h2");
h2_action.addEventListener("contextmenu", () => {
    h2_action.style.background = "orange";
});

const h3_action = document.querySelector("h3");
h3_action.addEventListener("click", (event) => {
    if(event.ctrlKey){
    h3_action.style.background = "yellow";}
});

const h4_action = document.querySelector("h4");
h4_action.addEventListener("mouseover", () => {
    h4_action.style.background = "green";
});
h4_action.addEventListener("mouseout", () => {
    h4_action.style.background = "white";
});

const h5_action = document.querySelector("h5");
h5_action.addEventListener("mouseout", () => {
    h5_action.style.background = "blue";
});

const h6_action = document.querySelector("h6");
h6_action.addEventListener("dblclick", () => {
    h6_action.style.background = "purple";
});

let count = 1;
const text_alignment = document.querySelector("#headlines");
text_alignment.addEventListener("click", () => {
    const h_action = document.querySelectorAll(".head");
    h_action.forEach(h_action => {
        switch (count){
        case 1:
            h_action.style.textAlign = "center";
            break;
        case 2:
            h_action.style.textAlign = "right";
            break;
        case 3:
            h_action.style.textAlign = "left";
            break;
        }
    }
    );
    count ++;
    if (count == 4) count = 0;
});


