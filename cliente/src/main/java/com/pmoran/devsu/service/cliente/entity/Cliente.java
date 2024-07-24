package com.pmoran.devsu.service.cliente.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Password", nullable = false, length = 4000)
    private String password;

    @Column(name = "Estado", nullable = false)
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "Persona_Id", referencedColumnName = "Identidad")
    private Persona data;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Persona getData() {
        return data;
    }

    public void setData(Persona data) {
        this.data = data;
    }
}
