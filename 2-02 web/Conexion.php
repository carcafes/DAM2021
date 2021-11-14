<?php

try{
    $base = new PDO ('mysql:host=localhost; dbname=db_comidapp;charset=utf8mb4','usuarios', 'usuarios');

    $base->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $base->exec("SET CHARACTER SET UTF8mb4");


}catch (Exception $e) {
    die('Error' . $e->getMessage());
    echo "Línea del error" . $e->getLine();
}
?>