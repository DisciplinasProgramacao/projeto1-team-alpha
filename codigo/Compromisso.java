public class Compromisso {
    private String nome;
    private Data data;
    private int repete;

    /**
     * Construtor de Compromisso com todos parametros.
     * 
     * @param nome
     * @param dia
     * @param mes
     * @param ano
     * @param repete
     */
    public Compromisso(String nome, int dia, int mes, int ano, int repete) {
        this.nome = nome;
        this.data = new Data(dia, mes, ano);
        this.repete = repete;
    }

    /**
     * Contrutor de Compromisso sem o parametro de repeticao.
     * 
     * @param nome
     * @param dia
     * @param mes
     * @param ano
     */
    public Compromisso(String nome, int dia, int mes, int ano) {
        this.nome = nome;
        this.data = new Data(dia, mes, ano);
        this.repete = 0;
    }

    /**
     * Contrutor sem parametros. Atributos default.
     */
    public Compromisso() {
        this.nome = "Novo Compromisso";
        this.data = new Data();
        this.repete = 0;

    }
    public Compromisso copia(){
        Compromisso clone = new Compromisso(this.getNome(), this.getData().getDia(), this.getData().getMes(), this.getData().getAno());
        return clone;
    
    }
    public void imprimir() {
    	System.out.println(this.nome + " - "+data.dataFormatada());
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRepete() {
        return repete;
    }

    public void setRepete(int repete) {
        this.repete = repete;
    }
}
