package model;

public class Utente {

    /**
     * Creates a new instance of Utente
     */
    public Utente() {

    }

    private String nome;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    public boolean checkPassword(String password) {

        if ("pass".equals(password)) {
            return true;
        } else {
            return false;
        }

    }

}
