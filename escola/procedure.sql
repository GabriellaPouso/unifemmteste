Este procedure irá gerar um relatório com a data, o nome do produto e a quantidade comprada naquele dia.

1. Estrutura do Banco de Dados:

Primeiramente, precisamos entender a estrutura do banco de dados da empresa. Vamos assumir que existam as seguintes tabelas:

produtos:*
id_produto (INT, PRIMARY KEY)
nome_produto (VARCHAR)
vendas:*
id_venda (INT, PRIMARY KEY)
data_venda (DATE)
id_produto (INT, FOREIGN KEY referencing produtos(id_produto))
quantidade (INT)
2. Criando o Procedure:

SQL

CREATE PROCEDURE relatorio_diario_produtos()
BEGIN
    SELECT 
        v.data_venda,
        p.nome_produto,
        SUM(v.quantidade) AS quantidade_comprada
    FROM vendas v
    INNER JOIN produtos p ON v.id_produto = p.id_produto
    GROUP BY v.data_venda, p.nome_produto
    ORDER BY v.data_venda;
END;
3. Explicando o Procedure:

O procedure relatorio_diario_produtos() utiliza um SELECT para obter os dados necessários.
Ele faz um JOIN entre as tabelas vendas e produtos para relacionar as vendas com os produtos correspondentes.
A função SUM(v.quantidade) calcula a quantidade total de cada produto vendido em um determinado dia.
O GROUP BY v.data_venda, p.nome_produto agrupa os resultados por data e nome do produto, permitindo que vejamos a quantidade comprada de cada produto em cada dia.
O ORDER BY v.data_venda ordena o relatório por data de venda.
4. Executando o Procedure:

Para executar o procedure e gerar o relatório, basta usar o seguinte comando:

SQL

CALL relatorio_diario_produtos();
5. Resultado:

O procedure irá retornar um relatório com as seguintes colunas:

data_venda (DATE)
nome_produto (VARCHAR)
quantidade_comprada (INT)
Este relatório mostrará a quantidade de cada produto que foi comprada em cada dia.

Observações:

Este procedure pode ser adaptado para incluir outros dados relevantes, como o valor total das vendas, o nome do cliente, etc.
É possível adicionar filtros para gerar relatórios de períodos específicos, como a última semana, o último mês, etc.
Com este procedure, a empresa de vendas terá um processo mais ágil e eficiente para gerar relatórios diários de produtos comprados, facilitando o acompanhamento das vendas e a tomada de decisões estratégicas.