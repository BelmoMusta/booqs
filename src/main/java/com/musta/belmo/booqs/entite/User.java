package com.musta.belmo.booqs.entite;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends AbstractEntity implements UserDetails {
	private String username;
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Collection<Role> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER) // EAGER forces outer join
	@JoinColumn(name = "entry_id",updatable = false, insertable = false)
	@Where(clause = "table_name = 'user'") // "id" is A's PK... modify as needed
	Set<CustomizedValue> customizedValues;
	
}
