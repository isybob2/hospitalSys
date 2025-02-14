# php_secure_login_system
php secure login system with mysql and sha1 encryption with salt


## Create Database

```sql

CREATE DATABASE admin_db;

```
## Create Table

```sql

CREATE TABLE `super_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `usertype` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

```
## sha1 encryption with salt
```php
$email = $_POST['email'];

$salt = "Jfdjdjfm74774hfbd7f8";

$password = $_POST['password'].$salt;

$password = sha1($password);
```

## sha1 encryption with salt
<img src="https://user-images.githubusercontent.com/60460387/87409189-3f176500-c5e2-11ea-9a88-70aad2ae3c81.JPG">
