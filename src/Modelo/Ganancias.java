
package Modelo;
public class Ganancias {
    private int id;
    private String venta_b_e;
    private double valordeldia;
    private int porcentaje;
    private double ganancias;

    public Ganancias() {
    }

    public Ganancias(int id, String venta_b_e, double valordeldia, int porcentaje, double ganancias) {
        this.id = id;
        this.venta_b_e = venta_b_e;
        this.valordeldia = valordeldia;
        this.porcentaje = porcentaje;
        this.ganancias = ganancias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenta_b_e() {
        return venta_b_e;
    }

    public void setVenta_b_e(String venta_b_e) {
        this.venta_b_e = venta_b_e;
    }

    public double getValordeldia() {
        return valordeldia;
    }

    public void setValordeldia(double valordeldia) {
        this.valordeldia = valordeldia;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }
    
}
