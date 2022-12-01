package mapaDispersao;

public class TesteMapaDispersao {
    
    public static int numTeste = 1;

    public static void main(String[] args) {
        MapaDispersao<Aluno> alunos = new MapaDispersao<>(53);
        Aluno jean = new Aluno(12000, "Jean");
        alunos.inserir(jean.getMatricula(), jean);
        testarEquals(jean.hashCode(), alunos.buscar(jean.getMatricula()).hashCode());

        Aluno pedro = new Aluno(14000, "Pedro");
        Aluno marta = new Aluno(12500, "Marta");
        Aluno lucas = new Aluno(13000, "Lucas");
        alunos.inserir(pedro.getMatricula(), pedro);
        alunos.inserir(marta.getMatricula(), marta);
        alunos.inserir(lucas.getMatricula(), lucas);
        testarEquals(pedro.hashCode(), alunos.buscar(pedro.getMatricula()).hashCode());
        testarEquals(marta.hashCode(), alunos.buscar(marta.getMatricula()).hashCode());
        testarEquals(lucas.hashCode(), alunos.buscar(lucas.getMatricula()).hashCode());

        alunos = new MapaDispersao<>(53);
        jean = new Aluno(12500, "Jean");
        pedro = new Aluno(14000, "Pedro");
        marta = new Aluno(14226, "Marta");
        lucas = new Aluno(17180, "Lucas");
        alunos.inserir(jean.getMatricula(), jean);
        alunos.inserir(pedro.getMatricula(), pedro);
        alunos.inserir(marta.getMatricula(), marta);
        alunos.inserir(lucas.getMatricula(), lucas);
        testarEquals(jean.hashCode(), alunos.buscar(jean.getMatricula()).hashCode());
        testarEquals(pedro.hashCode(), alunos.buscar(pedro.getMatricula()).hashCode());
        testarEquals(marta.hashCode(), alunos.buscar(marta.getMatricula()).hashCode());
        testarEquals(lucas.hashCode(), alunos.buscar(lucas.getMatricula()).hashCode());
    }

    public static void testar(String msg){
        System.out.println("Teste "+numTeste+": "+msg);
        numTeste++;
    }

    public static void testarEquals(Object msg, Object esperado){
        System.out.println("Teste "+numTeste+": "+msg.equals(esperado));
        numTeste++;
    }

    public static String arrayToString(Integer[] array){
        String msg = "[";
        for(Integer value : array){
            msg +=  ","+value.toString();
        }
        msg += "]";
        return msg.replaceFirst(",", "");
    }
}
