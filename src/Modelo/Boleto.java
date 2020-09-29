package Modelo;
public class Boleto {
    private int id;
    private String recibo;
    private String nombre_razonsocial;
    private String ruc;
    private String pasajero;
    private int asiento;
    private String origen;
    private String destino;
    private String fecha_expedicion;
    private String fecha_viaje;
    private String hora_partida;
    private String dni;
    private double valor_venta;
    private double precio_total;
    private String celular;
    private String correo;
    private String son;
    private String status;

    public Boleto() {
    }

    public Boleto(int id, String recibo, String nombre_razonsocial, String ruc, String pasajero, int asiento, String origen, String destino, String fecha_expedicion, String fecha_viaje, String hora_partida, String dni, double valor_venta, double precio_total, String celular, String correo, String son, String status) {
        this.id = id;
        this.recibo = recibo;
        this.nombre_razonsocial = nombre_razonsocial;
        this.ruc = ruc;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.origen = origen;
        this.destino = destino;
        this.fecha_expedicion = fecha_expedicion;
        this.fecha_viaje = fecha_viaje;
        this.hora_partida = hora_partida;
        this.dni = dni;
        this.valor_venta = valor_venta;
        this.precio_total = precio_total;
        this.celular = celular;
        this.correo = correo;
        this.son = son;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getNombre_razonsocial() {
        return nombre_razonsocial;
    }

    public void setNombre_razonsocial(String nombre_razonsocial) {
        this.nombre_razonsocial = nombre_razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(String fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    public String getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(String fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public String getHora_partida() {
        return hora_partida;
    }

    public void setHora_partida(String hora_partida) {
        this.hora_partida = hora_partida;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
