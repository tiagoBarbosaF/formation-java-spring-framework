package javaservlet.gerenciador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static final List<Empresa> listEmpresa = new ArrayList<>();

    static {
        Empresa empresa1 = new Empresa();
        empresa1.setNome("Coca-Cola");
        Empresa empresa2 = new Empresa();
        empresa2.setNome("McDonald");
        Empresa empresa3 = new Empresa();
        empresa3.setNome("Heineken");
        listEmpresa.add(empresa1);
        listEmpresa.add(empresa2);
        listEmpresa.add(empresa3);
    }

    public void adicionaEmpresa(Empresa empresa) {
        Banco.listEmpresa.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.listEmpresa;
    }
}
