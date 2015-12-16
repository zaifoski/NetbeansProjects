/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import model.Ordine;

/**
 *
 * @author sofia
 */
public class DBManager {

    public void insert() {
        //... insert into ordine values (?,?) 
        // rs.execute(progressivo,descrizione)
    }

    public void update() {
        //... update into ordine set descrizione = ? where progressivo = ? 
        // rs.execute(descrizione,progressivo)
    }

    static public Ordine load(int d) {
        //...select * from ordine where id = this.d;
        return null;
    }

    static public List<Product> load() {
        //... PreparedStatement stm = con.prepareStatement("SELECT * FROM products");
        return null;
    }

}
