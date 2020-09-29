package Modelo;
public class Envios {
    private int id;
    private String desde;
    private String hacia;
    private String fecha_actual;
    private String remitente;
    private String dni_rem;
    private String celular_rem;
    private String ruc_rem;
    private String beneficiario;
    private String dni_bene;
    private String celular_bene;
    private String direccion_bene;
    private String correo;
    private int cant_enc;
    private String contenido;
    private Double precio_unit;
    private Double importe;
    private String clave;

    public Envios() {
    }

    public Envios(int id, String desde, String hacia, String fecha_actual, String remitente, String dni_rem, String celular_rem, String ruc_rem, String beneficiario, String dni_bene, String celular_bene, String direccion_bene, String correo, int cant_enc, String contenido, Double precio_unit, Double importe, String clave) {
        this.id = id;
        this.desde = desde;
        this.hacia = hacia;
        this.fecha_actual = fecha_actual;
        this.remitente = remitente;
        this.dni_rem = dni_rem;
        this.celular_rem = celular_rem;
        this.ruc_rem = ruc_rem;
        this.beneficiario = beneficiario;
        this.dni_bene = dni_bene;
        this.celular_bene = celular_bene;
        this.direccion_bene = direccion_bene;
        this.correo = correo;
        this.cant_enc = cant_enc;
        this.contenido = contenido;
        this.precio_unit = precio_unit;
        this.importe = importe;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHacia() {
        return hacia;
    }

    public void setHacia(String hacia) {
        this.hacia = hacia;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDni_rem() {
        return dni_rem;
    }

    public void setDni_rem(String dni_rem) {
        this.dni_rem = dni_rem;
    }

    public String getCelular_rem() {
        return celular_rem;
    }

    public void setCelular_rem(String celular_rem) {
        this.celular_rem = celular_rem;
    }

    public String getRuc_rem() {
        return ruc_rem;
    }

    public void setRuc_rem(String ruc_rem) {
        this.ruc_rem = ruc_rem;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getDni_bene() {
        return dni_bene;
    }

    public void setDni_bene(String dni_bene) {
        this.dni_bene = dni_bene;
    }

    public String getCelular_bene() {
        return celular_bene;
    }

    public void setCelular_bene(String celular_bene) {
        this.celular_bene = celular_bene;
    }

    public String getDireccion_bene() {
        return direccion_bene;
    }

    public void setDireccion_bene(String direccion_bene) {
        this.direccion_bene = direccion_bene;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCant_enc() {
        return cant_enc;
    }

    public void setCant_enc(int cant_enc) {
        this.cant_enc = cant_enc;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Double getPrecio_unit() {
        return precio_unit;
    }

    public void setPrecio_unit(Double precio_unit) {
        this.precio_unit = precio_unit;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

   
}
