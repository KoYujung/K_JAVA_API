<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    ${name}

</head>
<body>

<h1>${name}</h1>

<hr>
<table >
    <tr>
        <td>id</td>
        <td>
            <input type="text" id="colorId" />
        </td>
        <td>name</td>
        <td>
            <input type="text" id="colorName" />
        </td>
    </tr>
</table>

<hr>
<a onclick="insertColor()" >입력</a>
<script>

$(function(){

});


function insertColor(){
    var color = new Object();

    color.colorId = $("#colorId").val();
    color.colorName = $("#colorName").val();

    $.ajax({
        url : "/insertColor",
        type : 'POST',
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data: JSON.stringify(color),
        success : function(data) {
            alert(data);

        }
    });
}

</script>

</body>
</html>




























