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

var table = document.getElementById("tb1");
//var table = document.createElement('TABLE');
var tableBody = document.createElement('TBODY');

//table.border = '1';
table.appendChild(tableBody);

var heading = new Array();
heading[0] = "Code";
heading[1] = "Name";
heading[2] = "MFG Date";
heading[3] = "Image";


//TABLE COLUMNS
var tr = document.createElement('TR');
tableBody.appendChild(tr);
for (i = 0; i < heading.length; i++) {
    var th = document.createElement('TH');
    th.width = '75';
    th.appendChild(document.createTextNode(heading[i]));
    tr.appendChild(th);
}

//TABLE ROWS
for (i = 0; i < x.length; i++) {
    var tr = document.createElement('TR');
    date=xmlDoc.getElementsByTagName("mfgDate")[i].childNodes[0].nodeValue;
    pname=xmlDoc.getElementsByTagName("pname")[i].childNodes[0].nodeValue;
    quantity=xmlDoc.getElementsByTagName("pcode")[i].childNodes[0].nodeValue;
    imag = xmlDoc.getElementsByTagName("image")[i].childNodes[0].nodeValue;
    var btn = document.createElement("BUTTON");
    var t = document.createTextNode("CLICK ME");
    var myArr = new Array();
    myArr[i] = new Array(quantity , pname , date );
    //myArr.push(document.write("<input type='button' value='" + pname + "'/>"));
    alert(myArr );
    alert(myArr[i].length);
    for (j = 0; j < myArr[i].length; j++) {
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(myArr[i][j]));
        tr.appendChild(td);
    }
    tableBody.appendChild(tr);
}
//myTableDiv.appendChild(table);