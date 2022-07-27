package org.diplomado.java.jdbc;

import org.diplomado.java.jdbc.modelo.Categoria;
import org.diplomado.java.jdbc.modelo.Producto;
import org.diplomado.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.diplomado.java.jdbc.repositorio.Repositorio;
import org.diplomado.java.jdbc.servicio.CatalogoServicio;
import org.diplomado.java.jdbc.servicio.Servicio;
import org.diplomado.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCUpdate {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("================ listar =============");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Ferretería");

        Producto producto = new Producto();
        producto.setNombre("Destornillador ");
        producto.setPrecio(90);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefg123");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con éxito" + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}
