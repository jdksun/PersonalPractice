package com.syl.springInAction.chapter1.config;

import com.syl.springInAction.chapter1.BraveKnight;
import com.syl.springInAction.chapter1.Knight;
import com.syl.springInAction.chapter1.Quest;
import com.syl.springInAction.chapter1.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
