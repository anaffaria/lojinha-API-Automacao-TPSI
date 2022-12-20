package dataFactory;

import pojo.ComponentPojo;
import pojo.ProductPojo;

import java.util.ArrayList;
import java.util.List;

public class ProductDataFactory {
    public static ProductPojo createdCommonProductWithTheValueEqualTo(double value){
        ProductPojo product = new ProductPojo();
        product.setProdutoNome("Playstation 5");
        product.setProdutoValor(value);

        List<String> cores = new ArrayList<>();
        cores.add("preto");
        cores.add("branco");

        product.setProdutoCores(cores);
        product.setProdutoUrlMock("");

        List<ComponentPojo> componentes = new ArrayList<>();

        ComponentPojo primeiroComponente = new ComponentPojo();
        primeiroComponente.setComponenteNome("Controle");
        primeiroComponente.setComponenteQuantidade(1);
        componentes.add(primeiroComponente);

        ComponentPojo segundoComponente = new ComponentPojo();
        segundoComponente.setComponenteNome("Cabo");
        segundoComponente.setComponenteQuantidade(2);
        componentes.add(segundoComponente);

        product.setComponentes(componentes);

        return product;
    }


}
