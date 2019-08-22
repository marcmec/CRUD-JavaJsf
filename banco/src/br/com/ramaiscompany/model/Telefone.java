package br.com.ramaiscompany.model;

public class Telefone {
	   	private Integer id;
	    private String orgao;
	    private String setor;
	    private String responsavel;
	    private String ramal;


	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getOrgao() {
	        return orgao;
	    }

	    public void setOrgao(String orgao) {
	        this.orgao = orgao;
	    }

	    public String getSetor() {
	        return setor;
	    }

	    public void setSetor(String setor) {
	        this.setor = setor;
	    }

	    public String getResponsavel() {
	        return responsavel;
	    }

	    public void setResponsavel(String responsavel) {
	        this.responsavel = responsavel;
	    }

	    public String getRamal() {
	        return ramal;
	    }

	    public void setRamal(String ramal) {
	        this.ramal = ramal;
	    }


	@Override
	    public String toString() {
	        return "Telefone{" +
	                "id='" + id + '\'' +
	                ", orgao='" + orgao + '\'' +
	                ", setor='" + setor + '\'' +
	                ", responsavel='" + responsavel + '\'' +
	                ", ramal='" + ramal + '\'' +
	                '}';
	    }
	}
