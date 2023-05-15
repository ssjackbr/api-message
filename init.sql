CREATE DATABASE message_db;
USE message_db;
CREATE USER 'admin'@'%'
  IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON message_db.* TO 'admin'@'%';
FLUSH PRIVILEGES;