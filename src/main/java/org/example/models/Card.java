package org.example.models;

import java.util.List;
import java.util.Objects;

public class Card {
    private String id;
    private String name;
    private String layout;
    private int cmc;
    private List<String> colors;
    private List<String> colorIdentity;
    private String type;
    private List<String> supertypes;
    private List<String> types;
    private List<String> subtypes;
    private String rarity;
    private String set;
    private String setName;
    private String text;
    private String artist;
    private String number;
    private String power;
    private String toughness;

    public Card() {}

    public Card(String id, String name, String layout, int cmc, List<String> colors, List<String> colorIdentity,
                String type, List<String> supertypes, List<String> types, List<String> subtypes, String rarity,
                String set, String setName, String text, String flavor, String artist, String number, String power,
                String toughness, String loyalty) {
        this.id = id;
        this.name = name;
        this.layout = layout;
        this.cmc = cmc;
        this.colors = colors;
        this.colorIdentity = colorIdentity;
        this.type = type;
        this.supertypes = supertypes;
        this.types = types;
        this.subtypes = subtypes;
        this.rarity = rarity;
        this.set = set;
        this.setName = setName;
        this.text = text;
        this.artist = artist;
        this.number = number;
        this.power = power;
        this.toughness = toughness;
    }

    // Getter and Setter methods
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSupertypes() {
        return supertypes;
    }

    public void setSupertypes(List<String> supertypes) {
        this.supertypes = supertypes;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cmc == card.cmc &&
                Objects.equals(id, card.id) &&
                Objects.equals(name, card.name) &&
                Objects.equals(layout, card.layout) &&
                Objects.equals(colors, card.colors) &&
                Objects.equals(colorIdentity, card.colorIdentity) &&
                Objects.equals(type, card.type) &&
                Objects.equals(supertypes, card.supertypes) &&
                Objects.equals(types, card.types) &&
                Objects.equals(subtypes, card.subtypes) &&
                Objects.equals(rarity, card.rarity) &&
                Objects.equals(set, card.set) &&
                Objects.equals(setName, card.setName) &&
                Objects.equals(text, card.text) &&
                Objects.equals(artist, card.artist) &&
                Objects.equals(number, card.number) &&
                Objects.equals(power, card.power) &&
                Objects.equals(toughness, card.toughness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, layout, cmc, colors, colorIdentity, type,
                supertypes, types, subtypes, rarity, set, setName,
                text, artist, number, power, toughness);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
