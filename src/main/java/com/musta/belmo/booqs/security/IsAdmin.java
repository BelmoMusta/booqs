package com.musta.belmo.booqs.security;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('admin')")
public @interface IsAdmin {
}