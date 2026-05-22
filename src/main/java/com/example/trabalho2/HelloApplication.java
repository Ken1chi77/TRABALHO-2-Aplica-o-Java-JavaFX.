package com.example.tgit initrabalho2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {

    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    private TextField txtNome;
    private TextField txtCpf;
    private TextField txtEmail;
    private TextField txtTelefone;

    private TextArea areaLista;

    @Override
    public void start(Stage stage) {

        txtNome = new TextField();
        txtCpf = new TextField();
        txtEmail = new TextField();
        txtTelefone = new TextField();

        Label lblNome = new Label("Nome:");
        Label lblCpf = new Label("CPF:");
        Label lblEmail = new Label("E-mail:");
        Label lblTelefone = new Label("Telefone:");

        Button btnSalvar = new Button("Salvar");
        Button btnCancelar = new Button("Cancelar");
        Button btnListar = new Button("Listar");

        areaLista = new TextArea();
        areaLista.setEditable(false);

        btnSalvar.setOnAction(e -> salvarPessoa());
        btnCancelar.setOnAction(e -> limparCampos());
        btnListar.setOnAction(e -> listarPessoas());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);

        grid.add(lblCpf, 0, 1);
        grid.add(txtCpf, 1, 1);

        grid.add(lblEmail, 0, 2);
        grid.add(txtEmail, 1, 2);

        grid.add(lblTelefone, 0, 3);
        grid.add(txtTelefone, 1, 3);

        HBox botoes = new HBox(10);
        botoes.getChildren().addAll(btnSalvar, btnCancelar, btnListar);

        VBox root = new VBox(15);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(grid, botoes, areaLista);

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("Cadastro de Pessoas");
        stage.setScene(scene);
        stage.show();
    }

    private void salvarPessoa() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String telefone = txtTelefone.getText();

        Pessoa pessoa = new Pessoa(nome, cpf, email, telefone);
        listaPessoas.add(pessoa);

        System.out.println("Pessoa cadastrada!");
        areaLista.setText("Usuário " + nome + " cadastrado com sucesso!\n");

        limparCampos();
    }

    private void limparCampos() {
        txtNome.clear();
        txtCpf.clear();
        txtEmail.clear();
        txtTelefone.clear();
    }

    private void listarPessoas() {
        areaLista.clear();

        if (listaPessoas.isEmpty()) {
            areaLista.setText("Nenhum registro encontrado.");
            return;
        }

        for (Pessoa p : listaPessoas) {
            areaLista.appendText(
                    "Nome: " + p.getNome() + "\n" +
                            "CPF: " + p.getCpf() + "\n" +
                            "E-mail: " + p.getEmail() + "\n" +
                            "Telefone: " + p.getTelefone() + "\n" +
                            "----------------------\n"
            );
        }
    }

    static class Pessoa {
        private String nome;
        private String cpf;
        private String email;
        private String telefone;

        public Pessoa(String nome, String cpf, String email, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.telefone = telefone;
        }

        public String getNome() { return nome; }
        public String getCpf() { return cpf; }
        public String getEmail() { return email; }
        public String getTelefone() { return telefone; }
    }

    public static void main(String[] args) {
        launch();
    }
}