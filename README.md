# Padrões de Projeto - Flyweight

---

## Estrutura do Projeto

- **Flyweight / Objeto Compartilhado (Estado Intrínseco):** `ModeloVeiculo` → Representa a parte do estado do objeto que é pesada (como imagens 3D, ícones ou texturas) e que se repete em vários contextos. Este estado é imutável e centralizado. Neste projeto, guarda o tipo de veículo e a URL do seu ícone visual no mapa.
- **Contexto (Estado Extrínseco):** `VeiculoRastreado` → Representa a parte do estado que varia a cada instante e é única para cada instância, como a `placa`, `latitude` e `longitude`. Em vez de guardar o seu próprio ícone pesado, ele possui apenas um ponteiro (referência) para um `ModeloVeiculo` compartilhado.
- **Fábrica de Cache (Registry):** `ModeloVeiculoFactory` → Classe utilitária (com atributos estáticos) responsável por gerenciar o pool de Flyweights. Ela intercepta os pedidos de criação e garante que, se dois veículos exigirem o mesmo modelo visual (ex: "Caminhão Baú"), a mesma instância de memória seja reaproveitada, economizando recursos drasticamente.
- **Cliente:** `MapaLogistico` → Orquestra o sistema. Solicita à Factory as instâncias compartilhadas e monta os objetos de contexto (`VeiculoRastreado`) em uma grande lista (a frota).
- **Testes:** `MapaLogisticoTest` → Valida, utilizando a biblioteca JUnit, a correta renderização dos veículos. O teste mais importante da suíte prova a economia de memória: ao tentar renderizar quatro caminhões no mapa, o teste garante que o tamanho do cache na fábrica seja estritamente limitado à quantidade de modelos visuais únicos (apenas duas instâncias pesadas).

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O grande destaque arquitetural é o posicionamento central da classe `ModeloVeiculoFactory`. Observe que o cliente (`MapaLogistico`) nunca dá "new" diretamente no estado pesado; ele delega isso à Fábrica, que por sua vez fornece a mesma referência em memória para os múltiplos objetos de contexto (`VeiculoRastreado`).

<img width="818" height="529" alt="Diagrama - Flyweight" src="https://github.com/user-attachments/assets/c1def512-19c9-4bbc-ba2a-49ebb93b8724" />

