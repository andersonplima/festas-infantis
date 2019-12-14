/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ander
 */
public class Festa {
    private int idFesta;
    private String localFesta;
    private Date dataFesta;
    private Time horaFesta;
    private float valorFesta;
    private String observacao;

    public int getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(int idFesta) {
        this.idFesta = idFesta;
    }

    public String getLocalFesta() {
        return localFesta;
    }

    public void setLocalFesta(String localFesta) {
        this.localFesta = localFesta;
    }

    public Date getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(Date dataFesta) {
        this.dataFesta = dataFesta;
    }

    public Time getHoraFesta() {
        return horaFesta;
    }

    public void setHoraFesta(Time horaFesta) {
        this.horaFesta = horaFesta;
    }

    public float getValorFesta() {
        return valorFesta;
    }

    public void setValorFesta(float valorFesta) {
        this.valorFesta = valorFesta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
