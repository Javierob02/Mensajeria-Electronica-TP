package com.company;
public class Person extends Contact {
    String telefono;
    String nombre;

    /**
     * Constructor para Persona
     * Inicializa los parametros para una Persona
     * @param nombre nombre de la persona
     * @param telefono número de teléfono de la persona
     */
    public Person(String nombre, String telefono) {
        super(nombre);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Método para pasar a String los datos de una Persona
     * @return lista concatenada de su nombre y número de teléfono separados por ': '
     */
    public String toString() {
        return this.nombre + ": " + this.telefono;
    }

    /**
     * Manda un SMS a el contacto
     * @param mensaje es el SMS a enviar
     * @return nada, es void
     */
    @Override
    public void sendSMS(String mensaje) {
        SMSTools.sendMessage(this.telefono, mensaje);
    }
}

