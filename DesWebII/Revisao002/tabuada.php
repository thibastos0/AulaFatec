<?php
$num = $_POST["numero"] ?? 0;

for ($i=1; $i <= 10 ; $i++) {
    echo "$i X $num = " .$i*$num .". <br>";
}