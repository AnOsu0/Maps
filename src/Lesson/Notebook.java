package Lesson;

import java.util.Objects;

public class Notebook {
    private String producer;
    private String model;

    public Notebook(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return producer + " " + model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(producer, notebook.producer) && Objects.equals(model, notebook.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model);
    }
}
