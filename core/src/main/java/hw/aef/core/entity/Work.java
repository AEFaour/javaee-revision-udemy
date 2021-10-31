/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.aef.core.entity;

/**
 *
 * @author anas.faour
 */
public class Work {

    private long id;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;

    private static int lastId;

    public Work() {
        this.id = lastId++;
    }

    public Work(String title) {
        this();
        this.title = title;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public String getGenre() {

        return genre;

    }

    public void setGenre(String genre) {

        this.genre = genre;

    }

    public int getRelease() {

        return release;

    }

    public void setRelease(int release) {

        this.release = release;

    }

    public String getSummary() {

        return summary;

    }

    public void setSummary(String summary) {

        this.summary = summary;

    }

    public Artist getMainArtist() {

        return mainArtist;

    }

    public void setMainArtist(Artist mainArtist) {

        this.mainArtist = mainArtist;

    }

}
