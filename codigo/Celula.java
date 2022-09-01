class Celula {

	private Compromisso item;
	private Celula proximo;
	
	public Celula(Compromisso novo) {
	
  	item = novo;
		proximo = null;
	}
	
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
