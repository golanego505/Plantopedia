package org.launchcode.plantopedia.responses.metadata;

public class ListMeta {
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ListMeta{" +
                "total=" + total +
                '}';
    }
}
