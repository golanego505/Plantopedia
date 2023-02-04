package org.launchcode.plantopedia.models.taxa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public abstract class TaxonWithSources extends Taxon {
    @ManyToMany
    @JoinTable(name = "plant_source", inverseJoinColumns = {
            @JoinColumn(name = "source_id")
    })
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @Entity
    public static class Source {
        @JsonProperty("last_update")
        private String lastUpdate;
        @Id
        private String id;
        private String name;
        private String url;
        private String citation;

        public Source() {
        }

        @JsonProperty("last_update")
        public String getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCitation() {
            return citation;
        }

        public void setCitation(String citation) {
            this.citation = citation;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "lastUpdate='" + lastUpdate + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", citation='" + citation + '\'' +
                    '}';
        }
    }
}
