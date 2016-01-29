insert into Usuarios(usuario_id,nombre,apepat,apemat,username,password,estado) values(1,'RICARDO','TOLEDO','BARRIA','rtoledo','12345','ACTIVO');
insert into Usuarios(usuario_id,nombre,apepat,apemat,username,password,estado) values(2,'SEBASTIAN','TOLEDO','BARRIA','stoledo','1234','ACTIVO');
insert into Usuarios(usuario_id,nombre,apepat,apemat,username,password,estado) values(3,'BRIAN','ROMERO','ROJAS','bromero','123','ACTIVO');

insert into Roles(rol_id,tipo) values(1,'administrador');
insert into Roles(rol_id,tipo) values(2,'ejecutivo');

insert into Usuarios_Roles(usuario_id,rol_id) values(1,1);
insert into Usuarios_Roles(usuario_id,rol_id) values(2,1);
insert into Usuarios_Roles(usuario_id,rol_id) values(3,2);
drop view v_user_role;
create VIEW v_user_role AS select u.username,u.password,g.tipo FROM Usuarios_Roles ug INNER JOIN Usuarios u ON u.usuario_id = ug.usuario_id INNER JOIN Roles g ON g.rol_id = ug.rol_id; 