package javaservlet.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static final List<Empresa> listEmpresa = new ArrayList<>();
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
        listEmpresa.add(empresa1);
        listEmpresa.add(empresa2);
        listEmpresa.add(empresa3);
    }

    public void adicionaEmpresa(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.listEmpresa.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.listEmpresa;
    }

    public void removeEmpresa(Integer id) {
        listEmpresa.removeIf(empresa -> empresa.getId().equals(id));
    }

    public Empresa buscaEmpresaId(Integer id) {
        for (Empresa empresa :
                listEmpresa) {
            if (empresa.getId().equals(id)) {
                return empresa;
            }
        }
        return null;
    }
}
