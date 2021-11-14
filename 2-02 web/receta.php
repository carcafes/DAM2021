<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carlos Javier Cosme Melian 2ºDAM A</title>

    <link rel="stylesheet" href="formato.css">
        
</head>

<body>

<?php
if(isset($_GET["ID"])){
    include 'Conexion.php';

/*Query*/
$ID=$_GET["ID"];
$query = "SELECT * FROM t_recetas WHERE ID_receta =".$ID;
 
$stmt = $base->prepare($query);
$stmt->execute();
$recipes = array();

while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
  
      $recipes['Recetas'][] = $row;

 
}
$salida = json_encode($recipes, JSON_UNESCAPED_UNICODE);
echo htmlspecialchars($salida);
}else echo "ID not included in GET";

?>
    

</body>

</html>