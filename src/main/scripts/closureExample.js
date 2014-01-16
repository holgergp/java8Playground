var greeting = "Hallo";
$(document).ready(function () {
    $("#myDiv").click(
        {param1: "Holger"},

        function (event) {
             alert(greeting + " " + event.data.param1);
        }
    );
});