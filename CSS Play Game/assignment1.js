/**
 * Created by Rushil on 5/27/2017.
 */
var txt= document.getElementById("txt");
function lft()
{
    txt.style.textAlign="left";
    txt.innerHTML="This text is Left Aligned";

}
function rgt()
{
    txt.style.textAlign="right";
    txt.innerHTML="This Text is Right Aligned";
}
function cntr()
{
    txt.style.textAlign="center";
    txt.innerHTML="This Text is Center Align";
}
function bld()
{
    txt.style.fontWeight="bolder";
    if ( document.getElementById('boldz').checked === false )
    {
        txt.style.fontWeight="normal";
    }
}
function itl()
{
    txt.style.fontStyle="italic";
    if ( document.getElementById('itl').checked === false )
    {
        txt.style.fontStyle="normal";
    }
}
function radioColor()
{
    if(document.getElementById("red").checked === true)
    {
        txt.style.color="red";
    }
    if(document.getElementById("green").checked === true)
    {
        txt.style.color="green";
    }
    if(document.getElementById("blue").checked === true)
    {
        txt.style.color="blue";
    }
}
function txtsize()
{
    var ddl = document.getElementById("ddl");
    var sze = ddl.options[ddl.selectedIndex].value;
    txt.style.fontSize=sze;
}
