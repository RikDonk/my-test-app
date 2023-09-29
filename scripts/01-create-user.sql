-- Drop user first if they exist
DROP USER if exists 'testappuser'@'%' ;

-- Now create user with prop privileges
CREATE USER 'testappuser'@'%' IDENTIFIED BY 'password01';

GRANT ALL PRIVILEGES ON * . * TO 'testappuser'@'%';