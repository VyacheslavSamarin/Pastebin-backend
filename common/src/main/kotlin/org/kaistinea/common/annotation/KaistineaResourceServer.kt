package org.kaistinea.common.annotation

import org.kaistinea.common.config.ResourceServerConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(ResourceServerConfig::class)
annotation class KaistineaResourceServer