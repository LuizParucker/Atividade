import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        int opt = 0; // começar o menu na posição 0
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();

        do {
            System.out.println("Menu de opções:");
            System.out.println("Digite a opção desejada:");
            System.out.println("1. Cadastro de professor");
            System.out.println("2. Cadastro de aluno");
            System.out.println("3. Cadastro de curso");
            System.out.println("4. Listar professores");
            System.out.println("5. Listar alunos matriculados");
            System.out.println("6. Listar cursos");
            System.out.println("7. Sair");

            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Você inseriu uma opção inválida. Por favor tente novamente!");
                scanner.nextLine();
                continue;
            }
            switch (opt) {
                case 1: {
                    System.out.println("Cadastro do professor:");
                    System.out.println("Informe o ID:");
                    int IdProfessor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nome do professor:");
                    String NomeProfessor = scanner.nextLine();
                    System.out.println("Informe o departamento:");
                    String Departamento = scanner.nextLine();
                    Professor professor = new Professor(IdProfessor, NomeProfessor, Departamento);
                    professores.add(professor);
                    System.out.println("Cadastro de professor realizado com sucesso!");
                    break;

                }
                case 2: {
                    System.out.println("Cadastro de aluno");
                    System.out.println("Informe o ID do aluno: ");
                    int IdAluno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o nome do aluno:");
                    String NomeAluno = scanner.nextLine();
                    System.out.println("Informe o CPF do aluno: ");
                    String Cpf = scanner.nextLine();
                    System.out.println("Informe a data de nascimento: ");
                    String DataNascimento = scanner.nextLine();
                    alunos.add(new Aluno(IdAluno, NomeAluno, DataNascimento, Cpf, null));
                    System.out.println("Cadastro de aluno realizado com sucesso!");
                    break;
                }
                case 3: {
                    System.out.println("Cadastro de curso");
                    System.out.println("Informe o ID do curso: ");
                    int IdCurso = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o nome do curso: ");
                    String NomeCurso = scanner.nextLine();
                    System.out.println("Informe a carga horária do curso: ");
                    int CargaHoraria = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Informe o ID do professor que aplica o curso: ");
                    for (Professor professor : professores) {
                        System.out.println(professor.GetNomeProfessor() + "ID: " + professor.GetIdProfessor() + ")");

                    }
                    int IdProfessor = Integer.parseInt(scanner.nextLine());
                    Professor professor = null;

                    for(Professor p: professores){
                        if(p.GetIdProfessor() ==  IdProfessor){
                            professor = p;
                            break;
                        }
                    }

                    Curso curso = new Curso(IdCurso, NomeCurso, CargaHoraria, professor);
                    cursos.add(curso);

                    break;

                }

                case 4: {
                    System.out.println("Listagem de professores: ");
                    if (professores.isEmpty()) { // caso não tenha nenhum professor cadastrado
                        System.out.println("Nenhum professor cadastrado.");
                    } else {
                        for (Professor professor : professores) {
                            System.out.println("Nome: " + professor.GetNomeProfessor());
                            System.out.println("Departamento: " + professor.GetDepartamento());
                            System.out.println("Cursos associados:");

                            // Listar cursos que o professor está associado
                            for (Curso curso : cursos) {
                                if (curso.GetIdProfessor() == professor.GetIdProfessor()) {
                                    System.out.println("  - Curso: " + curso.GetNomeCurso() + " (Carga Horária: "
                                            + curso.GetCargaHoraria() + ")");

                                    // Contar e exibir a quantidade de alunos no curso
                                    int qtdAlunos = 0;
                                    for (Aluno aluno : alunos) {
                                        if (aluno.GetCurso() != null && aluno.GetCurso().equals(curso)) {
                                            qtdAlunos++;
                                        }
                                    }
                                    System.out.println("    Número de alunos matriculados: " + qtdAlunos);
                                }
                            }
                            System.out.println(); // Linha em branco para separar professores
                        }
                    }
                    break;

                }
                case 5: {
                    System.out.println("Listagem de alunos matriculados:");
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (Aluno aluno : alunos) {
                            System.out.println("Nome: " + aluno.getNomeAluno());
                            System.out.println("CPF: " + aluno.GetCpf());
                            System.out.println("Data de Nascimento: " + aluno.GetDataNascimento());

                            if (aluno.GetCurso() != null) {
                                System.out.println("Curso: " + aluno.GetCurso().GetNomeCurso());
                            } else {
                                System.out.println("Curso: Não matriculado.");
                            }
                            System.out.println(); //separar alunos 
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Listagem de cursos:");
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {
                        for (Curso curso : cursos) {
                            System.out.println("Nome do curso: " + curso.GetNomeCurso());
                            System.out.println("Carga Horária: " + curso.GetCargaHoraria() + " horas");
                            System.out.println("Professor: " + curso.GetNomeProfessor());
                
                            // Contar e exibir a quantidade de alunos no curso
                            int qtdAlunos = 0;
                            for (Aluno aluno : alunos) {
                                if (aluno.GetCurso() != null && aluno.GetCurso().equals(curso)) {
                                    qtdAlunos++;
                                }
                            }
                            System.out.println("Número de alunos matriculados: " + qtdAlunos);
                            System.out.println(); // Linha em branco para separar cursos
                        }
                    }
                    break;
                }

            }

        } while (opt != 7);

    }
}
