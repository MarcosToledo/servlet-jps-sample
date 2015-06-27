<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Marcola dos Ajax</title>
	</head>
	<body>
		<form id="form-contato">
			<label for="nome">Nome</label> 
			<br/>
			<input type="text" name="nome"/>
			<br/>
			<label for="teste"> Teste</label>
			<br/>
			<input type="text" name="teste"/>
			<br/>
			<label for="email">Email</label> 
			<br/>
			<input type="text" name="email"/>	
			<br/>
			<label for="telefone">Telefone</label> 
			<br/>
			<input type="text" name="telefone"/>
			<br/>
			<input type="button" value="Enviar" id="botao-enviar"/>			
		</form>
		<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript">
			// Função executada ao entrar na tela
			$(document).ready(function () {
				
				ajaxBoasVindas();								// Chama um ajax pra exemplificar o uso do GET
				
				$('#botao-enviar').click(function () { 			// Função click do botão de enviar recuperado pelo ID
					$.ajax({
						url: '/marcola/controle-principal', 	// Url da servlet que vai receber a requisição
						method: 'POST',							// verbo do http utilizado (no caso post para enviar dados)
						data: $('#form-contato').serialize(),	// Envia todos os campos do formulário para serem recuperados pelo 'name' atribuido a cada um
						success: function(data) {				// Função chamada quando o servidor devolve o response corretamente
							$('body').append('Sucesso na requisição do ajax: ' + data);
						},
						error: function (err) {					// Função chamada quando há um erro de processamento no servidor
							$('body').append('Erro na requisição do ajax: ' + err);
						}					
					});
				});
			});
			function ajaxBoasVindas() {
				$.ajax({
					url: '/marcola/controle-principal',
					method: 'GET',
					success: function (data) {
						$('body').prepend(data); // prepend coloca oq vc passar no início do cara que vc ta atacando (no caso o body) 
					}, 
					error: function (err) {
						$('body').append(err); // e append poem no final
					}
				});
			}
		</script>
	</body>
</html>