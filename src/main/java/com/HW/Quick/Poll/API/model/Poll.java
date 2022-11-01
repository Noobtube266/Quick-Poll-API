package com.HW.Quick.Poll.API.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLL_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "question_ID")
    @NotEmpty
    private NotEmpty question;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="POLL_ID")
    @OrderBy
    @Size(min=2, max = 6)
    private Set<Size> options = new java.util.LinkedHashSet<>();

    public Set<Size> getOptions() {
        return options;
    }

    public void setOptions(Set<Size> options) {
        this.options = options;
    }

    public NotEmpty getQuestion() {
        return question;
    }

    public void setQuestion(NotEmpty question) {
        this.question = question;
    }

    // Getters and Setters omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
