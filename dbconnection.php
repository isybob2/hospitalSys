<?php 
// DB credentials.
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','damsmsdb');
// Establish database connection.

$database= new mysqli($host,$username,$password,$db_name);

  if ($database->connect_error){
        die("Connection failed:  ".$database->connect_error);
    }

?>
