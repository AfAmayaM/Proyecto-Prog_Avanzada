insert into cuenta (rol, estado, email, contrasenia) values ("Usuario", 0, "tomas@mail.com", "12345");
insert into cuenta (rol, estado, email, contrasenia) values ("Usuario", 0, "didier@mail.com", "54321");
insert into cuenta (rol, estado, email, contrasenia) values ("Usuario", 0, "cristian@mail.com", "98765");
insert into cuenta (rol, estado, email, contrasenia) values ("Usuario", 0, "mateo@mail.com", "56789");
insert into cuenta (rol, estado, email, contrasenia) values ("Usuario", 0, "luisa@mail.com", "01928");
insert into cuenta (rol, estado, email, contrasenia) values ("Moderador", 0, "carlos@mail.com", "97536");

insert into usuario (codigo, nombre, apellido, telefono, direccion) values (1, "Tomas", "Parra", "019283", "Mz 4 Casa 1");
insert into usuario (codigo, nombre, apellido, telefono, direccion) values (2, "Didier", "Arrosero", "9274129", "Mz 4 Casa 2");
insert into usuario (codigo, nombre, apellido, telefono, direccion) values (3, "Cristian", "Gonzales", "1923819", "Mz 4 Casa 3");
insert into usuario (codigo, nombre, apellido, telefono, direccion) values (4, "Mateo", "Baez", "98329472", "Mz 4 Casa 4");
insert into usuario (codigo, nombre, apellido, telefono, direccion) values (5, "Luisa", "Rodriguez", "02834729", "Mz 4 Casa 5");

insert into moderador(codigo, nombre, apellido, telefono) values (6, "Carlos", "Restrepo", "09171623");

insert into producto (nombre, descripcion, precio, unidades_disponibles) values ("Play5", "nuevo", 2000000, 5);
insert into producto (nombre, descripcion, precio, unidades_disponibles) values ("Guayos Nike Mercurial", "Original, garantía directamente con la marca", 450000, 10);
insert into producto (nombre, descripcion, precio, unidades_disponibles) values ("IPhone 14","Nuevo", 4000000, 2);
insert into producto (nombre, descripcion, precio, unidades_disponibles) values ("Camara", "Usado", 150000, 3);
insert into producto (nombre, descripcion, precio, unidades_disponibles) values ("Computador portatil", "Nuevo", 3500000, 1);

insert into producto_categorias (producto_codigo, categorias) values (1, 0);
insert into producto_categorias (producto_codigo, categorias) values (2, 6);
insert into producto_categorias (producto_codigo, categorias) values (3, 0);
insert into producto_categorias (producto_codigo, categorias) values (4, 0);
insert into producto_categorias (producto_codigo, categorias) values (5, 0);

insert into publicacion (estado, descuento, fecha_limite, cuenta_codigo, producto_codigo) values (0, 15, "2023-05-11", 1, 1);
insert into publicacion (estado, descuento, fecha_limite, cuenta_codigo, producto_codigo) values (0, 0, "2023-05-11", 2, 2);
insert into publicacion (estado, descuento, fecha_limite, cuenta_codigo, producto_codigo) values (0, 30, "2023-05-11", 3, 3);
insert into publicacion (estado, descuento, fecha_limite, cuenta_codigo, producto_codigo) values (0, 23, "2023-05-11", 4, 4);
insert into publicacion (estado, descuento, fecha_limite, cuenta_codigo, producto_codigo) values (0, 8, "2023-05-11", 5, 5);

insert into favorito (cuenta_codigo, publicacion_codigo) values (1, 2);
insert into favorito (cuenta_codigo, publicacion_codigo) values (2, 1);
insert into favorito (cuenta_codigo, publicacion_codigo) values (3, 4);
insert into favorito (cuenta_codigo, publicacion_codigo) values (4, 5);
insert into favorito (cuenta_codigo, publicacion_codigo) values (5, 3);

insert into compra (fecha_compra, metodo_pago, total, cuenta_codigo) values ("2023-04-13", 0, 2000000, 2);
insert into compra (fecha_compra, metodo_pago, total, cuenta_codigo) values ("2021-04-15",1, 450000, 1);
insert into compra (fecha_compra, metodo_pago, total, cuenta_codigo) values ("2023-04-20", 2, 4000000, 4);
insert into compra (fecha_compra, metodo_pago, total, cuenta_codigo) values ("2023-04-25",1,150000, 5);
insert into compra (fecha_compra, metodo_pago, total, cuenta_codigo) values ("2023-04-30",0, 3500000, 3);

insert into detalle_compra (unidades, precio_unidad, compra_codigo, publicacion_codigo) values (1, 2000000, 1, 1);
insert into detalle_compra (unidades, precio_unidad, compra_codigo, publicacion_codigo) values (1, 450000, 2, 2);
insert into detalle_compra (unidades, precio_unidad, compra_codigo, publicacion_codigo) values (1, 4000000, 3, 3);
insert into detalle_compra (unidades, precio_unidad, compra_codigo, publicacion_codigo) values (1, 150000, 4, 4);
insert into detalle_compra (unidades, precio_unidad, compra_codigo, publicacion_codigo) values (1, 3500000, 5, 5);

insert into comentario (comentario, fecha_comentario, publicacion_codigo, usuario_codigo) values ("Buen producto", "2023-04-15",1,2);
insert into comentario (comentario, fecha_comentario, publicacion_codigo, usuario_codigo) values ("Buena calidad", "2023-04-13",2,1);
insert into comentario (comentario, fecha_comentario, publicacion_codigo, usuario_codigo) values ("Perfecto", "2023-04-30",3,4);
insert into comentario (comentario, fecha_comentario, publicacion_codigo, usuario_codigo) values ("Buen precio", "2023-04-16", 4, 5);
insert into comentario (comentario, fecha_comentario, publicacion_codigo, usuario_codigo) values ("Es justo lo que esperaba", "2023-04-20", 5, 3);

insert into visita (cuenta_codigo, publicacion_codigo) values (1, 2);
insert into visita (cuenta_codigo, publicacion_codigo) values (2, 2);
insert into visita (cuenta_codigo, publicacion_codigo) values (3, 1);
insert into visita (cuenta_codigo, publicacion_codigo) values (4, 3);
insert into visita (cuenta_codigo, publicacion_codigo) values (5, 2);