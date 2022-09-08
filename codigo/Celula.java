class Celula {

	private Compromisso item;
	private Celula proximo;
	
	/**
	 * Construtor de Celula que recebe um parâmetro do tipo Compromisso
	 * @param novo param do tipo Compromisso
	*/
	public Celula(Compromisso novo) { 
	
  	item = novo;
		proximo = null;
	}
	
	/**
	 * Construtor sem parâmetros: valores default
	*/
	public Celula() {
		
		item = new Compromisso();
		proximo = null;
	}
	
	public Compromisso getItem() {
		return item;
	}
	public void setItem(Compromisso item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
