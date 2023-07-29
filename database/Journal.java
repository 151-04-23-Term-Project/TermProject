package database;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Journal {
	private IntegerProperty idProperty;
	private StringProperty titleProperty;
	private StringProperty dateProperty;
	private StringProperty textProperty;
	
	
	public Journal() {
		this.idProperty = new SimpleIntegerProperty();
		this.titleProperty = new SimpleStringProperty();
		this.dateProperty = new SimpleStringProperty();
		this.textProperty = new SimpleStringProperty();
		
	}
	
	
	
	public int getJournalId() {
		return idProperty.get();
	}
	
	public void setJournalId(int id) {
		this.idProperty.set(id);
	}

	public IntegerProperty getJournalId() {
		return idProperty;
	}

	public String getTitle() {
		return titleProperty.get();
	}
	
	public void setTitle(String title) {
		this.titleProperty.set(title);
	}

	public StringProperty getTitle() {
		return titleProperty;	
	}
	
	
	public String getDate() {
		return dateProperty.get();
	}
	
	public void setDate(String date) {
		this.dateProperty.set(date);
	}

	public StringProperty getTitle() {
		return titleProperty;
	
	}
	
	public String getText() {
		return textProperty.get();
	}
	
	public void setText(String text) {
		this.textProperty.set(text);
	}

	public StringProperty getText() {
		return textProperty;
	
	}
	

}