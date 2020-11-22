package com.musta.belmo.booqs.entite;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@Entity

public class Role extends AbstractEntity implements GrantedAuthority {
	private String authority;
	
	@Override
	public boolean equals(Object another) {
		final boolean areEqual;
		if (this == another) {
			areEqual = true;
		} else if (another == null || getClass() != another.getClass()) {
			areEqual = false;
		} else if (!super.equals(another)) {
			areEqual = false;
		} else {
			final Role otherRole = (Role) another;
			areEqual = Objects.equals(getId(), otherRole.getId())
			|| Objects.equals(authority, otherRole.authority) ;
		}
		return areEqual;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), authority);
	}
}
