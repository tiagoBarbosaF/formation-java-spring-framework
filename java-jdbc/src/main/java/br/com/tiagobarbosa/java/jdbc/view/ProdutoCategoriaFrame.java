package br.com.tiagobarbosa.java.jdbc.view;

import br.com.tiagobarbosa.java.jdbc.controller.CategoriaController;
import br.com.tiagobarbosa.java.jdbc.controller.ProdutoController;
import br.com.tiagobarbosa.java.jdbc.modelo.Categoria;
import br.com.tiagobarbosa.java.jdbc.modelo.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProdutoCategoriaFrame extends JFrame {
    private JLabel labelNome, labelDescricao, labelCategoria;
    private JTextField textoNome, textoDescricao;
    private JComboBox<Categoria> comboCategoria;
    private JButton botaoSalvar, botaoEditar, botaoLimpar, botaoApagar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private ProdutoController produtoController;
    private CategoriaController categoriaController;

    public ProdutoCategoriaFrame() {
        super("Produtos");
        Container container = getContentPane();
        setLayout(null);

        this.categoriaController = new CategoriaController();
        this.produtoController = new ProdutoController();

        labelNome = new JLabel("Nome do produto");
        labelDescricao = new JLabel("Descrição do produto");
        labelCategoria = new JLabel("Catagoria do produto");

        labelNome.setBounds(10, 10, 240, 15);
        labelDescricao.setBounds(10, 50, 240, 15);
        labelCategoria.setBounds(10, 90, 240, 15);

        labelNome.setForeground(Color.BLACK);
        labelDescricao.setForeground(Color.BLACK);
        labelCategoria.setForeground(Color.BLACK);

        container.add(labelNome);
        container.add(labelDescricao);
        container.add(labelCategoria);

        textoNome = new JTextField();
        textoDescricao = new JTextField();
        comboCategoria = new JComboBox<>();

        comboCategoria.addItem(new Categoria(0, "Selecione"));
        List<Categoria> categorias = this.listCategoria();
        for (Categoria categoria :
                categorias) {
            comboCategoria.addItem(categoria);
        }

        textoNome.setBounds(10, 25, 265, 20);
        textoDescricao.setBounds(10, 65, 265, 20);
        comboCategoria.setBounds(10, 105, 265, 20);

        container.add(textoNome);
        container.add(textoDescricao);
        container.add(comboCategoria);

        botaoSalvar = new JButton("Salvar");
        botaoLimpar = new JButton("Limpar");

        botaoSalvar.setBounds(10, 145, 100, 20);
        botaoLimpar.setBounds(120, 145, 100, 20);

        container.add(botaoSalvar);
        container.add(botaoLimpar);

        tabela = new JTable();
        modelo = (DefaultTableModel) tabela.getModel();

        modelo.addColumn("Identificador do produto");
        modelo.addColumn("Nome do produto");
        modelo.addColumn("Descrição do produto");

        preencherTabela();

        tabela.setBounds(10, 185, 760, 300);
        container.add(tabela);

        botaoApagar = new JButton("Excluir");
        botaoEditar = new JButton("Alterar");

        botaoApagar.setBounds(10, 500, 100, 20);
        botaoEditar.setBounds(120, 500, 100, 20);

        container.add(botaoApagar);
        container.add(botaoEditar);

        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);

        botaoSalvar.addActionListener(e -> {
            salvar();
            limparTabela();
            preencherTabela();
        });

        botaoLimpar.addActionListener(e -> {
            limpar();
        });

        botaoApagar.addActionListener(e -> {
            deletar();
            limparTabela();
            preencherTabela();
        });

        botaoEditar.addActionListener(e -> {
            alterar();
            limparTabela();
            preencherTabela();
        });
    }

    private void alterar() {
        Object objetoDaLinha = modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
            String descricao = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
            this.produtoController.edit(nome, descricao, id);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void deletar() {
        Object objetoDaLinha = modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());

        if (objetoDaLinha instanceof Integer id) {
            this.produtoController.delete(id);
            modelo.removeRow(tabela.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Item excluido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleciona o ID");
        }
    }

    private void limparTabela() {
        modelo.getDataVector().clear();
    }

    private void salvar() {
        if (!textoNome.getText().equals("") && !textoDescricao.getText().equals("")) {
            Produto produto = new Produto(textoNome.getText(), textoDescricao.getText());
            Categoria categoria = (Categoria) comboCategoria.getSelectedItem();
            assert categoria != null;
            produto.setCategoriaId(categoria.getId());
            this.produtoController.save(produto);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            this.limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Nome e descrição devem ser informados.");
        }
    }

    private void limpar() {
        this.textoNome.setText("");
        this.textoDescricao.setText("");
        this.comboCategoria.setSelectedIndex(0);
    }

    private void preencherTabela() {
        List<Produto> produtos = listProduto();
        try {
            for (Produto produto :
                    produtos) {
                modelo.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getDescricao()});
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private List<Produto> listProduto() {
        return this.produtoController.list();
    }

    private List<Categoria> listCategoria() {
        return this.categoriaController.listar();
    }
}
