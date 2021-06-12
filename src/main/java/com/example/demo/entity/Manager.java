package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manager extends AbstractEntity{

    @Column(name = "name", nullable = true, length = 60)
    private String name;
    @Column(name = "telephone", nullable = true, length = 60)
    private String telephone;
    @Column(name = "mail", nullable = true, length = 60)
    private String mail;
    @OneToMany(mappedBy = "manager")
    private Collection<Archive> archivesById;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Collection<Archive> getArchivesById() {
        return archivesById;
    }

    public void setArchivesById(Collection<Archive> archivesById) {
        this.archivesById = archivesById;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
