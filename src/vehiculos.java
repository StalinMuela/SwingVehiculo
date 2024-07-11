public class vehiculos {
    String placa;
    String marca;
    Double cilindraje;
    String tipo_combustible;
    String color;
    String propietario;

    public vehiculos() {
    }

    public vehiculos(String placa, String marca, Double cilindraje, String tipo_combustible, String color, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.tipo_combustible = tipo_combustible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
