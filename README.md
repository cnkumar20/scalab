tex# scalab

*Setup mysql environment on docker to use database on a persistent volume*

*$ docker volume create mysql-data*
 
*docker run --name nandy-mysql -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=mypasswd -d mysql:latest*

*docker run --name nandy-mysql-v3 \
 -v /Users/nchandregowda/DPL/scalab/mysql-db:/var/lib/mysql \
 -e MYSQL_ROOT_PASSWORD=Nadal@123 -d mysql:latest *
 
 
## Accessing the library

*How to access the code*

## Documentation

*A link to the documentation*

## How to contribute

*How others can contribute to the project*