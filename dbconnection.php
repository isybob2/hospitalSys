<?php 
// DB credentials.
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','damsmsdb');
// Establish database connection.

try
{
$database= new mysqli($host,$username,$password,$db_name);
 }
catch (PDOException $e)
{
exit("Error: " . $e->getMessage());
}
?>
