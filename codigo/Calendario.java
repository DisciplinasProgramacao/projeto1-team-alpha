public class Calendario {

private Celula primeiro;
private Celula ultimo;
private int tamanho;

	/**
	 * Construtor sem parâmetros que inicializa as variáveis apontando o primeiro e o ultimo item da lista para a sentinela
	 */
	public Calendario() {
	    
	    Celula sentinela = new Celula();
	    
	    primeiro = sentinela;
	    ultimo = sentinela;
	    tamanho = 0;
	}
	
	/**
	 * Método booleano que verifica se o calendário está vazio
	 * @return True caso esteja vazio e false caso não esteja
	 */
	public boolean calendarioVazio() {
	    
	    boolean resp;
	    
	    if (primeiro == ultimo)
	        resp = true;
	    else
	        resp = false;
	    
	    return resp;
	}
	
	
	/**
	 * Método que recebe um compromisso para adicioná-lo no calendário
	 * @param novo parâmetro do tipo Compromisso
	 */
	public void adicionarCompromisso(Compromisso novo) {

		Celula anterior, novaCelula, proximaCelula;

			anterior = primeiro;
			
			if(anterior.getProximo() == null ) {
				int posicao = 0;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();
					
				novaCelula = new Celula(novo);
				
				proximaCelula = anterior.getProximo();
				
				anterior.setProximo(novaCelula);
				novaCelula.setProximo(proximaCelula);
				
				
				if (posicao == tamanho)  // a inserção ocorreu na última posição da lista
					ultimo = novaCelula;
				tamanho++;
			}else {
				
				int posicao =0;
				int controle=0;
				while(controle ==0) {
					if(novo.getData().eMenor(anterior.getItem().getData()) ) {
						controle = 1;
						
					}else {
						if(anterior.getProximo() == null) {
							controle=1;
							posicao++;
						}else {
							anterior = anterior.getProximo();
							posicao++;}
						
					}
				}
				
					anterior = primeiro;
					for (int i = 1; i < posicao-1; i++)
					anterior = anterior.getProximo();
					
				novaCelula = new Celula(novo);
				
				proximaCelula = anterior.getProximo();
				
				anterior.setProximo(novaCelula);
				novaCelula.setProximo(proximaCelula);
				tamanho++;
			}
		}
	        
	/**
	 * Método que adiciona um compromisso com repetições. Recebe como parâmetro 
	 * @param novo param do tipo Compromisso
	 * @param repeticao param do tipo inteiro
	 */
	public void adicionarCompromissoRepetido(Compromisso novo, int intervalo){
		Compromisso clone = novo.copia();
		for(int l=0; l<novo.getRepete() ; l++){
			this.adicionarCompromisso(clone);
			clone = clone.copia();
			clone.getData().adicionaDias(intervalo);
		}

	}
	
	/**
	 * Método que recebe o nome de um compromisso por parâmetro e remove ele do calendário
	 * @param removido parâmetro do tipo String com o nome do compromisso
	 * @return retorna objeto compromisso removido
	 * @throws Exception caso o compromisso não seja encontrado, é impresso uma mesagem de erro
	 */
	public Compromisso removerCompromisso(String removido) throws Exception {
	    
	    Celula anterior, celulaRemovida, proximaCelula;
	    
	    if (! calendarioVazio()) {
	        
	            anterior = primeiro;
	            while(!anterior.getProximo().getItem().getNome().equals(removido))
	                anterior = anterior.getProximo();
	            
	            celulaRemovida = anterior.getProximo();
	            
	            proximaCelula = celulaRemovida.getProximo();
	            
	            anterior.setProximo(proximaCelula);
	            celulaRemovida.setProximo(null);
	            
	            if (celulaRemovida == ultimo)
	                ultimo = anterior;
	            
	            tamanho--;
	            
	            return (celulaRemovida.getItem());	
	        } else
	            throw new Exception("Não foi possível remover o item da lista: a posição informada é inválida!");
	} 

	
	/**
	 * Método que mostra todos os compromissos criados do calendário
	 */
	public void mostrarTodosCompromissos(){
	    
    Celula aux;
    
	    if (! calendarioVazio()) {
	        
	        aux = primeiro.getProximo();
	        while (aux != null) {
	            aux.getItem().imprimir();
	            aux = aux.getProximo();
	        }
	    }
	}
	
	/**
	 * Método que imprime os compromissos marcados entre os datas parametrizadas. 
	 * @param dataInicial parâmetro do tipo Data com dia, mês e ano
	 * @param dataFinal parâmetro do tipo Data com dia, mês e ano
	 */
	public void mostrarCompromissosIntervalo(Data dataInicial, Data dataFinal){
	    
	    Celula aux;
	    
	    if (! calendarioVazio()) {
	        
	        aux = primeiro.getProximo();
	        while (aux != null) {
	        	if(aux.getItem().getData().eMenor(dataFinal)) {
	        		if((dataInicial.eMenor(aux.getItem().getData())))
			            aux.getItem().imprimir();
			            
	        	}
				aux = aux.getProximo(); 
	        }
	    }
	}
}
