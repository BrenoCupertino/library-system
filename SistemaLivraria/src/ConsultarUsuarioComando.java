
public class ConsultarUsuarioComando implements Comando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
				
		UsuarioInterface usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

	}

}
