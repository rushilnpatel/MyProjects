/**
 * Created by Rushil on 04/25/2017.
 */


var xmlhttp;
var output;
function empdata()
{

    if (window.XMLHttpRequest)
    {
        xmlhttp = new XMLHttpRequest();
        // alert(xmlhttp + "Window");
    }
    else
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        // alert(xmlhttp + "Microsoft");
    }

    xmlhttp.open("GET","empdata_JSON.json",true);
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var imageSrc = JSON.parse(xmlhttp.responseText);

            var output1 = imageSrc[0].src;
            var x = "<img src=" + "\"" + output1 + "\"" + "height=" + "\"" + "50px" + "\"" + "width=" + "\"" + "50px" + "\">";
            document.getElementById('img1').innerHTML = x;
            var output2 = imageSrc[1].src;
            var y = "<img src=" + "\"" + output2 + "\"" + "height=" + "\"" + "50px" + "\"" + "width=" + "\"" + "50px" + "\">";
            document.getElementById('img2').innerHTML = y;
            // alert(output2);
            var output3 = imageSrc[2].src;
            var z = "<img src=" + "\"" + output3 + "\"" + "height=" + "\"" + "50px" + "\"" + "width=" + "\"" + "50px" + "\">";
            document.getElementById('img3').innerHTML = z;



        }// alert(output3);
    };
    xmlhttp.send();


        var a = document.getElementById('img1');
        var b = document.getElementById('img2');
        var c = document.getElementById('img3');
        if (a.style.display === 'block' && a.style.display==='block' && c.style.display==='block') {
            a.style.display = 'none';
            b.style.display = 'none';
            c.style.display = 'none';
        } else {

            a.style.display = 'block';
            b.style.display = 'block';
            c.style.display = 'block';
        }



}
function clearData()
{
    document.getElementById('img1').innerHTML="";
    document.getElementById('img2').innerHTML="";
    document.getElementById('img3').innerHTML="";
}

