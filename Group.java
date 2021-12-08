package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Group extends Contact {
    String nombre_grupo;
    String to_string;
    List<Contact> lista = new ArrayList<>();
    List<Contact> lista_d = new ArrayList<>();

    /**
     * Constructor de Group
     * Inicializa los parametros para describir un Grupo
     * @param nombre_grupo el nombre del grupo
     */
    public Group(String nombre_grupo) {
        super(nombre_grupo);
        this.nombre_grupo = nombre_grupo;
    }

    /**
     * Envia un SMS al contacto
     * @param mensaje es el SMS a enviar
     * @return nada, es void
     */
    @Override
    public void sendSMS(String mensaje) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getClass() == Person.class) {
                this.lista.get(i).sendSMS(mensaje);
            } else {
                Group contacto = (Group)this.lista.get(i);
                contacto.sendSMS(mensaje);
            }
        }
    }

    /**
     * Devuelve 'true' si está en el grupo y 'false' si no lo está
     * @param id el número identificativo del contacto
     * @return boolean, true o false
     */
    public boolean isMember(int id) {
        for(int i = 0; i< this.lista.size(); i++ ){
            if(this.lista.get(i) instanceof Group ){
                Group ContactGroup = (Group)this.lista.get(i);
                if(ContactGroup.isMember(id)){
                    return true;
                }
            }
            if(this.lista.get(i).getId() == id){
                return true;
            }

        }

        return false;
    }

    /**
     * Devuelve 'true' si no existía y se ha añadido y 'false' si ya es miembro o es el propio grupo
     * @param o es un contacto
     * @return boolean, true or false
     */
    public boolean add(Contact o) {
        if(this.isMember(o.getId()) || o.getId() == this.getId()){
            return false;
        }

        this.lista.add(o);
        return true;
    }

    /**
     * Devuelve 'true' si estaba en grupo y se eliminó y 'false' si no estaba en grupo
     * @param id el número identificativo de el contacto
     * @return boolean, true or false
     */
    public boolean remove(int id) {
        for(int i = 0; i< this.lista.size(); i++ ){
            if(this.lista.get(i).getId() == id){
                this.lista.remove(this.lista.get(i));
                return true ;
            }
        }
        return false;
    }

    /**
     * Devuelve una lista de contactos directos ordenada por 'id'.
     * No modifica la lista original
     * @return lista de contactos
     */
    public List<Contact> getContacts() {
        for(int i = 0; i < this.lista.size(); i++) {
            this.lista_d.add(this.lista.get(i));
        }

        this.lista_d.sort(Comparator.comparing(Contact::getId));
        return this.lista_d;
    }

    /**
     * Devuelve una String con nombre del grupo seguido de "\n" y una concatenación de los contactos directos separados por "\n"
     * @return String con todos los contactos y nombre del grupo
     */
    public String toString() {
        for(int i = this.lista.size()-1; i>=0; i-- ){
            this.lista_d.add((Contact)this.lista.get(i));
        }
        Collections.sort(lista_d, new Comparator<Contact>() {
            public int compare(Contact contact_1, Contact contact_2){
                return contact_1.getName().compareTo(contact_2.getName());
            }

        });
        if(this.lista.size()==0){
            this.to_string = this.nombre_grupo;
        } else {
            this.to_string = this.nombre_grupo + "\n";
        }
        for (int i = 0; i<this.lista.size(); i++ ){
            if(this.lista_d.get(i) instanceof Person){
                this.to_string+=""+this.lista_d.get(i)+"\n";
            }else{
                this.to_string+=""+(Group)this.lista_d.get(i)+"\n";
            }
        }

        return this.to_string;
    }
}