
var request;
if (window.XMLHttpRequest)
{
    request=new XMLHttpRequest();
}
else
{
    request=new ActiveXObject("Microsoft.XMLHTTP");
}
request.open('GET','data.json');
request.send();
request.onreadystatechange = function()
{
    if (request.readyState==4 && request.status==200)
    {
        var items = JSON.parse(request.responseText);
        //alert("Items" +  items.length);

        for(var i in items){
            var output = "<tr>";
            // output += '<td>' + items[i].pcode + '</td>'+ '<td>'+ items[i].pname+'</td>'+'<td>'+items[i].mfgDate+'</td>';
            output += '<td>'+ items[i].pcode +'</td>'+ '<td>' + items[i].pname + '</td>'+ '<td>' + items[i].mfgDate +'</td>';
            output += "</tr>";
            document.getElementById('tb').innerHTML += output;
        }


    }
};
function imgChange(el) {
    if(el.value === "Show Image"){
        el.value = "Hide Image";
        document.getElementById('tb').innerHTML = "";
                var items = JSON.parse(request.responseText);
                //alert("Items" +  items.length);

                for(var i in items){
                    var output = "<tr>";
                    output += '<td>'+ items[i].pcode +'</td>'+ '<td>' + items[i].pname + '</td>'+ '<td>' + items[i].mfgDate +'</td>'+'<td>' +'<img src="'+items[i].image+'" height="100" width="100"/>'+'</td>';
                    output += "</tr>";
                    document.getElementById('tb').innerHTML += output;
                }




    }
    else{
        el.value = 'Show Image';
        document.getElementById('tb').innerHTML = "";

                var items = JSON.parse(request.responseText);
                //alert("Items" +  items.length);

                for(var i in items){
                    var output = "<tr>";
                    // output += '<td>' + items[i].pcode + '</td>'+ '<td>'+ items[i].pname+'</td>'+'<td>'+items[i].mfgDate+'</td>';
                    output += '<td>'+ items[i].pcode +'</td>'+ '<td>' + items[i].pname + '</td>'+ '<td>' + items[i].mfgDate +'</td>';
                    output += "</tr>";
                    document.getElementById('tb').innerHTML += output;
                }



    }
}