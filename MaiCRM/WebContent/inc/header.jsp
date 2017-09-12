<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">MyCRM - Customer Relationship Manager</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-left">        
            <li><a href="/MaiCRM/filtrarManutencoes">Principal</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    Gerenciar <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/MaiCRM/gerenciarAtendentes">Atendentes e Supervisores</a></li>
                    <li><a href="/MaiCRM/gerenciarClientes">Clientes</a></li>
					<li><a href="/MaiCRM/gerenciarProdutos">Produtos</a></li>
					<li><a href="/MaiCRM/gerenciarServicos">Serviços</a></li>
                </ul>
            </li>
			<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    Cadastrar <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/MaiCRM/cadastrarManutencao">Manutenção</a></li>
                </ul>
            </li>
            <li><a href="/MaiCRM/logoutLoginCRM">Sair</a></li>
          </ul>
        </div>
		<!--/.navbar-collapse -->
      </div>
    </nav>