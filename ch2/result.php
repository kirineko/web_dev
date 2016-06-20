<?php

$r = $_POST['r'];

$a = $_POST['a'];
$b = $_POST['b'];
$h = $_POST['h'];

function getArea1($r)
{
    return M_PI * $r * $r;
}

function getArea2($a, $b, $h)
{
    return ($a + $b) * $h / 2;
}

$circle = round(getArea1($r), 2);
$ladder = getArea2($a,$b,$h);

echo "<p><font color=blue size=4>圆的半径是:{$r}<br>面积是:{ $circle }</font></p>";

echo "<p><font color=blue size=4>梯形的上底是:{$a}, 下底是:{$b}, 高是:{$h}<br>面积是:{ $ladder }</font></p>";