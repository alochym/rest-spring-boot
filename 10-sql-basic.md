# SQL Basic

- Using PostgreSQL version 14 as primary Database.
- [CONSTRAINTS](https://www.postgresql.org/docs/14/ddl-constraints.html).
- [PRIMARY KEY](https://www.postgresql.org/docs/14/ddl-constraints.html#DDL-CONSTRAINTS-PRIMARY-KEYS).
- [FOREIGN KEY](https://www.postgresql.org/docs/14/ddl-constraints.html#DDL-CONSTRAINTS-FK).
- SQL cheatsheet:
  - <https://github.com/AdityaMisra/postgresql_cheat_sheet>.
  - <https://github.com/SathvikJoel/PostgreSQL-Cheat-Sheet>.
  - <https://github.com/bmuthoga/PostgreSQL-Cheat-Sheet>.

## Admin GUI

- [pqAdmin software](https://www.pgadmin.org/download/pgadmin-4-windows/).

## Create User

- [Command line](https://www.postgresql.org/docs/14/sql-createuser.html) - `create user hoanle13 with password 'hoanle13@abc.com'`.

## Create Database

- [Command line](https://www.postgresql.org/docs/14/manage-ag-createdb.html) - `create database sample`.

## Grant Permission

- `GRANT CONNECT ON DATABASE sample TO hoanle13;`.
- `GRANT pg_read_all_data TO my_user;`.
- `GRANT pg_write_all_data TO my_user;`.
- [Command line](https://www.postgresql.org/docs/14/sql-grant.html) - `GRANT ALL PRIVILEGES ON sample.users TO hoanle13;`.

## Create Table

- [Command line](https://www.postgresql.org/docs/14/sql-createtable.html).

  ```sql
  create table users (
    id serial PRIMARY KEY,
    username VARCHAR ( 50 ) UNIQUE NOT NULL,
    password VARCHAR ( 50 ) NOT NULL,
    email VARCHAR ( 255 ) UNIQUE NOT NULL,
  );
  ```

## SQL Command

### SELECT

- [Reference link](https://www.postgresql.org/docs/14/sql-select.html).
- `SELECT id, username, password, email from users`.
- `SELECT id, username, password, email from users where id=1`.
- [JOIN TABLES](https://www.postgresql.org/docs/14/tutorial-join.html).
- [LIMIT AND OFFSET](https://www.postgresql.org/docs/14/queries-limit.html).

### INSERT

- [Reference link](https://www.postgresql.org/docs/14/sql-insert.html).
- `INSERT INTO users (id, username, password, email) VALUES (1, 'hoanle', 'password', 'hoanle13@gmail.com');`

### UPDATE

- [Reference link](https://www.postgresql.org/docs/14/sql-update.html).
- `UPDATE users SET email = 'hoanle@gmail.com' WHERE id = 1;`

### DELETE

- [Reference link](https://www.postgresql.org/docs/14/sql-delete.html).

#### Clear Table

- `DELETE FROM users;`

#### Delete Record

- `DELETE FROM users WHERE id = 1;`

#### Delete Database

- `DROP database sample`.

#### Delete Table

- `DROP table users`.
