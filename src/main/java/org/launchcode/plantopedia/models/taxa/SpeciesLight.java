package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SpeciesLight extends SpeciesCoreData {
    @JsonProperty("synonyms")
    private List<String> synonyms;

    @JsonProperty("synonyms")
    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }
}
