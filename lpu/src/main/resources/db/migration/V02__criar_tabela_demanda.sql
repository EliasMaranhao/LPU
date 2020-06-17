create table lpu(
	id bigint(20) primary key auto_increment,
	data_Criacao date not null,
	criada_Por varchar(50) not null,
	descricao TEXT,
	etapa_Analise_ValidacaoBriefing varchar(50),
	etapa_Desenho varchar(50),
	etapa_Aprovacao_Oi varchar(50),
	etapa_Cenario_Teste varchar(50),
	etapa_Criacao_Gmud_Liberacao varchar(50),
	etapa_Desenvolvimento varchar(50),
	etapa_Teste_Integrado varchar(50),
	etapa_AcompanhamentoUAT varchar(50),
	etapa_Preparo_Implantcao varchar(50),
	etapa_Pos_Release varchar(50),
	total_Horas_Lpu varchar(50),
	total_Horas_Dec_Lpu varchar(50)
)ENGINE=InnoDB default charset=utf8;

create table usuario(
	id bigint(20) primary key auto_increment,
	nome varchar(50)not null,
	email varchar(50)not null unique,
	senha varchar(20)not null
)ENGINE=InnoDB default charset=utf8;

create table demanda(
	id bigint(20) primary key auto_increment,
	alfa_numerico varchar(10) not null unique,
	data_Release date not null,
	data_Preenchimento date not null,
	solicitante varchar(50) not null,
	descricao TEXT not null,
	aplicacao_id bigint(20) not null,
	situacao varchar(50) not null,
	observacao TEXT,
	lpu_id bigint(20),
	usuario_id bigint(20) not null
)ENGINE=InnoDB default charset=utf8;

alter table demanda add constraint fk_aplicacao foreign key (aplicacao_id) references aplicacao (id) ;
alter table demanda add constraint fk_lpu foreign key (lpu_id) references lpu (id) ;
alter table demanda add constraint fk_usuario foreign key (usuario_id) references usuario (id) ;
