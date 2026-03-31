package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.CircuitParallele;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {

    private Composant lireCircuit(JsonNode node) {
        String type = node.get("type").asText();

        if ("resistance".equals(type)) {

            return new Resistance(node.get("value").asDouble());

        } else if ("parallelle".equals(type)) {

            List<Composant> composants = new ArrayList<>();

            for(JsonNode composantNode : node.get("composants")) {
                composants.add(lireCircuit(composantNode));
            }
            return new CircuitParallele(composants);

        } else if ("serie".equals(type)) {

            List<Composant> composants = new ArrayList<>();

            for(JsonNode composantNode : node.get("composants")) {
                composants.add(lireCircuit(composantNode));
            }
            return new CircuitSerie(composants);
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }

    private final ObjectMapper mapper = new ObjectMapper();

    public Composant construireCircuit(String cheminFichier) throws IOException {
        JsonNode node = mapper.readTree(new File(cheminFichier));
        return lireCircuit(node);
    }
}