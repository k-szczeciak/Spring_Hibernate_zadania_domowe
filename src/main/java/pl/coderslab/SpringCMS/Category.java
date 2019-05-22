package pl.coderslab.SpringCMS;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "catergories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "pole nie może być puste")
    @Size(min = 5, message = "pole nie może mieć mniej niż 5 znaków")
    private String name;

    @NotNull(message = "pole nie może być puste")
    private String descriprion;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }
}

