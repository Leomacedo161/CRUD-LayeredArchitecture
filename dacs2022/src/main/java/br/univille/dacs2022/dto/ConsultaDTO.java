package br.univille.dacs2022.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.univille.coredacs2022.entity.Medico;
import br.univille.coredacs2022.entity.Paciente;
import br.univille.coredacs2022.entity.ProcedimentoRealizado;

public class ConsultaDTO {

    private long id;
    private Date data;
    private String status;
    private Paciente paciente;
    private List<ProcedimentoRealizado> listaProcedimentos = new ArrayList<>();
    private Medico medicoResponsavel;

    public List<ProcedimentoRealizado> getListaProcedimentos() {
        return listaProcedimentos;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public void setListaProcedimentos(List<ProcedimentoRealizado> listaProcedimentos) {
        this.listaProcedimentos = listaProcedimentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
