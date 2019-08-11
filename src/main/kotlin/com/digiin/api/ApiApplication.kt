package com.digiin.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*


@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}

@Bean
fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
    return CommandLineRunner{

        println("Let's inspect the beans provided by Spring Boot:")

        val beanNames = ctx.beanDefinitionNames
        beanNames.sort()
        for (beanName in beanNames) {
            println(beanName)
        }

    }
}