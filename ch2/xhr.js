$("#submit").on('click', function() {
  var r = $("#r").val();
  var a = $("#a").val();
  var b = $("#b").val();
  var h = $("#h").val();
  var params = {
    r : r,
    a : a,
    b : b,
    h : h,
  };
  console.log(params);

  var response_handle = function (data, status) {
    var circle = data.circle;
    var ladder = data.ladder;
    var result = $("#return");
    result.text("");
    result.append("<p>圆的面积是：" + circle + "</p>");
    result.append("<p>梯形的面积是：" + ladder + "</p>");
  }

  $.post('result.php', params, response_handle, 'json');
});