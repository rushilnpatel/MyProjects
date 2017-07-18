
function loadXMLDoc(dname)
{
    if (window.XMLHttpRequest)
    {
        xhttp=new XMLHttpRequest();
    }
    else
    {
        xhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.open("GET",dname,false);
    xhttp.send();
    return xhttp.responseXML;
}
    xmlDoc=loadXMLDoc("data.xml");
    x=xmlDoc.getElementsByTagName("pname");
    for (i=0;i<x.length;i++)
    {
            date=xmlDoc.getElementsByTagName("mfgDate")[i].childNodes[0].nodeValue;
            pname = xmlDoc.getElementsByTagName("pname")[i].childNodes[0].nodeValue;
            quantity = xmlDoc.getElementsByTagName("pcode")[i].childNodes[0].nodeValue;
            img = xmlDoc.getElementsByTagName("image")[i].childNodes[0].nodeValue;
            divText = '<tr>'+ '<td>'+ quantity +'</td>'+ '<td>' + pname + '</td>'+ '<td>' + date +'</td>'+'</tr>';
            document.getElementById("tb").innerHTML += divText;
    }
function imgChange(el) {
    if(el.value === "Show Image"){
        el.value = "Hide Image";
        document.getElementById("tb").innerHTML = "";
        for (i=0;i<x.length;i++)
        {
            date=xmlDoc.getElementsByTagName("mfgDate")[i].childNodes[0].nodeValue;
            pname = xmlDoc.getElementsByTagName("pname")[i].childNodes[0].nodeValue;
            quantity = xmlDoc.getElementsByTagName("pcode")[i].childNodes[0].nodeValue;
            img = xmlDoc.getElementsByTagName("image")[i].childNodes[0].nodeValue;
            divText = '<tr>'+ '<td>'+ quantity +'</td>'+ '<td>' + pname + '</td>'+ '<td>' + date +'</td>'+'<td>' +'<img src="'+img+'" height="100" width="100"/>'+'</td>'+'</tr>';
            document.getElementById("tb").innerHTML += divText;
        }
    }
    else {
        el.value = "Show Image";
        document.getElementById("tb").innerHTML = "";
        for (i=0;i<x.length;i++)
        {
            date=xmlDoc.getElementsByTagName("mfgDate")[i].childNodes[0].nodeValue;o
            pname = xmlDoc.getElementsByTagName("pname")[i].childNodes[0].nodeValue;
            quantity = xmlDoc.getElementsByTagName("pcode")[i].childNodes[0].nodeValue;
            img = xmlDoc.getElementsByTagName("image")[i].childNodes[0].nodeValue;
            divText = '<tr>'+ '<td>'+ quantity +'</td>'+ '<td>' + pname + '</td>'+ '<td>' + date +'</td>'+'</tr>';
            document.getElementById("tb").innerHTML += divText;
        }
    }
}