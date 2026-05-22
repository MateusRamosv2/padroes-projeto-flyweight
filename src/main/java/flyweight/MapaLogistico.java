package flyweight;

import java.util.ArrayList;
import java.util.List;

public class MapaLogistico {
    private List<VeiculoRastreado> frota = new ArrayList<>();

    public void adicionarVeiculoNoMapa(String placa, double latitude, double longitude, String tipoModelo, String iconeUrl) {

        ModeloVeiculo modelo = ModeloVeiculoFactory.getModelo(tipoModelo, iconeUrl);
        VeiculoRastreado veiculo = new VeiculoRastreado(placa, latitude, longitude, modelo);
        frota.add(veiculo);
    }

    public List<String> renderizarMarcadores() {
        List<String> saida = new ArrayList<>();
        for (VeiculoRastreado veiculo : this.frota) {
            saida.add(veiculo.gerarMarcadorMapa());
        }
        return saida;
    }
}