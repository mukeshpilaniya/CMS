package com.spe.ClassroomManagementSystem.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sac")
public class Sac {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sacId;

    @Column(unique = true)
    @NotNull
    private String userName;

    @Column
    @NotNull
    private String sacName;

    @Column(unique = true)
    @NotNull
    private String sacEmail;

    @OneToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="foreignId" ,nullable=false)
    private Login foreignId;
    public Sac(){

    }




    public Sac(@NotNull String userName, @NotNull String sacName, @NotNull String sacEmail) {
        this.userName = userName;
        this.sacName = sacName;
        this.sacEmail = sacEmail;
    }

    public Sac(@NotNull String userName, @NotNull String sacName, @NotNull String sacEmail, Login foreignId) {
        this.userName = userName;
        this.sacName = sacName;
        this.sacEmail = sacEmail;
        this.foreignId = foreignId;
    }

    @Override
    public String toString() {
        return "Sac{" +
                "sacId=" + sacId +
                ", userName='" + userName + '\'' +
                ", sacName='" + sacName + '\'' +
                ", sacEmail='" + sacEmail + '\'' +
                ", foreignId=" + foreignId +
                '}';
    }

    public long getSacId() {
        return sacId;
    }

    public void setSacId(long sacId) {
        this.sacId = sacId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSacName() {
        return sacName;
    }

    public void setSacName(String sacName) {
        this.sacName = sacName;
    }

    public String getSacEmail() {
        return sacEmail;
    }

    public void setSacEmail(String sacEmail) {
        this.sacEmail = sacEmail;
    }

    public Login getForeignId() {
        return foreignId;
    }

    public void setForeignId(Login foreignId) {
        this.foreignId = foreignId;
    }
}