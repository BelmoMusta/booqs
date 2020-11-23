package com.musta.belmo.booqs.security.annotation;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('admin')")
public @interface IsAdmin {
}