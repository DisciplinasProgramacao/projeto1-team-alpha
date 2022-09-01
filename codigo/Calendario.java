public class Calendario {

private Celula primeiro;
private Celula ultimo;
private int tamanho;

public Calendario() {
    
    Celula sentinela = new Celula();
    
    primeiro = sentinela;
    ultimo = sentinela;
    tamanho = 0;
}

public boolean listaVazia() {
    
    boolean resp;
    
    if (primeiro == ultimo)
        resp = true;
    else
        resp = false;
    
    return resp;
}

public void inserir(Compromisso novo) {
    
    
	
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
				if(novo.data.eMenor(anterior.item.data) ) {
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
        
        
   

public Compromisso remover(String removido) throws Exception {
    
    Celula anterior, celulaRemovida, proximaCelula;
    
    if (! listaVazia()) {
        
            anterior = primeiro;
            while(!anterior.getProximo().item.getNome().equals(removido))
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

public void imprimir() throws Exception {
    
    Celula aux;
    
    if (! listaVazia()) {
        System.out.println("Conteúdo da lista:");
        
        aux = primeiro.getProximo();
        while (aux != null) {
            aux.getItem().imprimir();
            aux = aux.getProximo();
        }
    } else
        throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
}
}
