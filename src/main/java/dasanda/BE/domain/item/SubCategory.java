package dasanda.BE.domain.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubCategory {

    @Id
    @GeneratedValue
    @Column(name = "sub_category_id")
    private Long id;

    @NotBlank
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "major_id")
    private MajorCategory majorCategory;

    @JsonBackReference
    @OneToMany(mappedBy = "subCategory")
    private List<Item> items;

    @Builder
    protected SubCategory(String name, MajorCategory majorCategory, List<Item> items){
        this.name = name;
        this.majorCategory = majorCategory;
        this.items = items;

    }
}
