package com.dev.api.model;

public class TypesDTO {
	
	private int slot;
	private TypeDTO type;	
	
	public TypesDTO(int slot, TypeDTO type) {
		super();
		this.slot = slot;
		this.type = type;
	}
	
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public TypeDTO getType() {
		return type;
	}
	public void setType(TypeDTO type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Types [slot=" + slot + ", type=" + type + "]";
	}
	
}
