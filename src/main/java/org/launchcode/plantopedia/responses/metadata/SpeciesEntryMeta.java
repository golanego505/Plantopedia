package org.launchcode.plantopedia.responses.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeciesEntryMeta extends EntryMeta {
    @JsonProperty("images_count")
    private Integer imagesCount;
    @JsonProperty("sources_count")
    private Integer sourcesCount;
    @JsonProperty("synonyms_count")
    private Integer synonymsCount;

    @JsonProperty("images_count")
    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    @JsonProperty("sources_count")
    public Integer getSourcesCount() {
        return sourcesCount;
    }

    public void setSourcesCount(Integer sourcesCount) {
        this.sourcesCount = sourcesCount;
    }

    @JsonProperty("synonyms_count")
    public Integer getSynonymsCount() {
        return synonymsCount;
    }

    public void setSynonymsCount(Integer synonymsCount) {
        this.synonymsCount = synonymsCount;
    }

    @Override
    public String toString() {
        return "SpeciesEntryMeta{" +
                "imagesCount=" + imagesCount +
                ", sourcesCount=" + sourcesCount +
                ", synonymsCount=" + synonymsCount +
                '}';
    }
}
