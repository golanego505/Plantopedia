package org.launchcode.plantopedia.models.metadata;

public class SpeciesEntryMeta extends EntryMeta {
    private Integer imagesCount;
    private Integer sourcesCount;
    private Integer synonymsCount;

    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public Integer getSourcesCount() {
        return sourcesCount;
    }

    public void setSourcesCount(Integer sourcesCount) {
        this.sourcesCount = sourcesCount;
    }

    public Integer getSynonymsCount() {
        return synonymsCount;
    }

    public void setSynonymsCount(Integer synonymsCount) {
        this.synonymsCount = synonymsCount;
    }
}
