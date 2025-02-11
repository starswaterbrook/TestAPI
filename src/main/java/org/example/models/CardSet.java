package org.example.models;

import java.util.Objects;


public class CardSet {
    private String code;
    private String name;
    private String releaseDate;
    private String type;
    private String block;

    public CardSet() {}

    public CardSet(String code, String name, String releaseDate, String type, String block, int cardCount) {
        this.code = code;
        this.name = name;
        this.releaseDate = releaseDate;
        this.type = type;
        this.block = block;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardSet set = (CardSet) o;
        return Objects.equals(code, set.code) &&
                Objects.equals(name, set.name) &&
                Objects.equals(releaseDate, set.releaseDate) &&
                Objects.equals(type, set.type) &&
                Objects.equals(block, set.block);
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, name, releaseDate, type, block);
    }
}
