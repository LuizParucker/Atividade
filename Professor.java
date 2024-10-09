import java.util.ArrayList;

public class Professor {

    int IdProfessor;
    String NomeProfessor;
    String Departamento;
    ArrayList<Curso> cursos; // vai ser para manter o relacionamento  1-N entre professor e curso. 
                            // vai servir também para armazenar objeto professor

    public Professor(int IdProfessor, String NomeProfessor, String Departamento){
        this.IdProfessor = IdProfessor;
        this.NomeProfessor = NomeProfessor;
        this.Departamento = Departamento;
        this.cursos = new ArrayList<>();
    }
//usar o get para obter o valor ID, nome e o departamento do professor e as demais informações do professor
    public int GetIdProfessor(){
        return IdProfessor;
    }

    public String GetNomeProfessor(){
        return NomeProfessor;
    }

    public String GetDepartamento(){
        return Departamento;
    }

}