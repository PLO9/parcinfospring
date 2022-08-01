package sn.isi.parcinfo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nom;
    private int port;
    @ManyToOne
    private Ingenieur ingenieur = new Ingenieur();
    @ManyToOne
    private Serveur serveur = new Serveur();
}
