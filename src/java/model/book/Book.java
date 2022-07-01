/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

/**
 *
 * @author Admin
 */
public class Book {

    private int id;   
    private String ISBN;
    private String title;
    private String summary;
    private int numberOfPage;
    private String language;
    private Publisher publisher;
    private Author author;
    private String img;

    public Book() {
    }

    public Book(int id, String ISBN, String title, String summary, int numberOfPage, String language, Publisher publisher, Author author, String img) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.summary = summary;
        this.numberOfPage = numberOfPage;
        this.language = language;
        this.publisher = publisher;
        this.author = author;
        this.img = img;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", summary=" + summary + ", numberOfPage=" + numberOfPage + ", language=" + language + ", publisher=" + publisher + ", author=" + author + '}';
    }
   
    
}
