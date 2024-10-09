public class Aluno {
    int IdAluno;
    String NomeAluno;
    String DataNascimento;
    String Cpf;
    Curso curso; //chave estrangeira de curso

    public Aluno(int IdAluno, String NomeAluno, String DataNascimento, String Cpf, Curso curso){
        this.IdAluno = IdAluno;
        this.NomeAluno = NomeAluno;
        this.DataNascimento = DataNascimento;
        this.Cpf = Cpf;
        this.curso = curso;

    }

    public  int getIdAluno(){
        return IdAluno;
    }
    public String getNomeAluno(){
        return NomeAluno;
    }
    public String GetDataNascimento(){
        return DataNascimento;
    }
    public String GetCpf(){
        return Cpf;
    }
    public Curso GetCurso(){
        return curso;
    }
  
}
