package dasanda.BE.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Column(unique = true)
    private String nickname;

    @NotBlank
    private String phone;

    @Embedded
    private Address address;

    private String role;

    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    @Builder
    protected Member(String email, String nickname, String phone, String password, String city, String street, String zipcode){
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
        this.address = Address.builder()
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();
        this.role = "MEMBER";
    }

}