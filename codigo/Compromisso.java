public class Compromisso {
    private String nome;
    private Data data;
    private int repete;

    /**
     * Construtor de Compromisso que recebe os valores de nome, a data e a quantidade de repetições desejadas.
     * @param nome param do tipo String
     * @param dia param do tipo inteiro
     * @param mes param do tipo inteiro
     * @param ano param do tipo inteiro
     * @param repete param do tipo inteiro
     */
    public Compromisso(String nome, int dia, int mes, int ano, int repete) {
        this.nome = nome;
        this.data = new Data(dia, mes, ano);
        this.repete = repete;
    }

    /**
     * Contrutor de Compromisso que recebe os valores de nome e a data, sem o parametro de repetição.
     * @param nome param do tipo String
     * @param dia param do tipo inteiro
     * @param mes param do tipo inteiro
     * @param ano param do tipo inteiro
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
    
    /**
     * Método que clona um objeto compromisso
     * @return Objeto Compromisso clonado
     */
    public Compromisso copia(){
        Compromisso clone = new Compromisso(this.getNome(), this.getData().getDia(), this.getData().getMes(), this.getData().getAno());
        return clone;
    
    }
    
    /**
     * Método que imprime o compromisso e sua data
     */
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
