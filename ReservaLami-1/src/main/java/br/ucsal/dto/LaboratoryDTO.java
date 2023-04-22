package br.ucsal.dto;

import org.springframework.beans.factory.annotation.Autowired;

import br.ucsal.models.Laboratory;
import br.ucsal.models.StatusLaboratory;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;

public class LaboratoryDTO {

	@Autowired
	private LaboratoryRepository repository;

	@Nonnull
	private String name;

	private String description;

	@NonNull
	private Integer machines;

	@NonNull
	private String location;

	@Nonnull
	private StatusLaboratory status;

	public LaboratoryRepository getRepository() {
		return repository;
	}

	public void setRepository(LaboratoryRepository repository) {
		this.repository = repository;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMachines() {
		return machines;
	}

	public void setMachines(Integer machines) {
		this.machines = machines;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public StatusLaboratory getStatus() {
		return status;
	}

	public void setStatus(StatusLaboratory status) {
		this.status = status;
	}

	public Laboratory save(Laboratory laboratorio) {
		return repository.save(laboratorio);
	}

}