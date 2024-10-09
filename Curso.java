import java.util.ArrayList;




public class Curso {
    int IdCurso;
    String NomeCurso;
    int CargaHoraria;
    Professor professor; //chave estrangeira da pasta Professor
    String NomeProfessor;
    ArrayList<Aluno> alunos;
    String Curso;

    public Curso(int IdCurso, String NomeCurso, int CargaHoraria, Professor professor){
        this.IdCurso = IdCurso;
        this.NomeCurso = NomeCurso;
        this.CargaHoraria = CargaHoraria;
        this.professor = professor;
        this.NomeProfessor = NomeProfessor;
    }

    public String GetNomeCurso() {
        return NomeCurso;
    }

    public String GetNomeProfessor() {
        return NomeProfessor;
    }

    public int GetCargaHoraria() {
        return CargaHoraria;
    }
    public String GetCurso(){
        return Curso;
    }
    public int GetIdProfessor() {
        return professor.IdProfessor;
    }
   
}
