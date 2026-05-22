package flyweight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapaLogisticoTest {

    @Test
    void deveRenderizarMarcadoresDosVeiculosNoMapa() {
        MapaLogistico mapa = new MapaLogistico();
        mapa.adicionarVeiculoNoMapa("ABC-1234", -23.5505, -46.6333, "Caminhão Baú", "icone_bau.png");
        mapa.adicionarVeiculoNoMapa("DEF-5678", -22.9068, -43.1729, "Caminhão Baú", "icone_bau.png");
        mapa.adicionarVeiculoNoMapa("GHI-9012", -19.9167, -43.9345, "Carreta Fria", "icone_fria.png");

        List<String> saidaEsperada = Arrays.asList(
                "VeiculoRastreado{placa='ABC-1234', lat=-23.5505, lng=-46.6333, tipo='Caminhão Baú', icone='icone_bau.png'}",
                "VeiculoRastreado{placa='DEF-5678', lat=-22.9068, lng=-43.1729, tipo='Caminhão Baú', icone='icone_bau.png'}",
                "VeiculoRastreado{placa='GHI-9012', lat=-19.9167, lng=-43.9345, tipo='Carreta Fria', icone='icone_fria.png'}"
        );

        assertEquals(saidaEsperada, mapa.renderizarMarcadores());
    }

    @Test
    void deveEconomizarMemoriaCompartilhandoModelosIguais() {
        MapaLogistico mapa = new MapaLogistico();


        mapa.adicionarVeiculoNoMapa("ABC-1234", -23.5505, -46.6333, "Caminhão Baú", "icone_bau.png");
        mapa.adicionarVeiculoNoMapa("DEF-5678", -22.9068, -43.1729, "Caminhão Baú", "icone_bau.png");
        mapa.adicionarVeiculoNoMapa("XYZ-9999", -21.7667, -43.3500, "Caminhão Baú", "icone_bau.png");

        mapa.adicionarVeiculoNoMapa("GHI-9012", -19.9167, -43.9345, "Carreta Fria", "icone_fria.png");


        assertEquals(2, ModeloVeiculoFactory.getTotalModelosEmMemoria());
    }
}