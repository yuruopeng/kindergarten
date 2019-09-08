package com.qianshu.kindergarten.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WxMaService.class)
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {
  private WxMaProperties properties;

  @Autowired
  public WxMaConfiguration(WxMaProperties properties) {
    this.properties = properties;
  }

  @Bean
  @ConditionalOnMissingBean
  public WxMaService WxMaService() {
    WxMaInMemoryConfig wxMaInMemoryConfig = new WxMaInMemoryConfig();
    wxMaInMemoryConfig.setAppid(StringUtils.trimToNull(this.properties.getAppId()));
    wxMaInMemoryConfig.setSecret(StringUtils.trimToNull(this.properties.getSecret()));

    WxMaService wxMaService = new WxMaServiceImpl();
    wxMaService.setWxMaConfig(wxMaInMemoryConfig);
    return wxMaService;
  }
}
