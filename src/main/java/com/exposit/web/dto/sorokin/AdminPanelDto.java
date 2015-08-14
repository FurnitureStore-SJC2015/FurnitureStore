package com.exposit.web.dto.sorokin;

import com.exposit.domain.model.sorokin.Role;

public class AdminPanelDto {

	private Role role;

	private Integer size;

	private Integer offset;

	public AdminPanelDto(Role role, Integer size, Integer offset) {
		this.role = role;
		this.size = size;
		this.offset = offset;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
