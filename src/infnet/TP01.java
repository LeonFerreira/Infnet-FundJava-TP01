package infnet;
import java.util.Scanner;

public class TP01 {
	private static String[] nomes;
	private static float[] av1;
	private static float[] av2;
	
	private static final int SIZE = 100;
	
	private static int index;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String opcao = null;
		
		nomes = new String[SIZE];
		av1 = new float[SIZE];
		av2 = new float [SIZE];
		
		
		do {
			System.out.println("\n[1] Registrar as notas de um novo aluno. (Máximo de registros = 100)");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair.");
			System.out.println("-----------------------------------------");
			System.out.println("Digite a opção desejada: ");
			opcao = scan.next();
			
			switch (opcao) {
				case "1":
						if (index < SIZE) {
							System.out.println("Informe o nome do aluno: ");
							nomes[index] = scan.next();
							
							System.out.println("Informe a nota da AV1 deste aluno: ");
							av1[index] = scan.nextFloat();
							
							System.out.println("Informe a nota da AV2 deste aluno: ");
							av2[index] = scan.nextFloat();
							
							System.out.println("ALUNO REGISTRADO COM CÓDIGO: " + index + "\n");
							
							index++;
							
							if (index == SIZE) {
								System.out.println("Limite de alunos atingido. Um novo registro não será mais permitido\n");								
							}							
						}else {
							System.out.println("Limite de cadastramento atingido.");
						}
					break;
					
				case "2":
						System.out.println("Digite o código do aluno para consulta: ");
						int codigo = scan.nextInt();
						
						if (codigo >= 0 && codigo < index) {
							imprimir(codigo);
							getSituacao(codigo);
						}
						else {
							System.out.println("Código de aluno inválido.");
						}
					break;
					
				case "3":
						imprimir();					
					break;
					
				case "4":
						System.out.println("Sistema encerrado.");
					break;
			
				default:
					System.out.println("Opção invalida.");
					break;
			}
			
		} while (!opcao.equals("4"));
		
		scan.close();
	}
	
	private static void imprimir() {
		System.out.println("Listagem de toda a turma: ");
		for (int i = 0; i < index; i++) {
			imprimir(i);			
		}
		
	}
	
	private static void imprimir(int posicao) {
		
		System.out.println("Nome do aluno: " + nomes[posicao] + "\nNota da AV1: " + av1[posicao] + "\nNota da AV2: " + av2[posicao] + "\nMédia Final: " + mediaFinal(posicao) + "\nSituação: " + getSituacao(posicao));
	}
	
	private static String getSituacao(int posicao) {
		
		String situacao = null;
		
		if (mediaFinal(posicao) < 4) {
			situacao = "Reprovado";
		} else if (mediaFinal(posicao) > 4 && mediaFinal(posicao) < 7) {
			situacao = "Prova final.";
		} else {
			situacao = "Aprovado.";
		}
		
		return situacao;
	}
	
	private static float mediaFinal(int posicao) {
		
		float mediaFinal = (av1[posicao] + av2[posicao]) / 2;
		
		return mediaFinal;
	}
	
	
	
 }
