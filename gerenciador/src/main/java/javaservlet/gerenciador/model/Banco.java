package javaservlet.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static final List<Empresa> LIST_EMPRESAS = new ArrayList<>();
    private static final List<Usuario> LIST_USUARIOS = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa1 = new Empresa();
        empresa1.setId(Banco.chaveSequencial++);
        empresa1.setNome("Coca-Cola");
        Empresa empresa2 = new Empresa();
        empresa2.setId(Banco.chaveSequencial++);
        empresa2.setNome("McDonald");
        Empresa empresa3 = new Empresa();
        empresa3.setId(Banco.chaveSequencial++);
        empresa3.setNome("Heineken");
        LIST_EMPRESAS.add(empresa1);
        LIST_EMPRESAS.add(empresa2);
        LIST_EMPRESAS.add(empresa3);

        Usuario u1 = new Usuario();
        u1.setLogin("tiago");
        u1.setSenha("12345");

        Usuario u2 = new Usuario();
        u2.setLogin("peter");
        u2.setSenha("12345");
        LIST_USUARIOS.add(u1);
        LIST_USUARIOS.add(u2);
    }

    public void adicionaEmpresa(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.LIST_EMPRESAS.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.LIST_EMPRESAS;
    }

    public void removeEmpresa(Integer id) {
        LIST_EMPRESAS.removeIf(empresa -> empresa.getId().equals(id));
    }

    public Empresa buscaEmpresaId(Integer id) {
        for (Empresa empresa :
                LIST_EMPRESAS) {
            if (empresa.getId().equals(id)) {
                return empresa;
            }
        }
        return null;
    }

    public Usuario existeUsuario(String login, String senha) {
        for (Usuario usuario :
                LIST_USUARIOS) {
            if (usuario.isEqual(login, senha)) {
                return usuario;
            }
        }
        return null;
    }
}
