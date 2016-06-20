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
     var result = $("#result");
     result.append(
      $("<p>").html('圆的面积是' + circle),
      $("<p>").html('梯形的面积是' + ladder)
      )
  }

  $.post('result.php', params, response_handle);
});