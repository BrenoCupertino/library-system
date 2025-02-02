public class App 
{
    public static void main(String[] args) throws Exception {

        // Caso de teste para validar a rotina de empréstimo

        UsuarioAbstrato usuario1 = new AlunoGraduacao("001","Ricardo");
        Livro livro1 = new Livro("123","Senhor dos Anéis","abc","abc","abc","abc");
        Exemplar exemplar1 = new Exemplar("001");
        livro1.adicionarExemplar(exemplar1);

        String mensagemDeEmprestimo = usuario1.emprestar(livro1);
        System.out.println("");
        System.out.println(mensagemDeEmprestimo);
        System.out.println("");
        
    }
}
