package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SpeciesLight extends SpeciesCoreData {
    @JsonProperty("synonyms")
    @ElementCollection
    private List<String> synonyms;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Genus.class, optional = false,
    cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "genus_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition =
            "FOREIGN KEY (genus_id) REFERENCES genus (id)"))
    @Access(value = AccessType.FIELD)
    private Genus genusForORM;

    public SpeciesLight() {
    }

    @JsonProperty("synonyms")
    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Genus getGenusForORM() {
        return genusForORM;
    }

    public void setGenusForORM(Genus genusForORM) {
        this.genusForORM = genusForORM;
    }

    @Override
    public String toString() {
        return "SpeciesCoreData{" +
                " id=" + this.getId() +
                ", slug=" + this.getSlug() +
                ", commonName='" + this.getCommonName() + '\'' +
                ", scientificName='" + this.getScientificName() + '\'' +
                ", year=" + this.getYear() +
                ", bibliography='" + this.getBibliography() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", status=" + this.getStatus() +
                ", rank=" + this.getRank() +
                ", familyCommonName='" + this.getFamilyCommonName() + '\'' +
                ", genusId=" + this.getGenusId() +
                ", imageUrl='" + this.getImageUrl() + '\'' +
                ", genus='" + this.getGenus() + '\'' +
                ", family='" + this.getFamily() + '\'' +
                ", links=" + this.getLinks() +
                ", synonyms=" + synonyms +
                '}';
    }
}
