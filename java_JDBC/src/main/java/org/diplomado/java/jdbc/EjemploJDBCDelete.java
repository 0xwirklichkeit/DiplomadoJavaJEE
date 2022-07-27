package org.diplomado.java.jdbc;

import org.diplomado.java.jdbc.modelo.Producto;
import org.diplomado.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.diplomado.java.jdbc.repositorio.Repositorio;
import org.diplomado.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCDelete {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConexionBaseDatos.getConnection()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
            System.out.println("================ listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== obtener por id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("=========== Eliminar producto ==========");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
