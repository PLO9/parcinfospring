package sn.isi.parcinfo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serveur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 100, nullable = false)
    private String adrIp;
    @ManyToOne
    private Ingenieur ingenieur = new Ingenieur();
    @OneToMany(mappedBy = "serveur")
    private List<Services> services = new ArrayList<>();


}
