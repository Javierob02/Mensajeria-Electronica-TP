package com.company;

public abstract class Contact {
    String nombre;
    int id;

    /**
     * Constructor Contact
     * inicializa los parametros para un contacto
     * @param nombre nombre del contacto
     * @return nada
     */
    public Contact(String nombre) {
        this.nombre = nombre;
        this.id = SMSTools.getUniqueId();
    }

    /**
     * Devuelve el número identificatorio del contacto
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve el nombre del contacto
     * @return nombre
     */
    public String getName() {
        return this.nombre;
    }

    /**
     * Método abstracto sendSMS, envía un SMS
     * @param mensaje es el SMS a enviar
     * @return nada
     */
    abstract public void sendSMS(String mensaje);
}
