create table usuario (id_usuario integer primary key
                  auto_increment,
                nombre varchar(80),
                apellidop varchar(80),
                apellidom varchar(80),
                rol varchar(20));

create table nomina (id_nomina integer primary key auto_increment, id_usuario integer, sueldo float,
                           saldo  float,
                           foreign key (id_usuario) references  
                            usuario (id_usuario));

create table cuenta (
id_cuenta integer primary key auto_increment,
id_usuario integer,
total_venta float, 
foreign key (id_usuario) references
usuario (id_usuario));

