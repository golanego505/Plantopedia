package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlantOrSpeciesListEntry extends PlantSpecies {
    @JsonProperty("synonyms")
    private List<String> truncatedSynonyms;

    @JsonProperty("synonyms")
    public List<String> getTruncatedSynonyms() {
        return truncatedSynonyms;
    }

    public void setTruncatedSynonyms(List<String> truncatedSynonyms) {
        this.truncatedSynonyms = truncatedSynonyms;
    }
}
