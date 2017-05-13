package prova1;

public class App {
	
	static ArvoreBinBusca<Cpf, Comprador> compradores = new ArvoreBinBusca<Cpf, Comprador>();
	static ArvoreBinBusca<NumChass, Automovel> autoVenda = new ArvoreBinBusca<NumChass, Automovel>();
	static ArvoreBinBusca<NumChass, Automovel> autoVendidos = new ArvoreBinBusca<NumChass, Automovel>();
	static ArvoreBinBusca<NumChass, Motocicleta> motoVenda = new ArvoreBinBusca<NumChass, Motocicleta>();
	static ArvoreBinBusca<NumChass, Motocicleta> motoVendidas = new ArvoreBinBusca<NumChass, Motocicleta>();
	static ArvoreBinBusca<NumChass, Produto> produtosComprador = new ArvoreBinBusca<NumChass, Produto>();

	
	public static void main(String[] args) {
		int opcao;
		do {
			Keyboard.clrscr();
			opcao = Keyboard.menu("Cadastrar Motocicleta/Cadastrar Automóvel/Cadastrar Comprador/"
					+ "Vender Motocicleta/Vender Automóvel/Consultar Chassis Veículo/Consultar Cpf Comprador/"
					+ "Listar Motocicleta a venda/Listar motocicletas vendidas/Listar automóveis a venda/Listar automóveis vendidos");

			switch (opcao) {
			case 1:
				cadMoto();
				break;
			case 2:
				cadVeiculo();
				break;
			case 3:
				cadComprador();
				break;
			case 4:
				vendeMoto();
				break;
			case 5:
				vendeVeiculo();
				break;
			case 6:
				consultaChassis();
				break;
			case 7:
				consultaCpf();
				break;
			case 8:
				listaMotoVenda();
				break;
			case 9:
				listaMotoVendido();
				break;
			case 10:
				listaAutoVenda();
				break;
			case 11:
				listaAutoVendido();
				break;

			}
		} while (opcao < 12);
		System.out.println("\nFim do programa");

	}

	private static void listaAutoVendido() {
		if (autoVendidos.getValue() != null) {
			System.out.println(autoVendidos.getValue());
		} else {
			System.out.println("não há automoveis vendidos!");
		}
		System.out.println("\n\n\n");
		
	}

	private static void listaAutoVenda() {
		// TODO Auto-generated method stub
		
	}

	private static void listaMotoVendido() {
		if (motoVendidas.getValue() != null) {
			System.out.println(motoVendidas.getValue());
		} else {
			System.out.println("não há motocicletas vendidas!");
		}
		System.out.println("\n\n\n");
	}

	private static void listaMotoVenda() {
		char resp = 0;
		do {
			Keyboard.clrscr();
			
			resp = Keyboard.readChar("vender outra motocicleta? (s/n): ");
		} while (resp =='s');
	}

	
	private static void consultaCpf() {
		char resp = 0;
		do {
			Keyboard.clrscr();
			String cpfComp = Keyboard.readString("Informe o Cpf do comprador:  ");
			Cpf cpf = new Cpf(cpfComp);
			if (produtosComprador != null) {
				System.out.println();
				
			}
			
			
			resp = Keyboard.readChar("vender outra motocicleta? (s/n): ");
		} while (resp =='s');
		
	}

	private static void consultaChassis() {
		char resp = 0;
		do {
			Keyboard.clrscr();
			
			resp = Keyboard.readChar("vender outra motocicleta? (s/n): ");
		} while (resp =='s');
		
	}

	private static void vendeVeiculo() {
		char resp = 0;
		do{
			Keyboard.clrscr();
			String cpfComp = Keyboard.readString("Informe o Cpf do comprador:  ");
			Cpf cpf = new Cpf(cpfComp);
			Comprador comp = compradores.getNode(cpf).getValue();
			String nrChassis = Keyboard.readString("Informe o número do Chassis:  ");
			NumChass numChass = new NumChass(nrChassis);
			if (autoVenda.getValue().equals(numChass)) {
				Automovel auto  = autoVenda.getNode(numChass).getValue();
				auto.setComp(comp);
				autoVendidos.insert(numChass, auto);
				autoVenda.remove(numChass);
			}else 
				System.out.println("Veículo não encontrado!");
			
			resp = Keyboard.readChar("Vender outro automóvel? (s/n): ");
		}while (resp =='s');
	}

	private static void vendeMoto() {
		char resp;
		do{
			Keyboard.clrscr();
			String cpfComp = Keyboard.readString("Informe o Cpf do comprador:  ");
			Cpf cpf = new Cpf(cpfComp);
			Comprador comp = compradores.getNode(cpf).getValue();
			String nrChassis = Keyboard.readString("Informe o número do Chassis:  ");
			NumChass numChass = new NumChass(nrChassis);
			if (motoVenda.getValue().equals(numChass)) {
				Motocicleta moto  = motoVenda.getNode(numChass).getValue();
				moto.setComp(comp);
				motoVendidas.insert(numChass, moto);
				motoVenda.remove(numChass);
			}else 
				System.out.println("Motocicleta não encontrada!");
		
			resp = Keyboard.readChar("vender outra motocicleta? (s/n): ");
		}while (resp =='s');
	}

	private static void cadComprador() {
		char resp;
		do{
			Keyboard.clrscr();
			String cpfComp = Keyboard.readString("Informe o Cpf do comprador:  ");
			Cpf cpf = new Cpf(cpfComp);
			String nmComp = Keyboard.readString("Informe o nome do comprador: ");
			Comprador comprador = new Comprador();
			comprador.setCpf(cpf);
			comprador.setNome(nmComp);
			if (compradores.getNode(cpf)!=null) {
				System.err.println("Aluno já cadastrado.");
			} else
				compradores.insert(cpf, comprador);
			
			resp = Keyboard.readChar("cadastrar outro comprador? (s/n): ");
			}while (resp =='s');
		
	}

	private static void cadVeiculo() {
		char resp;
		do {
			Keyboard.clrscr();
			Automovel auto = new Automovel();
			String nrChassis = Keyboard.readString("Informe o número do Chassis:  ");
			NumChass numChass = new NumChass(nrChassis);
			auto.setNumChass(numChass);
			String nmAuto = Keyboard.readString("Informe o nome do Veículo: ");
			auto.setNome(nmAuto);
			int ano = prova1.Keyboard.readInt("Informe o ano de fabricação: ");
			auto.setAnoFab(ano);
			int categ = Keyboard.readInt("Digite a categoria: 1-Hatch; 2-Sedan; 3-SUV");
			Categoria categoria;
			if (categ == 1) {
				categoria = Categoria.Hatch;
			} else if (categ == 2) {
				categoria = Categoria.Sedan;
			} else {
				categoria = Categoria.SUV;
			}
			auto.setCateg(categoria);
			
			if (autoVenda.getNode(numChass) != null) {
				System.err.println("Automóvel já cadastrado.");
			} else
				autoVenda.insert(numChass, auto);
			
		resp = Keyboard.readChar("cadastrar outro automóvel? (s/n): ");
		} while (resp == 's');

	}

	private static void cadMoto() {
		char resp;
		do {
			Keyboard.clrscr();
			Motocicleta moto = new Motocicleta();
			String nrChassis = Keyboard.readString("Informe o número do Chassis:  ");
			NumChass numChass = new NumChass(nrChassis);
			moto.setNumChass(numChass);
			String nmAuto = Keyboard.readString("Informe o nome da Motocicleta: ");
			moto.setNome(nmAuto);
			int ano = prova1.Keyboard.readInt("Informe o ano de fabricação: ");
			moto.setAnoFab(ano);
			int categ = Keyboard.readInt("Digite a categoria: 1-Scooter; 2-Naked; 3-Sport");
			Categoria categoria;
			if (categ == 1) {
				categoria = Categoria.Scooter;
			} else if (categ == 2) {
				categoria = Categoria.Naked;
			} else {
				categoria = Categoria.Sport;
			}
			moto.setCateg(categoria);
			
			if (motoVenda.getNode(numChass) != null) {
				System.err.println("Automóvel já cadastrado.");
			} else
				motoVenda.insert(numChass, moto);
			
		resp = Keyboard.readChar("cadastrar outro automóvel? (s/n): ");
		} while (resp == 's');
		
	}

}
