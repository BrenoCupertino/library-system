package domain.books;

import observer.IObserver;
import observer.ISubject;
import domain.user.User;

import java.util.ArrayList;

public class Book implements ISubject {
    private String id;
    private String title;
    private String editor;
    private String edition;
    private String year;
    private static final int minReversesToNotify = 2;
    private ArrayList<String> authors;
    private ArrayList<BookSample> samples = new ArrayList<BookSample>();
    private ArrayList<User> reservations = new ArrayList<User>();
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public Book(String id, String name, String editor, String edition, String year, ArrayList<String> authors) {
        this.id = id;
        this.title = name;
        this.editor = editor;
        this.edition = edition;
        this.year = year;
        this.authors = authors;
    }

    public void removeReservation (User user) {
        this.reservations.remove(user);
    }

    public boolean isFullyReserved() {
        return this.reservations.size() >= this.samples.size();
    }

    public boolean isBookAvailable() {
        for(BookSample sample: this.samples) {
            if(sample.isAvaliable()) {
                return true;
            }
        }
        return false;
    }

    public BookSample getAvaliableSample() {
        for (BookSample sample : samples) {
            if (sample.isAvaliable()) {
                return sample;
            }
        }
        return null;
    }

    public void checkNumberReservations() {
        if (this.reservations.size() >= minReversesToNotify) {
            notifyObservers();
        }
    }

    public void addReservation(User user) {
        user.addReservation(this);

        this.reservations.add(user);

        checkNumberReservations();
    }

    public String getSampleLoanInfo(BookSample sample) {
        String loanInfo = "";
        for (User user : this.reservations) {
            //Talvez a classe User deva pegar as informações do loan, pois ele guarda a array que os guarda.
            for(LoanedBook loan : user.getLoans()) {
                if(loan.getBookSample().equals(sample)) {
                    loanInfo += "    Emprestimo por: " + user.getName() + "\n";
                    loanInfo += "    Data do emprestimo: " + loan.getLoanDate() + "\n";
                    loanInfo += "    Data limite para devolução: " + loan.getLoanReturnDate() + "\n";
                }
            }
        }
        return loanInfo;
    }

    public String getSamplesInfo() {
        String samplesInfo = "";
        for(BookSample sample: this.samples) {
            samplesInfo += "ID: " + sample.getId() + " - Status: " + sample.getMessageStatus() + "\n";
            if(!sample.isAvaliable()) {
                samplesInfo += getSampleLoanInfo(sample);
            }
        }
        return samplesInfo;
    }

    public String getReservationsinfo() {
        String reservationInfo = "";
        reservationInfo += "Qtn. de reservas: " + this.reservations.size() + "\n";
        reservationInfo += "Usu. que reservaram: ";
        for (User user : this.reservations) {
            reservationInfo += user.getName() + ", ";
        }
        return reservationInfo.substring(0, reservationInfo.length() - 1);
    }

    public String getBookInformations() {
        String informations = "";
        informations += " Titulo do livro: " + this.title + "\n";
        informations += "---------------------------------------\n";
        informations += getReservationsinfo();
        informations += "---------------------------------------\n";
        informations += getSamplesInfo();
        informations += "---------------------------------------\n";
        return informations;
    }

    @Override
    public void addObserver(IObserver user) {
        this.observers.add(user);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer: this.observers) {
            observer.update();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<BookSample> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<BookSample> samples) {
        this.samples = samples;
    }

    public ArrayList<User> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<User> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<IObserver> observers) {
        this.observers = observers;
    }
}
