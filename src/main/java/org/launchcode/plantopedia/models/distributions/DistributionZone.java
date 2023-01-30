package org.launchcode.plantopedia.models.distributions;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class DistributionZone extends TdwgUnit {
    @ManyToOne
    private DistributionZone parent;
    @ElementCollection(fetch = FetchType.LAZY, targetClass = DistributionZone.class)
    private List<DistributionZone> children;

    public DistributionZone() {}

    public DistributionZone getParent() {
        return parent;
    }

    public void setParent(DistributionZone parent) {
        this.parent = parent;
    }

    public List<DistributionZone> getChildren() {
        return children;
    }

    public void setChildren(List<DistributionZone> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "DistributionZone{" +
                "parent=" + parent +
                ", children=" + children +
                '}';
    }
}
