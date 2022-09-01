public class App {

	public static void main(String[] args) {
		Calendario calendario = new Calendario();
		Compromisso compromisso1 = new Compromisso("Futebol",1,9,2022,0);
		Compromisso compromisso2 = new Compromisso("Basquete",10,10,2022,0);
		Compromisso compromisso3 = new Compromisso("Volêi",2,10,2022,0);
		Compromisso compromisso4 = new Compromisso("Tênis",1,9,2022,0);
		Compromisso compromisso5 = new Compromisso("Taekwondo",5,9,2022,0);
		Compromisso compromisso6 = new Compromisso("Ginastica",15,2,2022,0);
		calendario.adicionarCompromisso(compromisso1);
		calendario.adicionarCompromisso(compromisso2);
		calendario.adicionarCompromisso(compromisso3);
		calendario.adicionarCompromisso(compromisso4);
		calendario.adicionarCompromisso(compromisso5);
		calendario.adicionarCompromisso(compromisso6);
		Data dataInicial = new Data(14,2,2022);
		Data dataFinal = new Data(9,10,2022);
		calendario.mostrarCompromissosIntervalo(dataInicial, dataFinal);

	}

}
