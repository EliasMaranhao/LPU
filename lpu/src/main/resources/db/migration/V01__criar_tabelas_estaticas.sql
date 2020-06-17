create table aplicacao(
	id bigint(20) not null auto_increment primary key,
	nome varchar(255) not null
)ENGINE=InnoDB default charset=utf8;

create table etapa(
	id bigint(20) not null auto_increment primary key,
	nome varchar(255) not null
)ENGINE=InnoDB default charset=utf8;

create table atividade(
	id bigint(20) not null auto_increment primary key,
	duracao varchar(255) not null,
	nome varchar(255) not null,
	etapa_id bigint(20) not null,
	foreign key (etapa_id) references etapa(id)
)ENGINE=InnoDB default charset=utf8;

insert into aplicacao values (1, '880');
insert into aplicacao values (2, 'Empresarial');
insert into aplicacao values (3, 'OCT');
insert into aplicacao values (4, 'Oi10331Unificada');
insert into aplicacao values (5, 'OiTotal');
insert into aplicacao values (6, 'OiTv');
insert into aplicacao values (7, 'PósPago');
insert into aplicacao values (8, 'PréPago');
insert into aplicacao values (9, 'RACO');
insert into aplicacao values (10, 'Rio Card');

insert into etapa values (1, 'Análise e Validação de Briefing');
insert into etapa values (2, 'Desenho');
insert into etapa values (3, 'Aprovação - Oi');
insert into etapa values (4, 'Cenário de Teste');
insert into etapa values (5, 'Criação Gmud - Liberações');
insert into etapa values (6, 'Desenvolvimento e Teste Unitário');
insert into etapa values (7, 'Teste Integrado');
insert into etapa values (8, 'Acompanhamento UAT');
insert into etapa values (9, 'Preparo Implantação');
insert into etapa values (10, 'Pós Release');

insert into atividade values (1,'02:00:00','Análise e Validação de Briefing',1),
                                                             (2,'08:00:00','Entendimento escopo de demanda média complexidade',1),
                                                             (3,'16:00:00','Entendimento escopo de demanda alta complexidade',1),
                                                             (4,'01:00:00','Levantamento de O.G.',1),
                                                             (5,'00:30:00','Planejamento e criação de sub-tarefas',1),
                                                             (6,'00:30:00','Higienização do fluxo',2),
                                                             (7,'00:30:00','Higienização da template',2),
                                                             (8,'00:10:00','Alteração de prompt',2),
                                                             (9,'00:30:00','Novo menu',2),
                                                             (10,'00:20:00','Alteração de opção de menu',2),
                                                             (11,'00:30:00','Inclusão de regra',2),
                                                             (12,'00:10:00','Marcação de variável',2),
                                                             (13,'00:05:00','Inclusão de IC',2),
                                                             (14,'01:00:00','Definição de regra de negócio',2),
                                                             (15,'00:10:00','Alteração de fluxo - Inclusão de consulta',2),
                                                             (16,'00:10:00','Inclusão de 01 ponto de derivação',2),
                                                             (17,'00:05:00','Exclusão de regra, menu, prompt, ou fluxo inteiro',2),
                                                             (18,'01:00:00','Atualização de planilha de roteamento - Inclusão de novas regras',2),
                                                             (19,'00:20:00','Atualização de planilha de roteamento - Alteração de regras',2),
                                                             (20,'00:05:00','Atualização de planilha de roteamento - Exclusão de regras',2),
                                                             (21,'02:00:00','Alteração de template',2),
                                                             (22,'00:30:00','Alteração de template primária cartão - por grupo de DDD',2),
                                                             (23,'00:30:00','Alteração de template secundária cartão - por grupo de DDD',2),
                                                             (24,'00:30:00','Alteração de template primária controle - por grupo de DDD',2),
                                                             (25,'00:30:00','Alteração de template secundária controle - por grupo de DDD',2),
                                                             (26,'00:10:00','Lista de controles - ICs, forms',2),
                                                             (27,'00:05:00','Lista de prompt',2),
                                                             (28,'00:20:00','Relatório de consulta',2),
                                                             (29,'00:10:00','Variável de contexto',2),
                                                             (30,'00:30:00','Alteração da aba - Tela única',2),
                                                             (31,'00:30:00','Nova aba - Tela única',2),
                                                             (32,'00:10:00','Alteração nome aba - Tela única',2),
                                                             (33,'01:00:00','Alteração - Inclusão de tela',2),
                                                             (34,'00:30:00','Exclusão de regra, aba ou tela',2),
                                                             (35,'00:00:00','Aprovação - Oi',3),
                                                             (36,'00:30:00','Caderno de teste - cada cenário',4),
                                                             (37,'00:30:00','Print de tela - Tela única',4),
                                                             (38,'02:00:00','Detalhamento da camada para abertura de GMUD',5),
                                                             (39,'08:00:00','Liberação de acesso e levantamento de informações para consultas externas',5),
                                                             (40,'00:05:00','AlteraÃ§Ã£o de prompt',6),
                                                             (41,'00:30:00','Versionamento do código e preenchimento de documentação',6),
                                                             (42,'00:05:00','QA de prompts',6),
                                                             (43,'00:15:00','Prompt dinâmico',6),
                                                             (44,'01:00:00','Novo menu',6),
                                                             (45,'00:45:00','Inclusão de regra',6),
                                                             (46,'00:05:00','Marcação de variável',6),
                                                             (47,'00:05:00','Inclusão de IC',6),
                                                             (48,'20:00:00','Desenvolvimento de consulta à webservice',6),
                                                             (49,'01:30:00','Desenvolvimento de consulta à webservice - adicional para cada método existente no WS',6),
                                                             (50,'02:00:00','Alteração ou inclusão de rotina de prompt dinâmico (ex: <valor da conta>)',6),
                                                             (51,'03:05:00','Criação de mailing',6),
                                                             (52,'10:00:00','Criação de procedure ou query (queries mais complexas. Ex: consulta Dados Fatura)',6),
                                                             (53,'00:20:00','Exclusão de mailing (exclusão de regra com consulta à mailing)',6),
                                                             (54,'01:00:00','Definição da regra de negócio',6),(55,'00:30:00','Exclusão de regra, procedure ou itens que envolvam código java',6),
                                                             (56,'00:05:00','Exclusão de regra, menu, prompt ou fluxo inteiro',6),(57,'02:00:00','Criação de script de template primária',6),
                                                             (58,'02:00:00','Criação de script de template secundária',6),
                                                             (59,'00:00:00','Code review',6),
                                                             (60,'00:45:00','Teste unitário de menu novo',6),
                                                             (61,'00:30:00','Teste unitário de menu alterado',6),
                                                             (62,'00:20:00','Teste unitário de regra',6),
                                                             (63,'00:30:00','Teste unitário de mailing',6),
                                                             (64,'02:00:00','Teste unitário de procedure ou query',6),
                                                             (65,'04:00:00','Teste unitário de webservice (por método)',6),
                                                             (66,'00:30:00','Alteração de opção e menu',6),
                                                             (67,'00:10:00','Inclusão de 01 ponto de derivação',6),
                                                             (68,'01:00:00','Critério de roteamento - alteração ou inclusão de regra de derivação',6),
                                                             (69,'00:35:00','Criação de parâmentro',6),
                                                             (70,'00:45:00','Teste unitário de nova opção',6),
                                                             (71,'00:10:00','Variável de contexto',6),
                                                             (72,'00:45:00','Teste unitário de variáveis de contexto',6),
                                                             (73,'00:10:00','Alteração nome aba - Tela única',6),
                                                             (74,'00:30:00','Teste unitário de aba alterada',6),
                                                             (75,'00:10:00','Exclusão de regra, aba ou tela',6),
                                                             (76,'00:30:00','Atualização de planilha BRMS',6),
                                                             (77,'02:00:00','Atualização da macro',6),
                                                             (78,'02:00:00','Alteração da macro BRMS ativa',6),
                                                             (79,'02:00:00','Alteração da macro BRMS Promoção',6),
                                                             (80,'02:00:00','Alteração da macro BRMS sem fatura',6),
                                                             (81,'01:00:00','Atualizar o ambiente de teste',7),
                                                             (82,'00:05:00','Executar cenário de testes simples',7),
                                                             (83,'00:30:00','Executar cenário de teste complexo',7),
                                                             (84,'01:00:00','Executar cenário de teste forçado',7),
                                                             (85,'00:05:00','Executar print de tela simples',7),
                                                             (86,'00:30:00','Executar print de tela complexo',7),
                                                             (87,'01:00:00','Executar print de tela forçado',7),
                                                             (88,'04:00:00','Acompanhamento UAT',8),
                                                             (89,'02:00:00','Preparação da implantação',9),
                                                             (90,'12:00:00','Suporte implantação',10);