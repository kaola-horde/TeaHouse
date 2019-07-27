package com.chhliu.springboot.quartz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chhliu.springboot.quartz.entity.Config;

public interface ConfigRepository extends JpaRepository<Config, Long> {

}
